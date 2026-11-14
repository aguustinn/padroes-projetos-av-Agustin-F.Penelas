
public class FaturaBase implements ComponenteFatura {

    private String nomeLote;
    private double valorVenda;

    public FaturaBase(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    public double getValorTotal() {
        return valorVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void imprimir() {
        System.out.printf("Lote: %s | Venda: R$ %.2f%n",
                nomeLote, valorVenda);
    }
}
