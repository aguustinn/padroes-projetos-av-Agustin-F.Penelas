
public class Main {

    public static void main(String[] args) {

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");

        PainelLeiloeiro painel = new PainelLeiloeiro();
        AuditorLances auditor = new AuditorLances();

        Lote arte = new Lote(
                "Pintura Antiga",
                "Arte",
                1000,
                1400,
                new ComissaoArte()
        );

        Lote carro = new Lote(
                "Carro Classico",
                "Veiculos",
                10000,
                30000,
                new ComissaoVeiculos()
        );

        Interessado[] interessados = {
            ana, bruno, carla, painel, auditor
        };

        for (Interessado interessado : interessados) {
            arte.adicionarInteressado(interessado);
            carro.adicionarInteressado(interessado);
        }

        System.out.println("===== LEILAO ONLINE =====");

        arte.darLance(ana, 1100);

        arte.darLance(bruno, 1150);

        arte.darLance(bruno, 1200);

        ana.deixarDeAcompanhar(arte);

        System.out.println("\nAna deixou de acompanhar a pintura.");

        arte.darLance(carla, 1300);

        arte.trocarRegraComissao(
                new ComissaoEletronicos()
        );

        arte.darLance(bruno, 1500);
        carro.darLance(carla, 10500);

        boolean vendidoArte = arte.encerrar();
        boolean vendidoCarro = carro.encerrar();

        AcertoVendedor acerto = new AcertoVendedor();

        if (vendidoArte) {
            acerto.imprimir(arte);
        }

        if (vendidoCarro) {
            acerto.imprimir(carro);
        }

        if (vendidoArte) {

            ComponenteFatura fatura = new FaturaBase(
                    arte.getNome(),
                    arte.getLanceAtual()
            );

            fatura = new SeguroTransporte(fatura);

            fatura = new CertificadoAutenticidade(fatura);

            fatura = new EmbalagemEspecial(fatura);

            fatura = new CertificadoAutenticidade(fatura);

            System.out.println("\n===== FATURA DO COMPRADOR =====");

            fatura.imprimir();

            System.out.printf(
                    "TOTAL A PAGAR: R$ %.2f%n",
                    fatura.getValorTotal()
            );
        }

        auditor.imprimirHistorico();

        System.out.println("\n===== FIM DO LEILAO =====");
    }
}
