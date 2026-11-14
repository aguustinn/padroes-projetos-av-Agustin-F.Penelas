
public class Participante implements Interessado {

    private String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void atualizar(Lote lote, Lance lance) {
        System.out.println(nome + " recebeu aviso: "
                + lote.getNome() + " - R$ " + lance.getValor());
    }

    public void acompanhar(Lote lote) {
        lote.adicionarInteressado(this);
    }

    public void deixarDeAcompanhar(Lote lote) {
        lote.removerInteressado(this);
    }
}
