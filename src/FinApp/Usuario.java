package FinApp;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private Endereco endereco;
    private List<Conta> contas;
    private List<PlanejamentoFinanceiro> planejamentos;
    private Pontos pontos;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Conta> getContas() {
        return this.contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<PlanejamentoFinanceiro> getPlanejamentos() {
        return this.planejamentos;
    }

    public void setPlanejamentos(List<PlanejamentoFinanceiro> planejamentos) {
        this.planejamentos = planejamentos;
    }

    public Pontos getPontos() {
        return this.pontos;
    }

    public void setPontos(Pontos pontos) {
        this.pontos = pontos;
    }

    public Usuario(String nome, String login, String senha, Endereco endereco) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.endereco = endereco;
        this.contas = new ArrayList<>();
        this.planejamentos = new ArrayList<>();
        this.pontos = new Pontos();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }

    public void adicionarPlanejamento(PlanejamentoFinanceiro planejamento) {
        planejamentos.add(planejamento);
    }

    public double getSaldoTotal() {
        double saldoTotal = 0;
        for (Conta conta : contas) {
            saldoTotal += conta.getSaldo();
        }
        return saldoTotal;
    }
    
    public void adicionarPontos() {
        this.pontos.adicionarPontos(10);
    }
}
