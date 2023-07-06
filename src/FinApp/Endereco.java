package FinApp;

public class Endereco {
    private String rua;
    private String cep;
    private String cidade;
    private String bairro;
    private String numero;

    public Endereco(String rua, String cep, String cidade, String bairro, String numero) {
        this.rua = rua;
        this.cep = cep;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }
}

