package FinApp;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AcessarContaGUI extends JFrame {
    private Usuario usuario;
    private JComboBox<String> comboBoxContas;
    private MenuUsuarioGUI menuUsuarioGUI;

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public JComboBox<String> getComboBoxContas() {
        return this.comboBoxContas;
    }

    public void setComboBoxContas(JComboBox<String> comboBoxContas) {
        this.comboBoxContas = comboBoxContas;
    }

    public MenuUsuarioGUI getMenuUsuarioGUI() {
        return this.menuUsuarioGUI;
    }

    public void setMenuUsuarioGUI(MenuUsuarioGUI menuUsuarioGUI) {
        this.menuUsuarioGUI = menuUsuarioGUI;
    }


    public AcessarContaGUI(Usuario usuario) {
        this.usuario = usuario;

        
        setTitle("Acessar Conta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JLabel labelContas = new JLabel("Contas disponíveis:");
        comboBoxContas = new JComboBox<>();

        
        List<Conta> contas = usuario.getContas();
        for (Conta conta : contas) {
            comboBoxContas.addItem(conta.getDescricao());
        }

        JButton botaoAcessar = new JButton("Acessar");

        
        botaoAcessar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acessarContaSelecionada();
            }
        });

       
        JPanel painel = new JPanel();
        painel.add(labelContas);
        painel.add(comboBoxContas);
        painel.add(botaoAcessar);

        
        add(painel);

        
        setVisible(true);
    }

    private void acessarContaSelecionada() {
        int indiceSelecionado = comboBoxContas.getSelectedIndex();
        List<Conta> contas = usuario.getContas();

        if (indiceSelecionado >= 0 && indiceSelecionado < contas.size()) {
            Conta contaSelecionada = contas.get(indiceSelecionado);
            MenuContaGUI menuContaGUI = new MenuContaGUI(contaSelecionada, menuUsuarioGUI);
            menuContaGUI.setVisible(true);
            this.dispose(); 
        } else {
            System.out.println("Opção inválida!");
        }
    }
}
