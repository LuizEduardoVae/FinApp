package FinApp;


public class Fatura extends CartaoCredito {
    private double valor;
    private String descricao;

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

    public Fatura(String numero, double limiteCredito, double valor, String descricao) {
        super(numero, limiteCredito);
        this.valor = valor;
        this.descricao = descricao;
    }

}