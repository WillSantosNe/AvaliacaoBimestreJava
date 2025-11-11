/**
 * Um objeto simples para carregar a resposta de volta para o cliente,
 * em vez de um HashMap complicado.
 */
public class RespostaTransacao {
    private boolean aprovada;
    private String mensagem;

    public RespostaTransacao(boolean aprovada, String mensagem) {
        this.aprovada = aprovada;
        this.mensagem = mensagem;
    }

    // Getters
    public boolean isAprovada() {
        return aprovada;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "RespostaTransacao [aprovada=" + aprovada + ", mensagem=" + mensagem + "]";
    }
}
