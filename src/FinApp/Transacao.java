package FinApp;

import java.util.Date;

public class Transacao {
    private int id;
    private String descricao;
    private double valor;
    private Date data;
    private Conta conta;

    // Getters e Setters
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Transacao(int id, String descricao, double valor, Date data, Conta conta) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.conta = conta;
    }
}