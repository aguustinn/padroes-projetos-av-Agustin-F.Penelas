
public class EntregaExpressa extends DecoradorServico {

    public EntregaExpressa(ComponenteFatura fatura) {
        super(fatura);
    }

    protected String getDescricao() {
        return "Entrega expressa";
    }

    protected double getCusto() {
        return 450;
    }
}
