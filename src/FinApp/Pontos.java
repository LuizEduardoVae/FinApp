package FinApp;
public class Pontos {
    private int saldo;

    public int getSaldo() {
        return this.saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public Pontos() {
        this.saldo = 0;
    }

    public void adicionarPontos(int quantidade) {
        saldo += quantidade;
    }

}
