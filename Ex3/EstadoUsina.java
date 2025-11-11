package Ex3;
/**
 * Este é o contrato que todos os "estados" concretos devem implementar.
 * Cada estado vai cuidar da sua própria lógica.
 *
 * A "Usina" (Contexto) é passada para que o estado
 * possa dizer à usina para qual novo estado ela deve mudar.
 */
public interface EstadoUsina {

    /**
     * Ação principal, chamada quando os sensores atualizam.
     * É aqui que a maioria das transições de estado acontece.
     */
    void monitorar(Usina usina, DadosReator dados);

    /** Ação para entrar em manutenção (sobreescrever o estado) */
    void entrarManutencao(Usina usina);

    /** Ação para sair da manutenção (geralmente volta para 'Desligada') */
    void sairManutencao(Usina usina);

    // Também podemos ter ações específicas de certos estados
    void ligar(Usina usina);
    void desligar(Usina usina);
}
