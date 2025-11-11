package Ex3;
/**
 * ESTADO CONCRETO: Operação Normal
 */
class EstadoOperacaoNormal implements EstadoUsina {
    @Override
    public void monitorar(Usina usina, DadosReator dados) {
        // REGRA: OPERACAO_NORMAL → ALERTA_AMARELO
        if (dados.getTemperatura() > 300) {
            System.out.println("ALERTA: Temperatura > 300C. Nível Amarelo.");
            usina.setEstado(usina.ESTADO_ALERTA_AMARELO);
        }
    }

    @Override
    public void ligar(Usina usina) {
        System.out.println("Usina já está em operação.");
    }

    @Override
    public void desligar(Usina usina) {
        System.out.println("Desligando usina...");
        usina.setEstado(usina.ESTADO_DESLIGADA);
    }

    @Override
    public void entrarManutencao(Usina usina) {
        System.out.println("ERRO: Desligue a usina antes de entrar em manutenção!");
    }

    @Override
    public void sairManutencao(Usina usina) {
        // Ignora
    }
}
