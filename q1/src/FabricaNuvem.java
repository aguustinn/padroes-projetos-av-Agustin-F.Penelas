public interface FabricaNuvem {

    MaquinaVirtual criarMaquina();

    Armazenamento criarArmazenamento(int gb);

    FilaMensagens criarFila();

    String getProvedor();

    double getCustoHoraMaquina();

    double getCustoGb();

    double getCustoFila();
}