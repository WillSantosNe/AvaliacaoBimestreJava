package Ex1;
public class Main {
    public static void main(String[] args) {

        // Cria os dados financeiros
        DadosContextoFinanceiro dados = new DadosContextoFinanceiro(
            1000000.00, 
            0.15,         
            30,           
            "Aumento Súbito da Taxa de Juros" 
        );

        // Cria as instâncias dos algoritmos (só uma vez)
        EstrategiaAnaliseRisco calcVaR = new EstrategiaVaR();
        EstrategiaAnaliseRisco calcES = new EstrategiaES();
        EstrategiaAnaliseRisco calcEstresse = new EstrategiaTesteEstresse();

        // Cria o processador
        ProcessadorAnaliseRisco processador = new ProcessadorAnaliseRisco(dados);

        // --- TESTANDO A TROCA DINÂMICA ---

        // Rodando com VaR
        System.out.println("--- TROCANDO ESTRATÉGIA: Value at Risk ---");
        processador.setEstrategia(calcVaR); // Define a estratégia
        System.out.println(processador.executarAnalise() + "\n");

        // Rodando com ES (mesmo processador, mesmos dados)
        System.out.println("--- TROCANDO ESTRATÉGIA: Expected Shortfall ---");
        processador.setEstrategia(calcES); // Troca a estratégia
        System.out.println(processador.executarAnalise() + "\n");

        // Rodando com Teste de Estresse
        System.out.println("--- TROCANDO ESTRATÉGIA: Teste de Estresse ---");
        processador.setEstrategia(calcEstresse); // Troca de novo
        System.out.println(processador.executarAnalise() + "\n");
    }
}
