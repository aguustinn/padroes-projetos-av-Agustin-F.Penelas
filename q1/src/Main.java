public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        ServicoProvisionamento servico =
            new ServicoProvisionamento();

        Configuracao.getInstancia();

        Thread t1 = new Thread(() ->
            servico.provisionar(
                "Ambiente AWS 1", "AWS", 2, 100
            )
        );

        Thread t2 = new Thread(() ->
            servico.provisionar(
                "Ambiente AWS 2", "AWS", 3, 200
            )
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();


        servico.provisionar(
            "Ambiente Azure", "Azure", 2, 500
        );


        servico.provisionar(
            "Ambiente Caro", "AWS", 20, 5000
        );

        Auditoria.getInstancia().mostrarHistorico();
    }
}