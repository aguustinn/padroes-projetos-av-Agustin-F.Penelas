import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Auditoria {

    private static Auditoria instancia;

    private List<String> historico = new ArrayList<>();

    private Auditoria() {
    }

    public static synchronized Auditoria getInstancia() {

        if (instancia == null) {
            instancia = new Auditoria();
        }

        return instancia;
    }

    public synchronized void registrar(
        String ambiente,
        String provedor,
        String resultado
    ) {

        String registro = LocalDateTime.now()
            + " | Ambiente: " + ambiente
            + " | Provedor: " + provedor
            + " | Resultado: " + resultado;

        historico.add(registro);
    }

    public synchronized void mostrarHistorico() {

        System.out.println("\n===== HISTÓRICO DE AUDITORIA =====");

        for (String registro : historico) {
            System.out.println(registro);
        }

        System.out.println(
            "Total de registros: " + historico.size()
        );
    }
}