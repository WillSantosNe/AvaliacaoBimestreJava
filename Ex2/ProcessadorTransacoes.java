/**
 * Este é o "contrato" que o nosso sistema novo quer usar.
 * É simples, limpo e usa tipos de dados normais (String, double).
 */
public interface ProcessadorTransacoes {

    /**
     * O cliente (Loja) vai chamar este método.
     * @return Um objeto de RespostaTransacao simples.
     */
    RespostaTransacao autorizar(String cartao, double valor, String moeda);
}
