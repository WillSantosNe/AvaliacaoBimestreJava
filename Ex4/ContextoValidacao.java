package Ex4;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Este é o objeto "carrinho" que vai passar por toda a cadeia.
 * Ele carrega a NF-e, a lista de erros, o contador de falhas
 * e (o mais importante) a pilha de rollback.
 */
public class ContextoValidacao {
    private DocumentoNFe documento;
    private List<String> erros = new ArrayList<>();
    private int contadorFalhas = 0;

    // Uma Pilha (Stack) é LIFO (Last-In, First-Out).
    // Perfeito para rollback: o último que executou é o primeiro
    // a ser revertido.
    private Stack<Validador> executadosParaRollback = new Stack<>();

    public ContextoValidacao(DocumentoNFe documento) {
        this.documento = documento;
    }

    public void adicionarErro(String erro) {
        this.erros.add(erro);
        this.contadorFalhas++;
    }

    // Getters
    public DocumentoNFe getDocumento() { return documento; }
    public List<String> getErros() { return erros; }
    public int getContadorFalhas() { return contadorFalhas; }

    // Métodos para a Pilha de Rollback
    public void adicionarNaPilhaRollback(Validador validador) {
        this.executadosParaRollback.push(validador);
    }
    public Validador removerDaPilhaRollback() {
        return this.executadosParaRollback.pop();
    }
    public boolean pilhaRollbackVazia() {
        return this.executadosParaRollback.isEmpty();
    }
}
