package FinApp;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numero;
    private String descricao;
    private double saldo;
    private List<Transacao> transacoes;
    private Usuario usuario;
    private CartaoCredito cartaoCredito;
    private Fatura fatura;
    private double saldoSemFatura;

    public Conta(String numero, String descricao, double saldoInicial, Usuario usuario) {
        this.numero = numero;
        this.descricao = descricao;
        this.saldo = saldoInicial;
        this.transacoes = new ArrayList<>();
        this.usuario = usuario;
        this.saldoSemFatura = saldoInicial;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSaldo() {
        if (fatura != null) {
            return saldoSemFatura;
        } else {
            return saldo;
        }
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public Fatura getFatura() {
        return fatura;
    }

    public void adicionarCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }
    
    public double getSaldoSemFatura() {
        if (fatura != null) {
            return saldo + fatura.getValor();
        }
        return saldo;
    }

    public void gerarFatura(double valor, String descricao) {
        if (cartaoCredito != null) {
            this.fatura = new Fatura(cartaoCredito.getNumero(), cartaoCredito.getLimiteCredito(), valor, descricao);
            this.saldo -= valor;
            this.saldoSemFatura -= valor;
        } else {
            System.out.println("Erro: Não há cartão de crédito associado a esta conta.");
        }
    }

    public void registrarTransacao(Transacao transacao) {
        if (transacao.isDespesa()) {
            saldo -= transacao.getValor();
            saldoSemFatura -= transacao.getValor();
            usuario.adicionarPontos();
        } else {
            saldo += transacao.getValor();
            saldoSemFatura += transacao.getValor();
            usuario.adicionarPontos();
        }
        transacoes.add(transacao);
    }
}
