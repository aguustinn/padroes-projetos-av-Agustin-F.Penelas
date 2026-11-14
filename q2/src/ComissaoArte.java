
public class ComissaoArte implements RegraComissao {

    public double calcular(double valor) {
        return valor * 0.20;
    }

    public String getNome() {
        return "Arte - 20%";
    }
}
