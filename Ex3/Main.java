package Ex3;
public class Main {
    public static void main(String[] args) {
        Usina usina = new Usina();

        // Dados normais
        DadosReator dadosNormais = new DadosReator(250, 100, true);
        // Dados perigosos (Nível Amarelo)
        DadosReator dadosAmarelos = new DadosReator(350, 150, true);
        // Dados muito perigosos (Nível Vermelho)
        DadosReator dadosVermelhos = new DadosReator(450, 200, true);
        // Dados de emergência (Falha no resfriamento)
        DadosReator dadosEmergencia = new DadosReator(450, 200, false);

        // Ligando
        usina.ligar(); // Vai para OPERACAO_NORMAL
        usina.atualizarSensores(dadosNormais); // Tudo OK

        // Simulando Aumento de Temperatura
        System.out.println("\n=== SIMULANDO AQUECIMENTO ===");
        usina.atualizarSensores(dadosAmarelos); // Transição: NORMAL -> AMARELO
        usina.atualizarSensores(dadosVermelhos); // Transição: AMARELO -> VERMELHO

        // Tentando transição perigosa (não deve funcionar)
        System.out.println("\n=== TENTANDO DESLIGAR EM ALERTA ===");
        usina.desligar(); // Ação bloqueada pelo EstadoAlertaVermelho

        // Simulando Emergência
        System.out.println("\n=== SIMULANDO FALHA GERAL ===");
        usina.atualizarSensores(dadosEmergencia); // Transição: VERMELHO -> EMERGENCIA
        usina.atualizarSensores(dadosNormais); // Sensores ignorados

        // Manutenção
        System.out.println("\n=== ENTRANDO EM MANUTENÇÃO ===");
        usina.solicitarManutencao(); // Transição: EMERGENCIA -> MANUTENCAO
        usina.atualizarSensores(dadosVermelhos); // Sensores ignorados (override)
        usina.concluirManutencao(); // Transição: MANUTENCAO -> DESLIGADA

        // Testando manutenção a partir de 'Desligada'
        System.out.println("\n=== TESTANDO MANUTENÇÃO NORMAL ===");
        usina.solicitarManutencao(); // Transição: DESLIGADA -> MANUTENCAO
        usina.concluirManutencao(); // Transição: MANUTENCAO -> DESLIGADA
    }
}
