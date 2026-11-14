public class SeletorProvedor {

    public static FabricaNuvem escolher(String provedor) {

        if (provedor.equalsIgnoreCase("AWS")) {
            return new FabricaAWS();
        }

        if (provedor.equalsIgnoreCase("Azure")) {
            return new FabricaAzure();
        }

        throw new IllegalArgumentException(
            "Provedor não encontrado."
        );
    }
}