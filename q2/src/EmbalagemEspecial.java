
public class EmbalagemEspecial extends DecoradorServico {

    public EmbalagemEspecial(ComponenteFatura fatura) {
        super(fatura);
    }

    protected String getDescricao() {
        return "Embalagem especial";
    }

    protected double getCusto() {
        return 180;
    }
}
