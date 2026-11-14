
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditorLances implements Interessado {

    private List<String> registros = new ArrayList<>();

    @Override
    public void atualizar(Lote lote, Lance lance) {

        String data = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        registros.add(data + " | Lote: " + lote.getNome()
                + " | Participante: " + lance.getParticipante().getNome()
                + " | Valor: R$ " + lance.getValor());
    }

    public void imprimirHistorico() {

        System.out.println("\n===== HISTORICO DO AUDITOR =====");

        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
