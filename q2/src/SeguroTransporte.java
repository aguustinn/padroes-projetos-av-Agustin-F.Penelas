
public class SeguroTransporte extends DecoradorServico {

    public SeguroTransporte(ComponenteFatura fatura) {
        super(fatura);
    }

    protected String getDescricao() {
        return "Seguro de transporte";
    }

    protected double getCusto() {
        return fatura.getValorVenda() * 0.015;
    }
}
