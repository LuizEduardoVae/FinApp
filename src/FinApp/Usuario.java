package FinApp;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Endereco endereco;
    private List<Conta> contas;
    private int pontos;
    
    public Usuario(String nome, String cpf, String email, String senha, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.contas = new ArrayList<>();
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public int getPontos() {
        return pontos;
    }

    public void adicionarPontos(int quantidadePontos) {
        pontos += quantidadePontos;
    }
}