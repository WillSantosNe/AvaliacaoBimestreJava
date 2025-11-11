package Ex3;
/**
 * ESTADO CONCRETO: Manutenção (O "Override")
 *
 * Este estado "sobreescreve" os outros.
 * Note como o método 'monitorar' fica vazio. A usina pode
 * receber dados dos sensores, mas o estado de manutenção
 * decide ignorá-los.
 */
class EstadoManutencao implements EstadoUsina {
    @Override
    public void monitorar(Usina usina, DadosReator dados) {
        // "Sobreescrita": Ignora os sensores, pois está em manutenção.
        System.out.println("...em manutenção, sensores ignorados...");
    }

    @Override
    public void ligar(Usina usina) {
        System.out.println("AÇÃO BLOQUEADA: Em manutenção.");
    }

    @Override
    public void desligar(Usina usina) {
        System.out.println("AÇÃO BLOQUEADA: Saia da manutenção primeiro.");
    }

    @Override
    public void entrarManutencao(Usina usina) {
        System.out.println("Já estamos em manutenção.");
    }

    @Override
    public void sairManutencao(Usina usina) {
        System.out.println("Manutenção concluída. Sistema voltando para DESLIGADA.");
        // A única saída segura da manutenção é ir para Desligada.
        usina.setEstado(usina.ESTADO_DESLIGADA);
    }
}
