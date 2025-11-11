package Ex1;
/**
 * Esta é a interface principal do padrão Strategy.
 *
 * Ela funciona como um "contrato" ou "molde". Qualquer classe de cálculo
 * (VaR, ES, etc.) TEM que implementar o método 'calcular'.
 *
 * Isso nos permite trocar o algoritmo em tempo de execução, que era
 * o requisito principal da questão.
 */
public interface EstrategiaAnaliseRisco {

    /**
     * Todos os algoritmos de cálculo devem implementar isso.
     *
     * @param dados Os dados financeiros que o cálculo vai usar.
     * @return O resultado (simulado) da análise.
     */
    String calcular(DadosContextoFinanceiro dados);
}
