public class MaquinaAWS implements MaquinaVirtual {

    private String identificador;

    public MaquinaAWS(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getCustoMensal() {
        return 0.10 * 730;
    }
}