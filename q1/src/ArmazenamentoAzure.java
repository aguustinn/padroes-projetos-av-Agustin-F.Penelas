public class ArmazenamentoAzure implements Armazenamento {

    private String identificador;
    private int gb;

    public ArmazenamentoAzure(String identificador, int gb) {
        this.identificador = identificador;
        this.gb = gb;
    }

    public String getIdentificador() {
        return identificador;
    }

    public double getCustoMensal() {
        return gb * 0.02;
    }
}