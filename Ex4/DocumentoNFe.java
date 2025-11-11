package Ex4;

/**
 * Apenas os dados da NF-e que vamos validar.
 */
public class DocumentoNFe {
    private String numero;
    private String xmlConteudo;
    private String cnpjEmitente;

    public DocumentoNFe(String numero, String xmlConteudo, String cnpjEmitente) {
        this.numero = numero;
        this.xmlConteudo = xmlConteudo;
        this.cnpjEmitente = cnpjEmitente;
    }

    public String getNumero() {
        return numero;
    }

    public String getXmlConteudo() {
        return xmlConteudo;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }
}
