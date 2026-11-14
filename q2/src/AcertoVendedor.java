
public class AcertoVendedor {

    public void imprimir(Lote lote) {

        if (lote.getComprador() == null) {
            System.out.println("Lote nao vendido. Sem acerto.");
            return;
        }

        double venda = lote.getLanceAtual();
        double comissao = lote.calcularComissao();

        System.out.println("\n===== ACERTO DO VENDEDOR =====");

        System.out.printf("Valor da venda: R$ %.2f%n", venda);
        System.out.println("Regra: " + lote.getRegraComissao().getNome());
        System.out.printf("Comissao: R$ %.2f%n", comissao);
        System.out.printf("Valor liquido: R$ %.2f%n", venda - comissao);
    }
}
