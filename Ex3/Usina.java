package Ex3;
/**
 * Esta é a classe principal. Note como ela é "burra".
 * Ela não tem NENHUM "if (estado == ALERTA_VERMELHO)".
 *
 * Ela apenas guarda uma referência para o estado atual e
 * repassa todas as chamadas para ele.
 */
public class Usina {

    // --- Ponto importante do State ---
    // Criamos instâncias únicas de cada estado.
    // Isso economiza memória (parecido com o padrão Flyweight).
    public final EstadoUsina ESTADO_DESLIGADA = new EstadoDesligada();
    public final EstadoUsina ESTADO_OPERACAO_NORMAL = new EstadoOperacaoNormal();
    public final EstadoUsina ESTADO_ALERTA_AMARELO = new EstadoAlertaAmarelo();
    public final EstadoUsina ESTADO_ALERTA_VERMELHO = new EstadoAlertaVermelho();
    public final EstadoUsina ESTADO_EMERGENCIA = new EstadoEmergencia();
    public final EstadoUsina ESTADO_MANUTENCAO = new EstadoManutencao();
    // ---

    private EstadoUsina estadoAtual;

    public Usina() {
        // A usina sempre começa desligada
        this.estadoAtual = ESTADO_DESLIGADA;
    }

    /**
     * Este é o método crucial que os Estados vão chamar
     * para realizar a transição.
     */
    public void setEstado(EstadoUsina novoEstado) {
        this.estadoAtual = novoEstado;
        System.out.println("--- NOVO ESTADO DA USINA: " + novoEstado.getClass().getSimpleName() + " ---");
    }

    // --- Métodos públicos (API da Usina) ---
    // O cliente só chama esses métodos. A usina repassa
    // a chamada para o estado atual.

    public void atualizarSensores(DadosReator dados) {
        System.out.println("SENSOR: Temp=" + dados.getTemperatura() + "C, Resfriamento=" + dados.isSistemaResfriamentoOK());
        this.estadoAtual.monitorar(this, dados);
    }

    public void ligar() {
        this.estadoAtual.ligar(this);
    }

    public void desligar() {
        this.estadoAtual.desligar(this);
    }

    public void solicitarManutencao() {
        this.estadoAtual.entrarManutencao(this);
    }

    public void concluirManutencao() {
        this.estadoAtual.sairManutencao(this);
    }
}
