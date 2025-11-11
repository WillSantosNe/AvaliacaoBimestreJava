package Ex4;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe gerencia a execução. Ela é o "Contexto" do padrão
 * Strategy, mas aplicado ao Chain of Responsibility.
 */
public class ValidadorPipeline {

    private List<Validador> validadores = new ArrayList<>();
    // RESTRIÇÃO: Circuit Breaker
    private static final int MAX_FALHAS = 3;

    public void adicionar(Validador v) {
        this.validadores.add(v);
    }

    public ContextoValidacao processar(DocumentoNFe doc) {
        ContextoValidacao contexto = new ContextoValidacao(doc);
        boolean sucessoGeral = true;

        System.out.println("=== INICIANDO PIPELINE DE VALIDAÇÃO ===");

        for (Validador validador : validadores) {

            // Checa o CIRCUIT BREAKER
            // (Interrompe se 3 falhas já ocorreram)
            if (contexto.getContadorFalhas() >= MAX_FALHAS) {
                System.out.println("\n!!! CIRCUIT BREAKER ATIVADO !!!");
                System.out.println("Atingiu " + MAX_FALHAS + " falhas. Interrompendo a cadeia.");
                sucessoGeral = false;
                break;
            }

            // Executa o validador
            boolean passou = validador.executar(contexto);

            // Adiciona na pilha de rollback (mesmo se falhar)
            contexto.adicionarNaPilhaRollback(validador);

            // Se falhou...
            if (!passou) {
                sucessoGeral = false; // Marca o resultado final como falha

                // Checa se deve parar a cadeia (RESTRIÇÃO 1)
                // (Se o validador for 'crítico', como XML ou Certificado)
                if (validador.eCriticoSeFalhar()) {
                    System.out.println(">>> VALIDAÇÃO CRÍTICA FALHOU. Parando a cadeia agora.");
                    break; // Interrompe o 'for'
                }
            }
        }

        // Fim da cadeia. Verifica se precisa de ROLLBACK.
        // (Se 'sucessoGeral' for false, algo falhou em algum ponto)
        if (!sucessoGeral) {
            System.out.println("\n--- INICIANDO ROLLBACKS (Pilha LIFO) ---");
            while (!contexto.pilhaRollbackVazia()) {
                Validador v = contexto.removerDaPilhaRollback();
                // O próprio validador sabe como se reverter
                v.rollback(contexto);
            }
            System.out.println("--- ROLLBACKS CONCLUÍDOS ---");
        }

        System.out.println("=== PIPELINE CONCLUÍDO ===");
        return contexto;
    }
}
