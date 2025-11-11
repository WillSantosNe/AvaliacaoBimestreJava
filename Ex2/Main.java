/**
 * Simula o sistema novo (ex: uma Loja Online) usando o processador.
 * Note que o cliente só depende da interface "ProcessadorTransacoes".
 * Ele não sabe (e não se importa) que existe um adaptador ou um legado.
 */
public class Main {

    public static void main(String[] args) {
        
        // O sistema legado existe em algum lugar.
        SistemaBancarioLegado sistemaAntigo = new SistemaBancarioLegado();

        // Criamos nosso Adaptador e "injetamos" o sistema antigo nele.
        // O cliente vê o adaptador como se fosse um "ProcessadorTransacoes"
        ProcessadorTransacoes meuProcessador = new AdaptadorBancario(sistemaAntigo);

        // --- O CLIENTE SÓ USA A INTERFACE MODERNA ---

        System.out.println("CLIENTE: Fazendo transação em BRL...");
        // O cliente chama o método moderno e simples
        RespostaTransacao resp1 = meuProcessador.autorizar("1234-5678", 150.75, "BRL");

        // O cliente recebe a resposta moderna e simples
        System.out.println("CLIENTE: Resposta recebida: " + resp1);
        System.out.println("==========================================");


        System.out.println("CLIENTE: Fazendo transação em USD...");
        RespostaTransacao resp2 = meuProcessador.autorizar("9876-5432", 99.00, "USD");
        System.out.println("CLIENTE: Resposta recebida: " + resp2);
    }
}
