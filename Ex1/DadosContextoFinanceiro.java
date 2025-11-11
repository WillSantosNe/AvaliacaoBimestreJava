package Ex1;
/**
 * Basicamente, uma classe "burra" só para carregar os dados financeiros
 * de um lado para o outro.
 *
 * Os campos são 'final' para que, depois de criado, o objeto não
 * possa ser alterado (boa prática para evitar bugs).
 */
public class DadosContextoFinanceiro {

    private final double valorPortfolio;
    private final double volatilidade;
    private final int horizonteDias;
    private final String cenarioMercado;

    // Construtor padrão para encher o objeto
    public DadosContextoFinanceiro(
            double valorPortfolio,
            double volatilidade,
            int horizonteDias,
            String cenarioMercado) {
        this.valorPortfolio = valorPortfolio;
        this.volatilidade = volatilidade;
        this.horizonteDias = horizonteDias;
        this.cenarioMercado = cenarioMercado;
    }

    // (Sem setters, para manter a imutabilidade)

    public double getValorPortfolio() {
        return valorPortfolio;
    }

    public double getVolatilidade() {
        return volatilidade;
    }

    public int getHorizonteDias() {
        return horizonteDias;
    }

    public String getCenarioMercado() {
        return cenarioMercado;
    }
}
