package FinApp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MenuPrincipalGUI extends JFrame {

    private JButton botaoCriarUsuario;
    private JButton botaoFazerLogin;
    private JButton botaoSair;

    private List<Usuario> usuarios;

    public MenuPrincipalGUI() {
        // Configurações da janela principal
        setTitle("Menu Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criação dos botões
        botaoCriarUsuario = new JButton("Criar Usuário");
        botaoFazerLogin = new JButton("Fazer Login");
        botaoSair = new JButton("Sair");

        // Criação da lista de usuários
        usuarios = new ArrayList<>();

        // Adiciona ouvintes de eventos aos botões
        botaoCriarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaCriarUsuario();
            }
        });

        botaoFazerLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirJanelaFazerLogin();
            }
        });

        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Criação do painel
        JPanel painel = new JPanel();
        painel.add(botaoCriarUsuario);
        painel.add(botaoFazerLogin);
        painel.add(botaoSair);

        // Adiciona o painel à janela
        add(painel);

        // Exibe a janela
        setVisible(true);
    }

    private void abrirJanelaCriarUsuario() {
        // Implemente a lógica para abrir a janela de criar usuário
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do usuário:");
        String login = JOptionPane.showInputDialog(this, "Digite o login do usuário:");
        String senha = JOptionPane.showInputDialog(this, "Digite a senha do usuário:");
        String rua = JOptionPane.showInputDialog(this, "Digite a rua do usuário:");
        String numero = JOptionPane.showInputDialog(this, "Digite o número do usuário:");
        String cidade = JOptionPane.showInputDialog(this, "Digite a cidade do usuário:");
        String estado = JOptionPane.showInputDialog(this, "Digite o estado do usuário:");

        Endereco endereco = new Endereco(rua, numero, cidade, estado);
        Usuario novoUsuario = new Usuario(nome, login, senha, endereco);
        usuarios.add(novoUsuario);

        JOptionPane.showMessageDialog(this, "Usuário criado com sucesso!");
    }

    private void abrirJanelaFazerLogin() {
        
        // Implemente a lógica para abrir a janela de fazer login
        String login = JOptionPane.showInputDialog(this, "Digite o login:");
        String senha = JOptionPane.showInputDialog(this, "Digite a senha:");

        Usuario usuario = encontrarUsuario(login, senha);

        if (usuario != null) {
            JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
            // Após a autenticação bem-sucedida, abra a interface do Menu do Usuário
            new MenuUsuarioGUI(usuario);
            this.dispose(); // Fecha a janela do Menu Principal após fazer login
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos!");
        }
    }

    private Usuario encontrarUsuario(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new MenuPrincipalGUI();
    }
}
