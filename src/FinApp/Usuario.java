package FinApp;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Endereco endereco;
    private List<Conta> contas;
    private Pontos pontos;
    private PlanejamentoFinanceiro planejamentoFinanceiro;
    private RelatorioFinanceiro relatorioFinanceiro;

    public Usuario(String nome, String cpf, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.contas = new ArrayList<>();
        this.pontos = new Pontos();
    }


    public RelatorioFinanceiro getRelatorioFinanceiro() {
        return relatorioFinanceiro;
    }

    public void setRelatorioFinanceiro(RelatorioFinanceiro relatorioFinanceiro) {
        this.relatorioFinanceiro = relatorioFinanceiro;
    }

    public PlanejamentoFinanceiro getPlanejamentoFinanceiro() {
        return planejamentoFinanceiro;
    }

    public void setPlanejamentoFinanceiro(PlanejamentoFinanceiro planejamentoFinanceiro) {
        this.planejamentoFinanceiro = planejamentoFinanceiro;
    }

     public Pontos getPontos() {
        return pontos;
    }

    public void registrarTransacao() {
        pontos.incrementarPontos();
    }
    
    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }


    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
