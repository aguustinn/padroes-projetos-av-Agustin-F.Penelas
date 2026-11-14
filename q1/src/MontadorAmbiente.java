import java.util.ArrayList;
import java.util.List;

public class MontadorAmbiente {

    private FabricaNuvem fabrica;

    public MontadorAmbiente(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public Ambiente montar(
        String nome,
        int quantidadeMaquinas,
        int gb
    ) {

        List<MaquinaVirtual> maquinas = new ArrayList<>();

        for (int i = 0; i < quantidadeMaquinas; i++) {
            maquinas.add(fabrica.criarMaquina());
        }

        Armazenamento armazenamento =
            fabrica.criarArmazenamento(gb);

        FilaMensagens fila = fabrica.criarFila();

        return new Ambiente(
            nome,
            fabrica.getProvedor(),
            Configuracao.getInstancia().getRegiao(),
            maquinas,
            armazenamento,
            fila
        );
    }
}