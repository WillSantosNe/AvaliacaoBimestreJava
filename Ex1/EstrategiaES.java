package Ex1;
/**
 * Implementação específica para o cálculo do ES.
 * Outra "estratégia" que o processador pode usar.
 */
public class EstrategiaES implements EstrategiaAnaliseRisco {

    @Override
    public String calcular(DadosContextoFinanceiro dados) {
        // Simulação do cálculo
        System.out.println("LOG: Calculando Expected Shortfall (ES)...");
        System.out.printf("     - Dados: Valor=R$%.2f, Horizonte=%d dias\n",
                dados.getValorPortfolio(), dados.getHorizonteDias());

        return "[RESULTADO SIMULADO] Expected Shortfall (ES) calculado.";
    }
}
