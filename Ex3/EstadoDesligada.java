package Ex3;
/**
 * ESTADO CONCRETO: Desligada
 */
class EstadoDesligada implements EstadoUsina {
    @Override
    public void monitorar(Usina usina, DadosReator dados) {
        // Desligada, ignora sensores
    }

    @Override
    public void ligar(Usina usina) {
        System.out.println("Iniciando reator...");
        // Transição válida
        usina.setEstado(usina.ESTADO_OPERACAO_NORMAL);
    }

    @Override
    public void desligar(Usina usina) {
        System.out.println("Usina já está desligada.");
    }

    @Override
    public void entrarManutencao(Usina usina) {
        System.out.println("Entrando em manutenção.");
        // Transição válida
        usina.setEstado(usina.ESTADO_MANUTENCAO);
    }

    @Override
    public void sairManutencao(Usina usina) {
        // Ignora
    }
}
