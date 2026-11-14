
public class ComissaoImoveis implements RegraComissao {

    public double calcular(double valor) {
        return valor * 0.03 + 1500;
    }

    public String getNome() {
        return "Imoveis - 3% + R$ 1.500";
    }
}
