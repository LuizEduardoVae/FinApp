package FinApp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuUsuarioGUI extends JFrame {

    private Usuario usuario;
    private JButton botaoCriarConta;
    private JButton botaoAcessarConta;
    private JButton botaoVerPontos;
    private JButton botaoVerRelatorio;
    private JButton botaoCriarPlanejamento;
    private JButton botaoVerPlanejamentos;
    private JButton botaoVerSaldoTotal;
    private JButton botaoSair;

    public MenuUsuarioGUI(Usuario usuario) {
        this.usuario = usuario;

        
        setTitle("Menu do Usuário");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        botaoCriarConta = new JButton("Criar Conta");
        botaoAcessarConta = new JButton("Acessar Conta");
        botaoVerPontos = new JButton("Ver Pontos");
        botaoVerRelatorio = new JButton("Ver Relatório Financeiro");
        botaoCriarPlanejamento = new JButton("Criar Planejamento Financeiro");
        botaoVerPlanejamentos = new JButton("Ver Planejamentos");
        botaoVerSaldoTotal = new JButton("Ver Saldo Total");
        botaoSair = new JButton("Sair");

        botaoCriarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCriarConta();
            }
        });

        botaoAcessarConta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaAcessarConta();
            }
        });

        botaoVerPontos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verPontos();
            }
        });

        botaoVerRelatorio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verRelatorioFinanceiro();
            }
        });

        botaoCriarPlanejamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCriarPlanejamento();
            }
        });

        botaoVerPlanejamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verPlanejamentos();
            }
        });

        botaoVerSaldoTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verSaldoTotal();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JPanel painel = new JPanel();
        painel.add(botaoCriarConta);
        painel.add(botaoAcessarConta);
        painel.add(botaoVerPontos);
        painel.add(botaoVerRelatorio);
        painel.add(botaoCriarPlanejamento);
        painel.add(botaoVerPlanejamentos);
        painel.add(botaoVerSaldoTotal);
        painel.add(botaoSair);

        add(painel);

        setVisible(true);
    }

    private void abrirJanelaCriarConta() {
       
        CriarContaGUI criarContaGUI = new CriarContaGUI(usuario);
        criarContaGUI.setVisible(true);
    }

    private void abrirJanelaAcessarConta() {
        AcessarContaGUI acessarContaGUI = new AcessarContaGUI(usuario);
        acessarContaGUI.setMenuUsuarioGUI(this);
        acessarContaGUI.setVisible(true);
        this.dispose(); 
    }


    private void verPontos() {
        Pontos pontos = usuario.getPontos();
        JOptionPane.showMessageDialog(this, "Você possui " + pontos.getSaldo() + " pontos.");
    }

    private void verRelatorioFinanceiro() {
        RelatorioFinanceiro relatorio = new RelatorioFinanceiro();
        relatorio.gerarRelatorio(usuario);
    }

    private void abrirJanelaCriarPlanejamento() {
        CriarPlanejamentoGUI criarPlanejamentoGUI = new CriarPlanejamentoGUI(usuario);
        criarPlanejamentoGUI.setVisible(true);
    }



    private void verPlanejamentos() {
        List<PlanejamentoFinanceiro> planejamentos = usuario.getPlanejamentos();

        if (planejamentos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não há planejamentos cadastrados.");
        } else {
            StringBuilder mensagem = new StringBuilder("---- PLANEJAMENTOS FINANCEIROS ----\n");
            for (PlanejamentoFinanceiro planejamento : planejamentos) {
                double saldoAtual = usuario.getSaldoTotal();
                double saldoFaltante = planejamento.getSaldoAlvo() - saldoAtual;

                mensagem.append("Objetivo: ").append(planejamento.getObjetivo()).append("\n");
                mensagem.append("Saldo faltante: ").append(saldoFaltante).append("\n");
                if (saldoFaltante <= 0) {
                    mensagem.append("Objetivo alcançado!\n");
                }
                mensagem.append("\n");
            }
            JOptionPane.showMessageDialog(this, mensagem.toString());
        }
    }

    private void verSaldoTotal() {
        double saldoTotal = usuario.getSaldoTotal();
        JOptionPane.showMessageDialog(this, "Saldo total: " + saldoTotal);
    }
}



