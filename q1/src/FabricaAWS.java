import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAWS implements FabricaNuvem {

    private static AtomicInteger maquinas = new AtomicInteger(1);
    private static AtomicInteger armazenamentos = new AtomicInteger(1);
    private static AtomicInteger filas = new AtomicInteger(1);

    public MaquinaVirtual criarMaquina() {
        return new MaquinaAWS(
            "i-" + maquinas.getAndIncrement()
        );
    }

    public Armazenamento criarArmazenamento(int gb) {
        return new ArmazenamentoAWS(
            "s3://bucket-" + armazenamentos.getAndIncrement(), gb
        );
    }

    public FilaMensagens criarFila() {
        return new FilaAWS(
            "sqs-" + filas.getAndIncrement()
        );
    }

    public String getProvedor() {
        return "AWS";
    }

    public double getCustoHoraMaquina() {
        return 0.10;
    }

    public double getCustoGb() {
        return 0.023;
    }

    public double getCustoFila() {
        return 0.40;
    }
}