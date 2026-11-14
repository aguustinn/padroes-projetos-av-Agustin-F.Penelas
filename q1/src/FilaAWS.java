public class FilaAWS implements FilaMensagens {

    private String identificador;

    public FilaAWS(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getCustoMensal() {
        return 0.40;
    }
}