package FinApp;

import java.util.List;
import java.util.ArrayList;


public class Conta {

    private String numero;
    private Usuario usuario;
    private Cartao cartao;
    private List<Operacao> operacoes;
    private double saldo;
    private Pontos pontos; 

    public Conta(String numero, Usuario usuario, Cartao cartao) {
        this.numero = numero;
        this.usuario = usuario;
        this.cartao = cartao;
        this.operacoes = new ArrayList<>();
        this.saldo = 0.0;
        this.pontos = new Pontos(); 
    }
    
    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public String getNumero() {
        return numero;
    }

    public Usuario getUsuario() {
        return usuario;
    }

     public void adicionarOperacao(Operacao operacao) {
        operacoes.add(operacao);
        atualizarSaldo(operacao);
        pontos.registrarOperacao(10); 
    }

    private void atualizarSaldo(Operacao operacao) {
        if (operacao instanceof Entrada) {
            saldo += operacao.getValor();
        } else if (operacao instanceof Saida) {
            saldo -= operacao.getValor();
        }
        if (cartao instanceof Fatura) {
        double valorFatura = ((Fatura) cartao).getValorF();
        saldo -= valorFatura;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }
}