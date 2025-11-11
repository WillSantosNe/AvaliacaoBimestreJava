import java.util.HashMap;

/**
 * Esta é a classe antiga que não podemos modificar.
 * Ela espera receber os dados em um formato bem específico
 * (um HashMap com chaves esquisitas).
 */
public class SistemaBancarioLegado {

    // O método antigo e complicado
    public HashMap<String, Object> processarTransacao(HashMap<String, Object> parametros) {

        System.out.println("\n--- DENTRO DO SISTEMA LEGADO ---");

        // O legado verifica seus campos obrigatórios
        if (!parametros.containsKey("ID_TERMINAL")) {
            System.out.println("LOG LEGADO: Falha. ID_TERMINAL obrigatório não encontrado.");
            return criarRespostaLegada(500, "ERRO: ID_TERMINAL_AUSENTE");
        }

        if (!parametros.containsKey("COD_MOEDA")) {
            System.out.println("LOG LEGADO: Falha. COD_MOEDA não encontrado.");
            return criarRespostaLegada(501, "ERRO: MOEDA_INVALIDA");
        }

        // Simulação do processamento
        System.out.println("LOG LEGADO: Processando dados...");
        System.out.println(" > Cartão: " + parametros.get("CARTAO_LEGADO"));
        System.out.println(" > Valor: " + parametros.get("VALOR_TOTAL"));
        System.out.println(" > Moeda (Código): " + parametros.get("COD_MOEDA"));
        System.out.println(" > Terminal: " + parametros.get("ID_TERMINAL"));

        System.out.println("LOG LEGADO: Transação Aprovada.");
        System.out.println("---------------------------------");

        // O legado retorna sua própria resposta em formato de HashMap
        return criarRespostaLegada(200, "OK");
    }

    // Helper só para simular a resposta do legado
    private HashMap<String, Object> criarRespostaLegada(int status, String msg) {
        HashMap<String, Object> resposta = new HashMap<>();
        resposta.put("status_code", status);
        resposta.put("mensagem_retorno", msg);
        return resposta;
    }
}
