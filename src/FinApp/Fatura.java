package FinApp;

public class Fatura extends Cartao {
    private String dataV;
    private double valorF;
    private String dataP;
    private String descricao;

    public Fatura(String nome, String cpf, String endereco, double fatura, String dataV, double valorF, String dataP, String descricao) {
        super(nome, cpf, endereco, fatura);
        this.dataV = dataV;
        this.valorF = valorF;
        this.dataP = dataP;
        this.descricao = descricao;
    }

    public String getDataV() {
        return this.dataV;
    }

    public void setDataV(String dataV) {
        this.dataV = dataV;
    }

    public double getValorF() {
        return this.valorF;
    }

    public void setValorF(double valorF) {
        this.valorF = valorF;
    }

    public String getDataP() {
        return this.dataP;
    }

    public void setDataP(String dataP) {
        this.dataP = dataP;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
