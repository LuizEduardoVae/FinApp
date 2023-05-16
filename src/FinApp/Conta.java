package FinApp;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Pessoa pessoa;
    private double saldo;
    private List<Double> entradas;
    private List<Double> saidas;

    public Conta(Pessoa pessoa, double saldo) {
        this.pessoa = pessoa;
        this.saldo = saldo;
        this.entradas = new ArrayList<>();
        this.saidas = new ArrayList<>();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
}
