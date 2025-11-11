package Ex3;
/**
 * Uma classe simples só para carregar os dados complexos dos sensores
 * (temperatura, pressão, etc.) que os Estados usarão para
 * tomar decisões.
 */
public class DadosReator {
    private double temperatura;
    private double pressao;
    private boolean sistemaResfriamentoOK;

    public DadosReator(double temperatura, double pressao, boolean sistemaResfriamentoOK) {
        this.temperatura = temperatura;
        this.pressao = pressao;
        this.sistemaResfriamentoOK = sistemaResfriamentoOK;
    }

    // Getters
    public double getTemperatura() {
        return temperatura;
    }

    public double getPressao() {
        return pressao;
    }

    public boolean isSistemaResfriamentoOK() {
        return sistemaResfriamentoOK;
    }
}
