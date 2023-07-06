package FinApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.time.LocalDate;
import java.util.List;


public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Usuario usuarioLogado;
    private static Map<String, Usuario> usuarios = new HashMap<>();

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        int opcao;
        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Fazer login");
            System.out.println("2. Criar usuário");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    fazerLogin();
                    break;
                case 2:
                    criarUsuario();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }
    
    private static Endereco criarEndereco() {
        System.out.print("Digite a rua: ");
        String rua = scanner.nextLine();
        System.out.print("Digite o CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Digite o bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Digite o número: ");
        String numero = scanner.nextLine();

        return new Endereco(rua, cep, cidade, bairro, numero);
    }

    private static void fazerLogin() {
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (usuarioExiste(cpf) && senhaCorreta(cpf, senha)) {
            System.out.println("Login realizado com sucesso!");
            usuarioLogado = obterUsuario(cpf);
            exibirMenuUsuario();
        } else {
            System.out.println("CPF ou senha incorretos. Tente novamente.");
        }
    }

    private static boolean usuarioExiste(String cpf) {
        return usuarios.containsKey(cpf);
    }

    private static boolean senhaCorreta(String cpf, String senha) {
        Usuario usuario = usuarios.get(cpf);
        return usuario.getSenha().equals(senha);
    }

    private static Usuario obterUsuario(String cpf) {
        return usuarios.get(cpf);
    }

    private static void salvarUsuario(Usuario usuario) {
        usuarios.put(usuario.getCpf(), usuario);
    }

    private static void criarUsuario() {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Endereco endereco = criarEndereco();

        Usuario novoUsuario = new Usuario(nome, cpf, email, senha, endereco);
        salvarUsuario(novoUsuario);

        System.out.println("Usuário criado com sucesso!");
    }

    private static void exibirMenuUsuario() {
        int opcao;
        do {
            System.out.println("===== MENU USUÁRIO =====");
            System.out.println("1. Criar conta");
            System.out.println("2. Escolher conta");
            System.out.println("3. Ver extrato completo");
            System.out.println("4. Ver saldo total");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    escolherConta();
                    break;
                case 3:
                    verExtratoCompleto();
                    break;
                case 4:
                    verSaldoTotal();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    private static void criarConta() {
        System.out.print("Digite o número da conta: ");
        String numero = scanner.nextLine();
        Cartao cartao = criarCartao();
        Conta conta = new Conta(numero, usuarioLogado, cartao);
        usuarioLogado.adicionarConta(conta);
        System.out.println("Conta criada com sucesso!");
    }

    private static Cartao criarCartao() {
        System.out.print("Digite o nome do cartão: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do titular do cartão: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o endereço do titular do cartão: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o valor da fatura do cartão: ");
        double fatura = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada

        return new Cartao(nome, cpf, endereco, fatura);
    }

    private static void escolherConta() {
        if (usuarioLogado.getContas().isEmpty()) {
            System.out.println("Nenhuma conta disponível. Crie uma conta primeiro.");
        } else {
            System.out.println("===== CONTAS DISPONÍVEIS =====");
            List<Conta> contas = usuarioLogado.getContas();
            for (int i = 0; i < contas.size(); i++) {
                System.out.println((i + 1) + ". Conta " + contas.get(i).getNumero());
            }
            System.out.print("Escolha uma conta: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            if (escolha >= 1 && escolha <= contas.size()) {
                Conta contaSelecionada = contas.get(escolha - 1);
                exibirMenuConta(contaSelecionada);
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void exibirMenuConta(Conta conta) {
        int opcao;
        do {
            System.out.println("===== MENU CONTA " + conta.getNumero() + " =====");
            System.out.println("1. Adicionar entrada");
            System.out.println("2. Adicionar saída");
            System.out.println("3. Ver extrato");
            System.out.println("4. Ver saldo");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    adicionarEntrada(conta);
                    break;
                case 2:
                    adicionarSaida(conta);
                    break;
                case 3:
                    verExtrato(conta);
                    break;
                case 4:
                    verSaldo(conta);
                    break;
                case 5:
                    System.out.println("Voltando para o menu do usuário...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao !=5);
    }

    private static void adicionarEntrada(Conta conta) {
        System.out.print("Digite o valor da entrada: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada
        System.out.print("Digite a categoria da entrada: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite a descrição da entrada: ");
        String descricao = scanner.nextLine();

        LocalDate data = LocalDate.now();
        Entrada entrada = new Entrada(valor, data, categoria);
        entrada.setDescricao(descricao);
        conta.adicionarOperacao(entrada);

        System.out.println("Entrada adicionada com sucesso!");
    }

    private static void adicionarSaida(Conta conta) {
        System.out.print("Digite o valor da saída: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer de entrada
        System.out.print("Digite a categoria da saída: ");
        String categoria = scanner.nextLine();
        System.out.print("Digite a descrição da saída: ");
        String descricao = scanner.nextLine();

        LocalDate data = LocalDate.now();
        Saida saida = new Saida(valor, data, categoria);
        saida.setDescricao(descricao);
        conta.adicionarOperacao(saida);

        System.out.println("Saída adicionada com sucesso!");
    }

    private static void verExtrato(Conta conta) {
    System.out.println("===== EXTRATO CONTA " + conta.getNumero() + " =====");
    List<Operacao> operacoes = conta.getOperacoes();

    for (Operacao operacao : operacoes) {
        System.out.println("Data: " + operacao.getData());
        System.out.println("Valor: " + operacao.getValor());
        System.out.println("Tipo: " + operacao.getTipo());

        if (operacao instanceof Entrada) {
            System.out.println("Categoria: " + ((Entrada) operacao).getCategoria());
        } else if (operacao instanceof Saida) {
            System.out.println("Categoria: " + ((Saida) operacao).getCategoria());
        }

        System.out.println(); 
    }
}



    private static void verSaldo(Conta conta) {
        System.out.println("Saldo da conta " + conta.getNumero() + ": " + conta.getSaldo());
    }

    private static void verExtratoCompleto() {
    System.out.println("===== EXTRATO COMPLETO =====");
    List<Conta> contas = usuarioLogado.getContas();

    for (Conta conta : contas) {
        verExtrato(conta);
        System.out.println();
    }
}

    private static void verSaldoTotal() {
        double saldoTotal = 0.0;
        System.out.println("===== SALDO TOTAL =====");
        if (usuarioLogado.getContas().isEmpty()) {
            System.out.println("Nenhuma conta disponível.");
        } else {
            for (Conta conta : usuarioLogado.getContas()) {
                saldoTotal += conta.getSaldo();
                System.out.println("Conta " + conta.getNumero() + ": " + conta.getSaldo());
            }
            System.out.println("Saldo Total: " + saldoTotal);
        }
    }
}
