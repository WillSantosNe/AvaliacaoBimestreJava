package Ex1;
/**
 * Implementação específica para o Teste de Estresse.
 * A terceira "estratégia".
 */
public class EstrategiaTesteEstresse implements EstrategiaAnaliseRisco {

    @Override
    public String calcular(DadosContextoFinanceiro dados) {
        // Simulação do cálculo
        System.out.println("LOG: Executando Teste de Estresse...");
        System.out.printf("     - Cenário: '%s'\n", dados.getCenarioMercado());

        return "[RESULTADO SIMULADO] Teste de Estresse concluído.";
    }
}
