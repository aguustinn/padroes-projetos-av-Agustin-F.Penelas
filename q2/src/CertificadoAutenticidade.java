
public class CertificadoAutenticidade extends DecoradorServico {

    public CertificadoAutenticidade(ComponenteFatura fatura) {
        super(fatura);
    }

    protected String getDescricao() {
        return "Certificado de autenticidade";
    }

    protected double getCusto() {
        return 300;
    }
}
