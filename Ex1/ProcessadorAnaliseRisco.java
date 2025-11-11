package Ex1;
/**
 * Esta é a classe principal que o Main vai usar.
 *
 * Ela guarda a estratégia de cálculo que está ativa no momento
 * (seja VaR, ES, etc.) e os dados financeiros.
 */
public class ProcessadorAnaliseRisco {

    // Guarda a estratégia que vamos usar.
    private EstrategiaAnaliseRisco estrategiaAtual;

    // Os dados financeiros que vamos passar para o cálculo.
    private DadosContextoFinanceiro dadosContexto;

    public ProcessadorAnaliseRisco(DadosContextoFinanceiro dadosContexto) {
        this.dadosContexto = dadosContexto;
        this.estrategiaAtual = null; // Começa sem nada
    }

    /**
     * O método mais importante: permite ao cliente (Main)
     * trocar o algoritmo que será usado na próxima vez.
     */
    public void setEstrategia(EstrategiaAnaliseRisco novaEstrategia) {
        this.estrategiaAtual = novaEstrategia;
    }

    /**
     * Permite atualizar os dados (ex: se o portfólio mudar).
     */
    public void setDadosContexto(DadosContextoFinanceiro novosDados) {
        this.dadosContexto = novosDados;
    }

    /**
     * O cliente (Main) chama este método para rodar o cálculo.
     * O processador apenas "delega" a tarefa para a estratégia
     * que está guardada em 'estrategiaAtual'.
     */
    public String executarAnalise() {
        if (estrategiaAtual == null) {
            throw new IllegalStateException("Nenhuma estratégia de análise foi definida.");
        }

        // Manda a estratégia atual fazer o trabalho
        return this.estrategiaAtual.calcular(this.dadosContexto);
    }
}
