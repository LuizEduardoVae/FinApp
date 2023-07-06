package FinApp;

public class Cartao {
    private String nome;
    private String cpf;
    private String endereco;
    private double fatura;
    
    public Cartao(String nome, String cpf, String endereco, double fatura) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.fatura = fatura;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getFatura() {
        return this.fatura;
    }

    public void setFatura(double fatura) {
        this.fatura = fatura;
    }

}
