package Ex1;
/**
 * Implementação específica para o cálculo do VaR.
 * É uma das "estratégias" que podem ser usadas.
 */
public class EstrategiaVaR implements EstrategiaAnaliseRisco {

    @Override
    public String calcular(DadosContextoFinanceiro dados) {
        // Simulação do cálculo
        System.out.println("LOG: Calculando Value at Risk (VaR)...");
        System.out.printf("     - Dados: Valor=R$%.2f, Volatilidade=%.2f%%\n",
                dados.getValorPortfolio(), dados.getVolatilidade() * 100);

        return "[RESULTADO SIMULADO] VaR calculado com sucesso.";
    }
}
