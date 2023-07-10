package FinApp;

public class PlanejamentoFinanceiro {
    private String objetivo;
    private double saldoAlvo;


    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public double getSaldoAlvo() {
        return this.saldoAlvo;
    }

    public void setSaldoAlvo(double saldoAlvo) {
        this.saldoAlvo = saldoAlvo;
    }
    public PlanejamentoFinanceiro(String objetivo, double saldoAlvo) {
        this.objetivo = objetivo;
        this.saldoAlvo = saldoAlvo;
    }

}