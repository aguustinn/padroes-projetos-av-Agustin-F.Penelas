
import java.util.ArrayList;
import java.util.List;

public class Lote {

    private String nome;
    private String categoria;
    private double precoInicial;
    private double precoReserva;
    private double lanceAtual;
    private boolean aberto = true;

    private Participante comprador;

    private List<Lance> lances = new ArrayList<>();
    private List<Interessado> interessados = new ArrayList<>();

    private RegraComissao regraComissao;

    public Lote(String nome, String categoria,
                double precoInicial, double precoReserva,
                RegraComissao regraComissao) {

        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getLanceAtual() {
        return lanceAtual;
    }

    public Participante getComprador() {
        return comprador;
    }

    public RegraComissao getRegraComissao() {
        return regraComissao;
    }

    public void adicionarInteressado(Interessado interessado) {
        if (!interessados.contains(interessado)) {
            interessados.add(interessado);
        }
    }

    public void removerInteressado(Interessado interessado) {
        interessados.remove(interessado);
    }

    public void trocarRegraComissao(RegraComissao novaRegra) {
        if (aberto) {
            regraComissao = novaRegra;
            System.out.println("Comissao alterada para: "
                    + novaRegra.getNome());
        }
    }

    public boolean darLance(Participante participante, double valor) {

        if (!aberto) {
            System.out.println("Lance recusado: lote encerrado.");
            return false;
        }

        double minimo = lanceAtual * 1.05;

        if (valor < minimo) {
            System.out.printf("Lance recusado! Minimo: R$ %.2f%n", minimo);
            return false;
        }

        Lance lance = new Lance(participante, valor);

        lances.add(lance);
        lanceAtual = valor;
        comprador = participante;

        System.out.println("\nLance aceito: "
                + participante.getNome() + " ofereceu R$ " + valor);

        for (Interessado interessado :
                new ArrayList<>(interessados)) {

            if (interessado != participante) {
                interessado.atualizar(this, lance);
            }
        }

        return true;
    }

    public boolean encerrar() {

        aberto = false;

        System.out.println("\n===== ENCERRAMENTO: " + nome + " =====");

        if (!lances.isEmpty() && lanceAtual >= precoReserva) {
            System.out.println("LOTE VENDIDO por R$ " + lanceAtual
                    + " para " + comprador.getNome());
            return true;
        }

        comprador = null;
        System.out.println("LOTE NAO VENDIDO.");
        return false;
    }

    public double calcularComissao() {
        if (comprador == null) {
            return 0;
        }

        return regraComissao.calcular(lanceAtual);
    }
}
