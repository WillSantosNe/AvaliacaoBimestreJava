package Ex3;
/**
 * ESTADO CONCRETO: Alerta Vermelho
 */
class EstadoAlertaVermelho implements EstadoUsina {
    @Override
    public void monitorar(Usina usina, DadosReator dados) {
        // REGRA: ALERTA_VERMELHO → EMERGENCIA
        if (!dados.isSistemaResfriamentoOK()) {
            System.out.println("!!! EMERGÊNCIA !!! FALHA NO RESFRIAMENTO!");
            usina.setEstado(usina.ESTADO_EMERGENCIA);
        }
        // REGRA: Bidirecional (volta ao amarelo)
        else if (dados.getTemperatura() <= 400) {
            System.out.println("INFO: Temperatura baixou. Voltando ao Nível Amarelo.");
            usina.setEstado(usina.ESTADO_ALERTA_AMARELO);
        }
    }

    // RESTRICAO: Prevenindo transições perigosas
    // Não podemos desligar ou ligar a partir do Alerta Vermelho.
    // A única saída segura é voltar ao Amarelo ou ir para Emergência/Manutenção.

    @Override
    public void ligar(Usina usina) {
        System.out.println("AÇÃO BLOQUEADA: Em Alerta Vermelho.");
    }

    @Override
    public void desligar(Usina usina) {
        System.out.println("AÇÃO BLOQUEADA: Em Alerta Vermelho.");
    }

    @Override
    public void entrarManutencao(Usina usina) {
        System.out.println("Forçando entrada em manutenção a partir do Alerta Vermelho.");
        usina.setEstado(usina.ESTADO_MANUTENCAO);
    }

    @Override
    public void sairManutencao(Usina usina) { /* Ignora */ }
}
