import java.util.List;

public class Ambiente {

    private String nome;
    private String provedor;
    private String regiao;

    private List<MaquinaVirtual> maquinas;
    private Armazenamento armazenamento;
    private FilaMensagens fila;

    private double custo;

    public Ambiente(
        String nome,
        String provedor,
        String regiao,
        List<MaquinaVirtual> maquinas,
        Armazenamento armazenamento,
        FilaMensagens fila
    ) {

        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;

        calcularCusto();
    }

    private void calcularCusto() {

        custo = armazenamento.getCustoMensal()
             + fila.getCustoMensal();

        for (MaquinaVirtual maquina : maquinas) {
            custo += maquina.getCustoMensal();
        }
    }

    public double getCusto() {
        return custo;
    }

    public void mostrarResumo() {

        System.out.println("\n===== AMBIENTE CRIADO =====");

        System.out.println("Nome: " + nome);
        System.out.println("Provedor: " + provedor);
        System.out.println("Região: " + regiao);

        for (MaquinaVirtual maquina : maquinas) {
            System.out.println(
                "Máquina: " + maquina.getIdentificador()
            );
        }

        System.out.println(
            "Armazenamento: "
            + armazenamento.getIdentificador()
        );

        System.out.println(
            "Fila: " + fila.getIdentificador()
        );

        System.out.printf(
            "Custo mensal: R$ %.2f%n", custo
        );
    }
}