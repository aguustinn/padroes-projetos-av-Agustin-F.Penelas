import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAzure implements FabricaNuvem {

    private static AtomicInteger maquinas = new AtomicInteger(1);
    private static AtomicInteger armazenamentos = new AtomicInteger(1);
    private static AtomicInteger filas = new AtomicInteger(1);

    public MaquinaVirtual criarMaquina() {
        return new MaquinaAzure(
            "vm-" + maquinas.getAndIncrement()
        );
    }

    public Armazenamento criarArmazenamento(int gb) {
        return new ArmazenamentoAzure(
            "blob://container-" + armazenamentos.getAndIncrement(), gb
        );
    }

    public FilaMensagens criarFila() {
        return new FilaAzure(
            "sb-" + filas.getAndIncrement()
        );
    }

    public String getProvedor() {
        return "Azure";
    }

    public double getCustoHoraMaquina() {
        return 0.12;
    }

    public double getCustoGb() {
        return 0.02;
    }

    public double getCustoFila() {
        return 0.50;
    }
}