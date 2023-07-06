package FinApp;
public class Fatura {
    private int id;
    private double valor;
    private boolean paga;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPaga() {
        return this.paga;
    }

    public boolean getPaga() {
        return this.paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }
    public Fatura(int id, double valor) {
        this.id = id;
        this.valor = valor;
        this.paga = false;
    }

    public void marcarComoPaga() {
        this.paga = true;
    }
}