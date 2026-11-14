
public abstract class DecoradorServico implements ComponenteFatura {

    protected ComponenteFatura fatura;

    public DecoradorServico(ComponenteFatura fatura) {
        this.fatura = fatura;
    }

    protected abstract String getDescricao();
    protected abstract double getCusto();

    public double getValorTotal() {
        return fatura.getValorTotal() + getCusto();
    }

    public double getValorVenda() {
        return fatura.getValorVenda();
    }

    public void imprimir() {
        fatura.imprimir();

        System.out.printf("Servico: %s | Custo: R$ %.2f%n",
                getDescricao(), getCusto());
    }
}
