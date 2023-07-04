package FinApp;

import java.util.List;

public class Calculadora {
    private List<Entrada> entradas;
    private List<Saida> saidas;
    private Conta conta;

    public Calculadora(List<Entrada> entradas, List<Saida> saidas, Conta conta) {
        this.entradas = entradas;
        this.saidas = saidas;
        this.conta = conta;
    }

    public double calcularTotalEntradas() {
        double totalEntradas = 0.0;
        for (Entrada entrada : entradas) {
            totalEntradas += entrada.getValor();
        }
        return totalEntradas;
    }

    public double calcularTotalSaidas() {
        double totalSaidas = 0.0;
        for (Saida saida : saidas) {
            totalSaidas += saida.getValor();
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
