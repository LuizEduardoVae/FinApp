package FinApp;

import java.util.Date;

public class PlanejamentoFinanceiro {
    private String objetivo;
    private double saldoTotalNecessario;
    private Date dataLimite;

    public String getObjetivo() {
        return this.objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public double getSaldoTotalNecessario() {
        return this.saldoTotalNecessario;
    }

    public void setSaldoTotalNecessario(double saldoTotalNecessario) {
        this.saldoTotalNecessario = saldoTotalNecessario;
    }

    public Date getDataLimite() {
        return this.dataLimite;
    }

    public void setDataLimite(Date dataLimite) {
        this.dataLimite = dataLimite;
    }

    public PlanejamentoFinanceiro(String objetivo, double saldoTotalNecessario, Date dataLimite) {
        this.objetivo = objetivo;
        this.saldoTotalNecessario = saldoTotalNecessario;
        this.dataLimite = dataLimite;
    }
}
