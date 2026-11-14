
import java.util.HashMap;
import java.util.Map;

public class PainelLeiloeiro implements Interessado {

    private Map<String, Integer> totais = new HashMap<>();
    private Map<String, Double> maiores = new HashMap<>();

    @Override
    public void atualizar(Lote lote, Lance lance) {

        String nome = lote.getNome();

        totais.put(nome, totais.getOrDefault(nome, 0) + 1);
        maiores.put(nome, lance.getValor());

        System.out.println("[PAINEL] " + nome
                + " | Maior lance: R$ " + lance.getValor()
                + " | Total: " + totais.get(nome));
    }
}
