package FinApp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarPlanejamentoGUI extends JFrame {
    private Usuario usuario;
    private JTextField campoObjetivo;
    private JTextField campoSaldoAlvo;

    public CriarPlanejamentoGUI(Usuario usuario) {
        this.usuario = usuario;

        
        setTitle("Criar Planejamento Financeiro");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        
        JLabel labelObjetivo = new JLabel("Objetivo:");
        campoObjetivo = new JTextField(20);

        JLabel labelSaldoAlvo = new JLabel("Saldo Alvo:");
        campoSaldoAlvo = new JTextField(10);

        JButton botaoCriar = new JButton("Criar");

        
        botaoCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarPlanejamento();
            }
        });

        
        JPanel painel = new JPanel();
        painel.add(labelObjetivo);
        painel.add(campoObjetivo);
        painel.add(labelSaldoAlvo);
        painel.add(campoSaldoAlvo);
        painel.add(botaoCriar);

        
        add(painel);

        
        setVisible(true);
    }

    private void criarPlanejamento() {
        String objetivo = campoObjetivo.getText();
        double saldoAlvo = Double.parseDouble(campoSaldoAlvo.getText());

        PlanejamentoFinanceiro novoPlanejamento = new PlanejamentoFinanceiro(objetivo, saldoAlvo);
        usuario.adicionarPlanejamento(novoPlanejamento);

        
        JOptionPane.showMessageDialog(this, "Planejamento financeiro criado com sucesso!");

       
        dispose();
    }
}
