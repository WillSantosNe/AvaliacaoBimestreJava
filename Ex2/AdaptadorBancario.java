import java.util.HashMap;

/**
 * Esta é a "cola".
 * 1. Ela "implementa" a interface nova (ProcessadorTransacoes),
 * fingindo ser o sistema moderno.
 * 2. Ela "contém" uma instância do sistema legado (SistemaBancarioLegado)
 * para fazer o trabalho sujo.
 */
public class AdaptadorBancario implements ProcessadorTransacoes {

    // O adaptador "guarda" uma referência para o sistema antigo
    private SistemaBancarioLegado sistemaLegado;

    public AdaptadorBancario(SistemaBancarioLegado sistemaLegado) {
        this.sistemaLegado = sistemaLegado;
    }

    /**
     * Este é o método que o cliente chama.
     * Aqui acontece a "tradução" (adaptação) de IDA.
     */
    @Override
    public RespostaTransacao autorizar(String cartao, double valor, String moeda) {

        System.out.println("ADAPTADOR: Recebido pedido moderno. Traduzindo para o legado...");

        // Converte os dados modernos para o formato legado (HashMap)
        HashMap<String, Object> parametrosLegado = new HashMap<>();
        parametrosLegado.put("CARTAO_LEGADO", cartao);
        parametrosLegado.put("VALOR_TOTAL", valor);

        // Trata a restrição de conversão de moeda
        parametrosLegado.put("COD_MOEDA", converterMoedaParaCodigo(moeda));

        // Adiciona o campo obrigatório que o legado exige
        // (e que a interface nova não tem)
        parametrosLegado.put("ID_TERMINAL", "LOJA_ONLINE_001");

        // Chama o sistema legado com o formato traduzido
        HashMap<String, Object> respostaLegada = sistemaLegado.processarTransacao(parametrosLegado);

        // Traduz a resposta (bidirecional)
        // Converte o HashMap de resposta do legado para o objeto moderno
        System.out.println("ADAPTADOR: Traduzindo resposta do legado para o moderno...");
        return converterRespostaLegadaParaModerna(respostaLegada);
    }

    /**
     * Método privado (lógica interna) para converter a moeda.
     */
    private int converterMoedaParaCodigo(String moeda) {
        switch (moeda.toUpperCase()) {
            case "USD":
                return 1;
            case "EUR":
                return 2;
            case "BRL":
            default:
                return 3; // BRL é o padrão
        }
    }

    /**
     * Método privado (lógica interna) para a tradução de VOLTA.
     */
    private RespostaTransacao converterRespostaLegadaParaModerna(HashMap<String, Object> respostaLegada) {
        // Pega os dados do HashMap legado
        int statusCode = (int) respostaLegada.get("status_code");
        String mensagem = (String) respostaLegada.get("mensagem_retorno");

        // Traduz para o formato moderno
        boolean aprovada = (statusCode == 200);
        String mensagemModerna = "Status: " + mensagem + " (Cod: " + statusCode + ")";

        return new RespostaTransacao(aprovada, mensagemModerna);
    }
}
