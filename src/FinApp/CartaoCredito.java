package FinApp;
import java.util.ArrayList;
import java.util.List;

public class CartaoCredito {
    private String numero;
    private Conta conta;
    private List<Fatura> faturas;

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Conta getConta() {
        return this.conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public List<Fatura> getFaturas() {
        return this.faturas;
    }

    public void setFaturas(List<Fatura> faturas) {
        this.faturas = faturas;
    }

    public CartaoCredito(String numero, Conta conta) {
        this.numero = numero;
        this.conta = conta;
        this.faturas = new ArrayList<>();
    }
    
    public void adicionarFatura(Fatura fatura) {
        faturas.add(fatura);
    }

    public void removerFatura(Fatura fatura) {
        faturas.remove(fatura);
    }
}
