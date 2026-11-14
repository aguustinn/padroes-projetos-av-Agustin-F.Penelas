
public class ComissaoEletronicos implements RegraComissao {

    public double calcular(double valor) {
        return Math.max(valor * 0.12, 50);
    }

    public String getNome() {
        return "Eletronicos - 12%, minimo R$ 50";
    }
}
