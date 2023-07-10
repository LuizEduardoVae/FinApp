package FinApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static Usuario usuarioLogado;
    private static Scanner scanner;
    private static List<Usuario> usuarios;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        usuarios = new ArrayList<>();

        boolean sair = false;
        while (!sair) {
            exibirMenuPrincipal();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    criarUsuario();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
        System.out.println("Programa encerrado.");
    }

    private static void exibirMenuPrincipal() {
        System.out.println("---- MENU PRINCIPAL ----");
        System.out.println("1. Fazer login");
        System.out.println("2. Criar usuário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void fazerLogin() {
        System.out.println("---- FAZER LOGIN ----");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        Usuario usuario = encontrarUsuario(login, senha);

        if (usuario != null) {
            usuarioLogado = usuario;
            MenuUsuario menuUsuario = new MenuUsuario(usuarioLogado);
            menuUsuario.exibirMenu();
            usuarioLogado = null; // Logout após sair do menu
        } else {
            System.out.println("Usuário ou senha incorretos!");
        }
    }

    private static Usuario encontrarUsuario(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    private static void criarUsuario() {
        System.out.println("---- CRIAR USUÁRIO ----");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        Endereco endereco = new Endereco(rua, numero, cidade, estado);
        Usuario novoUsuario = new Usuario(nome, login, senha, endereco);
        usuarios.add(novoUsuario);

        System.out.println("Usuário criado com sucesso!");
    }
}