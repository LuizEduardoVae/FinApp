package FinApp;

public class Contasapagar {
    private double valor;
    private Categoria categoria;
    private Descricao descricao;


    public Contasapagar(double valor, Categoria categoria, Descricao descricao) {
        this.valor = valor;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Descricao getDescricao() {
        return this.descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }
}