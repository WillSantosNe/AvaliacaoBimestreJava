package Ex4;
/**
 * Monta a esteira (Pipeline) e processa o documento.
 */
public class Main {

    public static void main(String[] args) {
        //Monta o Pipeline (A ordem importa!)
        ValidadorPipeline pipeline = new ValidadorPipeline();
        
        pipeline.adicionar(new ValidadorSchemaXML());       // 1. Crítico
        pipeline.adicionar(new ValidadorCertificado());    // 2. Crítico
        pipeline.adicionar(new ValidadorRegrasFiscais());  // 3. (Falha 1)
        pipeline.adicionar(new ValidadorBancoDados());     // 4. (Tem rollback)
        pipeline.adicionar(new ValidadorSefaz());          // 5. (Falha 2)


        //Cria o documento
        DocumentoNFe nfe = new DocumentoNFe("12345", "<xml>...</xml>", "99.999.999/0001-99");

        //Processa
        ContextoValidacao resultado = pipeline.processar(nfe);

        //Mostra o resultado final
        System.out.println("\n--- RESULTADO FINAL ---");
        if (resultado.getErros().isEmpty()) {
            System.out.println("Documento APROVADO.");
        } else {
            System.out.println("Documento REPROVADO. Motivos:");
            for (String erro : resultado.getErros()) {
                System.out.println("- " + erro);
            }
        }
    }
}
