package FinApp;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Pessoa pessoa;
    private double saldo;
    private List<Entrada> entradas;
    private List<Saida> saidas;
    private List<Contasapagar> saidasfuturas;

    
    public Conta(Pessoa pessoa, double saldo) {
        this.pessoa = pessoa;
        this.saldo = saldo;
        this.entradas = new ArrayList<>();
        this.saidas = new ArrayList<>();
    }

    public List<Contasapagar> getSaidasfuturas() {
            return this.saidasfuturas;
        }

    public void setSaidasfuturas(List<Contasapagar> saidasfuturas) {
            this.saidasfuturas = saidasfuturas;
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

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public List<Saida> getSaidas() {
        return saidas;
    }

    public void setSaidas(List<Saida> saidas) {
        this.saidas = saidas;
    }
}
