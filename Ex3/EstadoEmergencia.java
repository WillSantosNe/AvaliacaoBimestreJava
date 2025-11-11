package Ex3;
/**
 * ESTADO CONCRETO: Emergência
 *
 * Este é um estado final. A única saída é a manutenção.
 * Note que é impossível chegar aqui sem passar pelo Vermelho,
 * pois só o EstadoAlertaVermelho tem a lógica para fazer essa transição.
 */
class EstadoEmergencia implements EstadoUsina {
    @Override
    public void monitorar(Usina usina, DadosReator dados) {
        System.out.println("...EM EMERGÊNCIA, SENSORES TRAVADOS...");
    }

    // Em emergência, todas as operações normais são bloqueadas
    @Override
    public void ligar(Usina usina) {
        System.out.println("BLOQUEADO: EM EMERGÊNCIA");
    }

    @Override
    public void desligar(Usina usina) {
        System.out.println("BLOQUEADO: EM EMERGÊNCIA");
    }

    @Override
    public void entrarManutencao(Usina usina) {
        System.out.println("Evacuando e movendo para manutenção de emergência.");
        usina.setEstado(usina.ESTADO_MANUTENCAO);
    }

    @Override
    public void sairManutencao(Usina usina) { /* Ignora */ }
}
