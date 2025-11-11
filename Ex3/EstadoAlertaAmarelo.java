package Ex3;
/**
 * ESTADO CONCRETO: Alerta Amarelo
 */
class EstadoAlertaAmarelo implements EstadoUsina {
    @Override
    public void monitorar(Usina usina, DadosReator dados) {
        // REGRA: ALERTA_AMARELO → ALERTA_VERMELHO
        // (Simplificando a regra dos 30s)
        if (dados.getTemperatura() > 400) {
            System.out.println("PERIGO: Temperatura > 400C. Nível Vermelho.");
            usina.setEstado(usina.ESTADO_ALERTA_VERMELHO);
        }
        // REGRA: Bidirecional (volta ao normal)
        else if (dados.getTemperatura() <= 300) {
            System.out.println("INFO: Temperatura estabilizada. Voltando ao normal.");
            usina.setEstado(usina.ESTADO_OPERACAO_NORMAL);
        }
    }

    @Override
    public void ligar(Usina usina) { /* Ignora */ }

    @Override
    public void desligar(Usina usina) {
        System.out.println("Desligando usina a partir do Alerta Amarelo...");
        usina.setEstado(usina.ESTADO_DESLIGADA);
    }

    @Override
    public void entrarManutencao(Usina usina) {
        System.out.println("ERRO: Desligue a usina antes de entrar em manutenção!");
    }

    @Override
    public void sairManutencao(Usina usina) { /* Ignora */ }
}
