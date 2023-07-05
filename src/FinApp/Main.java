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
            System.out.println("============  Menu ============");
            System.out.println("1. Criar conta");
            System.out.println("2. Adicionar entrada");
            System.out.println("3. Adicionar saída");
            System.out.println("4. Ver entradas");
            System.out.println("5. Ver saídas");
            System.out.println("6. Ver saldo total");
            System.out.println("7. Visualizar relatório");
            System.out.println("");
            System.out.println("");
            System.out.println("============  Planejamento de Gastos Futuros  ============");
            System.out.println("8. Adicionar conta a Pagar");
            System.out.println("9. Ver contas a Pagar");
            System.out.println("");
            System.out.println("");
            System.out.println("============ Sair ============");
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
                case 7:
                    gerarRelatorioDespesasPorCategoria(contas);
                    break;
                case 8:
                    adicionarSaidafutura(scanner, contas);
                    break;
                case 9:
                    verContasaPagar(contas);
                    break;
                case 0:
                    System.out.println("Até a próxima...");
                    break;
                default:
                    System.out.println("Opção inválida. Selecione as opções entre 0 a 6");
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
        System.out.println("\nConta criada com sucesso!");
        System.out.println("\nBem-vindo(a), " + pessoa.getNome());
    }

    private static void adicionarEntrada(Scanner scanner, List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            System.out.println("");
            System.out.println("");
            return;
        }

        Conta conta = contas.get(0);

        System.out.print("Digite o valor da entrada: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Entrada entrada = new Entrada(valor);
        conta.getEntradas().add(entrada);
        System.out.println("Entrada adicionada com sucesso!");
    }

    private static void adicionarSaida(Scanner scanner, List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            System.out.println("");
            System.out.println("");
            return;
        }

        Conta conta = contas.get(0);

        System.out.print("Digite o valor da saída: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o nome da categoria: ");
        String nomeCategoria = scanner.nextLine();

        System.out.print("Digite a descrição da Saida: ");
        String descricaoDescricao = scanner.nextLine();

        Categoria categoria = new Categoria(nomeCategoria);
        Descricao descricao = new Descricao(descricaoDescricao);
        Saida saida = new Saida(valor, categoria, descricao);

        conta.getSaidas().add(saida);
        System.out.println("Saída adicionada com sucesso!");
        System.out.println("");
        System.out.println("");
    }

    private static void adicionarSaidafutura(Scanner scanner, List<Conta> contas) {

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            System.out.println("");
            System.out.println("");
            return;
        }

        Conta conta = contas.get(0);

        System.out.print("Digite o valor da saída: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o nome da categoria: ");
        String nomeCategoria = scanner.nextLine();

        System.out.print("Digite a descrição da Saida: ");
        String descricaoDescricao = scanner.nextLine();

        Categoria categoria = new Categoria(nomeCategoria);
        Descricao descricao = new Descricao(descricaoDescricao);
        Contasapagar saidaFuturas = new Contasapagar(valor, categoria, descricao);

        conta.getSaidasfuturas().add(saidaFuturas);
        System.out.println("Conta a pagar adicionada com sucesso!");
        System.out.println("");
        System.out.println("");
    }

    private static void verContasaPagar(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            System.out.println("");
            System.out.println("");
            return;
        }

        Conta conta = contas.get(0);

        // Calculadora calculadora = new Calculadora(conta.getEntradas(), conta.getSaidas(), conta);
        // double totalSaidas = calculadora.calcularTotalSaidas();

        // System.out.println("Total das Saídas: " + totalSaidas);
        System.out.println("\nLista das suas Saídas:");
        for (Contasapagar saidasfuturas : conta.getSaidasfuturas()) {
            System.out.println("Valor: " + saidasfuturas.getValor());
            System.out.println("Categoria: " + saidasfuturas.getCategoria().getNome());
            System.out.println("Descrição: " + saidasfuturas.getDescricao().getDescricao());
            System.out.println("");
            System.out.println("");
        }
    }

   

    private static void verEntradas(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            System.out.println("");
            System.out.println("");
            return;
        }

        Conta conta = contas.get(0);

        Calculadora calculadora = new Calculadora(conta.getEntradas(), conta.getSaidas(), conta);
        double totalEntradas = calculadora.calcularTotalEntradas();

        System.out.println("Total das Entradas: " + totalEntradas);
        System.out.println("\nLista das suas Entradas:");
        for (Entrada entrada : conta.getEntradas()) {
            System.out.println(entrada.getValor());
        }
        System.out.println("");
        System.out.println("");
    }

    private static void verSaidas(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            System.out.println("");
            System.out.println("");
            return;
        }

        Conta conta = contas.get(0);

        Calculadora calculadora = new Calculadora(conta.getEntradas(), conta.getSaidas(), conta);
        double totalSaidas = calculadora.calcularTotalSaidas();

        System.out.println("Total das Saídas: " + totalSaidas);
        System.out.println("\nLista das suas Saídas:");
        for (Saida saida : conta.getSaidas()) {
            System.out.println("Valor: " + saida.getValor());
            System.out.println("Categoria: " + saida.getCategoria().getNome());
            System.out.println("Descrição: " + saida.getDescricao().getDescricao());
            System.out.println("");
            System.out.println("");
            
        }
    }



    private static void verSaldoTotal(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            System.out.println("");
            System.out.println("");
            return;
        }

        Conta conta = contas.get(0);

        Calculadora calculadora = new Calculadora(conta.getEntradas(), conta.getSaidas(), conta);
        calculadora.atualizarSaldo();

        System.out.println("Saldo total: " + conta.getSaldo());
    }
   
    private static void gerarRelatorioDespesasPorCategoria(List<Conta> contas) {
        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta encontrada. Crie uma conta antes de usar o app");
            System.out.println("");
            System.out.println("");
            return;
        }

        Conta conta = contas.get(0);
        Relatorio relatorio = new Relatorio(conta);
        relatorio.gerarRelatorioDespesasPorCategoria();
    }



}


