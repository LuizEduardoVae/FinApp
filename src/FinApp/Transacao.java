package FinApp;

import java.time.LocalDate;

public abstract class Transacao {
    private double valor;
    private String descricao;
    private LocalDate data;
    private Categoria categoria;

    public abstract boolean isDespesa();
    
    public String getNomeCategoria() {
        return categoria.getNome();
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Transacao(double valor, String descricao, Categoria categoria) {
        this.valor = valor;
        this.descricao = descricao;
        this.data = LocalDate.now();
        this.categoria = categoria;
    }
}
