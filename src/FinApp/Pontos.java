package FinApp;

public class Pontos {
    private int pontos;

    public Pontos() {
        this.pontos = 0;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void incrementarPontos() {
        this.pontos += 10;
    }
}
