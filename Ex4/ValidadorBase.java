package Ex4;
/**
 * Ajuda a evitar código repetido. Define o comportamento padrão.
 */
abstract class ValidadorBase implements Validador {
    protected String nome;
    private boolean critico; // Define se a cadeia para em caso de falha

    public ValidadorBase(String nome, boolean critico) {
        this.nome = nome;
        this.critico = critico;
    }

    @Override
    public boolean eCriticoSeFalhar() {
        return this.critico;
    }

    @Override
    public void rollback(ContextoValidacao contexto) {
        // A maioria dos validadores não faz nada no rollback.
        // O Validador de DB vai sobreescrever este método.
    }

    // Helper para simular a restrição de timeout
    protected void simularTimeout(long ms) {
        // System.out.println("   (Timeout simulado: " + ms + "ms)");
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) { /* Ignora */ }
    }

    protected void log(String msg) {
        System.out.println("  [" + this.nome + "] " + msg);
    }
}

// --- OS 5 VALIDADORES REQUERIDOS ---

/* Validador de Schema XML (Crítico) */
class ValidadorSchemaXML extends ValidadorBase {
    public ValidadorSchemaXML() { super("Schema XML", true); } // Crítico

    @Override
    public boolean executar(ContextoValidacao contexto) {
        simularTimeout(20);
        log("Validando estrutura XML contra XSD...");
        // Simulação: Vamos supor que passou
        log("...OK");
        return true;
    }
}

/* Validador de Certificado (Crítico) */
class ValidadorCertificado extends ValidadorBase {
    public ValidadorCertificado() { super("Certificado Digital", true); } // Crítico

    @Override
    public boolean executar(ContextoValidacao contexto) {
        simularTimeout(50);
        log("Validando assinatura e data do certificado...");
        // Simulação: Vamos supor que passou
        log("...OK");
        return true;
    }
}

/* Validador de Regras Fiscais (NÃO Crítico) */
class ValidadorRegrasFiscais extends ValidadorBase {
    public ValidadorRegrasFiscais() { super("Regras Fiscais", false); }

    @Override
    public boolean executar(ContextoValidacao contexto) {
        simularTimeout(30);
        log("Calculando e validando impostos (ICMS, IPI)...");
        // Simulação: Vamos falhar este
        log("...FALHA! (Cálculo de ICMS-ST inconsistente)");
        contexto.adicionarErro("Cálculo de ICMS-ST inconsistente.");
        return false;
    }
}

/* Validador de Banco de Dados (com Rollback) */
class ValidadorBancoDados extends ValidadorBase {
    private boolean inseriu = false; // Guarda o estado
    public ValidadorBancoDados() { super("Banco de Dados", false); }

    @Override
    public boolean executar(ContextoValidacao contexto) {
        simularTimeout(40);
        log("Verificando duplicidade de chave/número no DB...");
        // Simulação:
        // 1. Tenta "reservar" a chave no DB para evitar duplicidade
        this.inseriu = true;
        log("...OK (Chave '12345' reservada no DB).");
        return true;
    }

    @Override
    public void rollback(ContextoValidacao contexto) {
        // RESTRIÇÃO 4: Se o validador fez uma modificação (inseriu),
        // ele deve saber como desfazê-la.
        if (this.inseriu) {
            log("ROLLBACK: Deletando chave '12345' reservada do DB.");
            this.inseriu = false;
        }
    }
}

/* Validador de Serviço SEFAZ (NÃO Crítico) */
class ValidadorSefaz extends ValidadorBase {
    public ValidadorSefaz() { super("SEFAZ Online", false); }

    @Override
    public boolean executar(ContextoValidacao contexto) {
        simularTimeout(150); // Simula timeout de rede
        log("Consultando serviço online da SEFAZ...");
        // Simulação: Vamos falhar este também
        log("...FALHA! (SEFAZ offline - Timeout)");
        contexto.adicionarErro("SEFAZ offline (Timeout).");
        return false;
    }
}
