public class FilaAzure implements FilaMensagens {

    private String identificador;

    public FilaAzure(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getCustoMensal() {
        return 0.50;
    }
}