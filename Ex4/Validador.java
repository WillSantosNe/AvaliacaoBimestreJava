package Ex4;
/**
 * O contrato para todos os passos da nossa cadeia.
 */
public interface Validador {

    /**
     * Roda a lógica de validação.
     * @param contexto O "carrinho" com os dados.
     * @return 'true' se passou, 'false' se falhou.
     */
    boolean executar(ContextoValidacao contexto);

    /**
     * O que fazer para reverter o que foi feito no 'executar'.
     * (Só é relevante para validadores que mudam estado, como o DB).
     */
    void rollback(ContextoValidacao contexto);

    /**
     * Se 'true', indica que se este validador falhar,
     * a cadeia INTEIRA deve parar imediatamente.
     * (Isso atende a Restrição 1).
     */
    boolean eCriticoSeFalhar();
}
