package FinApp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

public class MenuContaGUI extends JFrame {

    private Conta conta;
    private JButton botaoRegistrarTransacao;
    private JButton botaoVerSaldo;
    private JButton botaoVerExtrato;
    private JButton botaoCriarCartaoCredito;
    private JButton botaoDefinirValorFatura;
    private JButton botaoVoltar;
    private MenuUsuarioGUI menuUsuario;
    
    

    public MenuContaGUI(Conta conta, MenuUsuarioGUI menuUsuario) {
        this.conta = conta;
        this.menuUsuario = menuUsuario;
        

        
        setTitle("Menu da Conta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        botaoRegistrarTransacao = new JButton("Registrar Transação");
        botaoVerSaldo = new JButton("Ver Saldo");
        botaoVerExtrato = new JButton("Ver Extrato");
        botaoCriarCartaoCredito = new JButton("Criar Cartão de Crédito");
        botaoDefinirValorFatura = new JButton("Definir Valor da Fatura");
        botaoVoltar = new JButton("Voltar");

        
        botaoRegistrarTransacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaRegistrarTransacao();
            }
        });

        botaoVerSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verSaldo();
            }
        });

        botaoVerExtrato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verExtrato();
            }
        });

        botaoCriarCartaoCredito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCriarCartaoCredito();
            }
        });

        botaoDefinirValorFatura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaDefinirValorFatura();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltar();
            }
        });

       
        JPanel painel = new JPanel();
        painel.add(botaoRegistrarTransacao);
        painel.add(botaoVerSaldo);
        painel.add(botaoVerExtrato);
        painel.add(botaoCriarCartaoCredito);
        painel.add(botaoDefinirValorFatura);
        painel.add(botaoVoltar);

       
        add(painel);
        setVisible(true);
    }

    private void abrirJanelaRegistrarTransacao() {
        JFrame frame = new JFrame();
        String tipo = JOptionPane.showInputDialog(frame, "Tipo de transação (entrada/saída):").toLowerCase();
        double valor = Double.parseDouble(JOptionPane.showInputDialog(frame, "Valor:"));
        String descricao = JOptionPane.showInputDialog(frame, "Descrição:");
        String categoria = JOptionPane.showInputDialog(frame, "Categoria:");

        Categoria novaCategoria = new Categoria(categoria);
        Transacao transacao;

        if (tipo.equals("entrada")) {
            transacao = new Receitas(valor, descricao, novaCategoria, tipo);
        } else if (tipo.equals("saída")) {
            transacao = new Despesa(valor, descricao, novaCategoria, tipo);
        } else {
            JOptionPane.showMessageDialog(this, "Tipo de transação inválido!");
            return;
        }

        conta.registrarTransacao(transacao);

        JOptionPane.showMessageDialog(this, "Transação registrada com sucesso!");
    }

    private void verSaldo() {
        double saldo = conta.getSaldo();
        double saldoSemFatura = conta.getSaldoSemFatura();
        JOptionPane.showMessageDialog(this, "Saldo da conta (sem fatura): " + saldoSemFatura + "\nSaldo da conta (com fatura): " + saldo);
    }

    private void verExtrato() {
        List<Transacao> transacoes = conta.getTransacoes();

        if (transacoes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há transações registradas.");
        } else {
            StringBuilder mensagem = new StringBuilder("---- EXTRATO DA CONTA ----\n");
            for (Transacao transacao : transacoes) {
                mensagem.append("Data: ").append(transacao.getData()).append("\n");
                mensagem.append("Descrição: ").append(transacao.getDescricao()).append("\n");
                mensagem.append("Valor: ").append(transacao.getValor()).append("\n");
                mensagem.append("Categoria: ").append(transacao.getCategoria().getNome()).append("\n");
                mensagem.append("\n");
            }
            JOptionPane.showMessageDialog(this, mensagem.toString());
        }
    }

    private void abrirJanelaCriarCartaoCredito() {
        JFrame frame = new JFrame();
        String numeroCartao = JOptionPane.showInputDialog(frame, "Número do cartão:");
        double limiteCredito = Double.parseDouble(JOptionPane.showInputDialog(frame, "Limite de crédito:"));

        CartaoCredito cartaoCredito = new CartaoCredito(numeroCartao, limiteCredito);
        conta.adicionarCartaoCredito(cartaoCredito);

        JOptionPane.showMessageDialog(this, "Cartão de crédito criado com sucesso!");
    }

    private void abrirJanelaDefinirValorFatura() {
        JFrame frame = new JFrame();
        double valorFatura = Double.parseDouble(JOptionPane.showInputDialog(frame, "Valor da fatura:"));
        String descricaoFatura = JOptionPane.showInputDialog(frame, "Descrição da fatura:");

        conta.gerarFatura(valorFatura, descricaoFatura);

        JOptionPane.showMessageDialog(this, "Fatura gerada com sucesso!");
    }

    private void voltar() {
        this.dispose();
        menuUsuario.setVisible(true);
    }
}
