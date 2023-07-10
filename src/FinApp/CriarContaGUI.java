package FinApp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CriarContaGUI extends JFrame {
    private Usuario usuario;
    private JTextField textFieldNumero;
    private JTextField textFieldDescricao;

    public CriarContaGUI(Usuario usuario) {
        this.usuario = usuario;

        // Configurações da janela
        setTitle("Criar Conta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação dos componentes
        JLabel labelNumero = new JLabel("Número da conta:");
        textFieldNumero = new JTextField(10);
        JLabel labelDescricao = new JLabel("Descrição da conta:");
        textFieldDescricao = new JTextField(10);

        JButton botaoCriar = new JButton("Criar");

       
        botaoCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                criarNovaConta();
            }
        });

        
        JPanel painel = new JPanel();
        painel.add(labelNumero);
        painel.add(textFieldNumero);
        painel.add(labelDescricao);
        painel.add(textFieldDescricao);
        painel.add(botaoCriar);

        
        add(painel);

        
        setVisible(true);
    }

    private void criarNovaConta() {
        String numero = textFieldNumero.getText();
        String descricao = textFieldDescricao.getText();

        Conta novaConta = new Conta(numero, descricao, 0.0, usuario);
        usuario.adicionarConta(novaConta);

        System.out.println("Conta criada com sucesso!");

        this.dispose(); 
    }
}
