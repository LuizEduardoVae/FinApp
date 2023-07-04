package FinApp;

public class Saida {
    private double valor;
    private Categoria categoria;
    private Descricao descricao;

    public Saida(double valor, Categoria categoria, Descricao descricao) {
        this.valor = valor;
        this.categoria = categoria;
        this.descricao = descricao;
    }


    public Descricao getDescricao() {
        return this.descricao;
    }

    public void setDescricao(Descricao descricao) {
        this.descricao = descricao;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
