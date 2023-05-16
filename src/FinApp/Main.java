package FinApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar conta");
            System.out.println("2. Adicionar entrada");
            System.out.println("3. Adicionar saída");
            System.out.println("4. Ver entradas");
            System.out.println("5. Ver saídas");
            System.out.println("6. Ver saldo total");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println();

            switch (opcao) {
                case 1:
                    criarConta(scanner, contas);
                    break;
                case 2:
                    adicionarEntrada(scanner, contas);
                    break;
                case 3:
                    adicionarSaida(scanner, contas);
                    break;
                case 4:
                    verEntradas(contas);
                    break;
                case 5:
                    verSaidas(contas);
                    break;
                case 6:
                    verSaldoTotal(contas);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void criarConta(Scanner scanner, List<Conta> contas) {
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF da pessoa: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o email da pessoa: ");
        String email = scanner.nextLine();

        Pessoa pessoa = new Pessoa(nome, cpf, email);
        Conta conta = new Conta(pessoa, 0);

        contas.add(conta);
        System.out.println("Conta criada com sucesso!");
        System.out.println("Titular da conta: " + pessoa.getNome());
    }

    private static void adicionarEntrada(Scanner scanner, List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            return;
        }

        Conta conta = contas.get(0);

        System.out.print("Digite o valor da entrada: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 

        conta.getEntradas().add(valor);
        System.out.println("Entrada adicionada com sucesso!");
    }

    private static void adicionarSaida(Scanner scanner, List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            return;
        }

        Conta conta = contas.get(0);

        System.out.print("Digite o valor da saída: ");
        double valor = scanner.nextDouble();
        scanner.nextLine(); 

        conta.getSaidas().add(valor);
        System.out.println("Saída adicionada com sucesso!");
    }

    private static void verEntradas(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            return;
        }

        Conta conta = contas.get(0);

        System.out.println("Entradas da conta:");
        for (double entrada : conta.getEntradas()) {
            System.out.println(entrada);
        }
    }

    private static void verSaidas(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            return;
        }

        Conta conta = contas.get(0);

        System.out.println("Saídas da conta:");
        for (double saida : conta.getSaidas()) {
            System.out.println(saida);
        }
    }

    private static void verSaldoTotal(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            return;
        }
    
        Conta conta = contas.get(0);
    
        Calculadora calculadora = new Calculadora(conta.getEntradas(), conta.getSaidas(), conta);
        calculadora.atualizarSaldo();
    
        System.out.println("Saldo total: " + conta.getSaldo());
    }
    
}

