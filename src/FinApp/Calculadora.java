package FinApp;

import java.util.List;

public class Calculadora {
    private List<Double> entradas;
    private List<Double> saidas;
    private Conta conta;

    public Calculadora(List<Double> entradas, List<Double> saidas, Conta conta) {
        this.entradas = entradas;
        this.saidas = saidas;
        this.conta = conta;
    }

    public List<Double> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Double> entradas) {
        this.entradas = entradas;
    }

    public List<Double> getSaidas() {
        return saidas;
    }

    public void setSaidas(List<Double> saidas) {
        this.saidas = saidas;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public double calcularTotalEntradas() {
        double totalEntradas = 0.0;
        for (double entrada : entradas) {
            totalEntradas += entrada;
        }
        return totalEntradas;
    }

    public double calcularTotalSaidas() {
        double totalSaidas = 0.0;
        for (double saida : saidas) {
            totalSaidas += saida;
        }
        return totalSaidas;
    }

    public void atualizarSaldo() {
        double totalEntradas = calcularTotalEntradas();
        double totalSaidas = calcularTotalSaidas();
        double saldoNovo = totalEntradas - totalSaidas;
        conta.setSaldo(saldoNovo);
    }
}
