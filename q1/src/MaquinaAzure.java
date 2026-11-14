public class MaquinaAzure implements MaquinaVirtual {

    private String identificador;

    public MaquinaAzure(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getCustoMensal() {
        return 0.12 * 730;
    }
}