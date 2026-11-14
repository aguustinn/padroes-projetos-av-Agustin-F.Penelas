import java.io.FileInputStream;
import java.util.Properties;

public class Configuracao {

    private static Configuracao instancia;

    private String regiao;
    private double orcamento;

    private Configuracao() {

    Properties propriedades = new Properties();

    try {
        propriedades.load(
            new FileInputStream("config.properties")
        );

    } catch (Exception e) {
        System.out.println("Usando configuração padrão.");
    }

    regiao = propriedades.getProperty(
        "regiao", "sa-east-1"
    );

    orcamento = Double.parseDouble(
        propriedades.getProperty("orcamento", "1000")
    );
}

    public static synchronized Configuracao getInstancia() {

        if (instancia == null) {
            instancia = new Configuracao();
        }

        return instancia;
    }

    public String getRegiao() {
        return regiao;
    }

    public double getOrcamento() {
        return orcamento;
    }
}