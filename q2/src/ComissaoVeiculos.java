
public class ComissaoVeiculos implements RegraComissao {

    public double calcular(double valor) {
        return Math.min(valor * 0.08, 5000);
    }

    public String getNome() {
        return "Veiculos - 8%, maximo R$ 5.000";
    }
}
