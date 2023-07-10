package FinApp;

import java.util.List;
import java.util.Scanner;

public class MenuConta {
    private Conta conta;

    public MenuConta(Conta conta) {
        this.conta = conta;
    }

    public void exibirMenu(Scanner scanner) {
        boolean sair = false;

        while (!sair) {
            System.out.println("---- MENU DA CONTA ----");
            System.out.println("1. Registrar transação");
            System.out.println("2. Ver saldo");
            System.out.println("3. Ver extrato");
            System.out.println("4. Criar cartão de crédito");
            System.out.println("5. Definir valor da fatura");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    registrarTransacao(scanner);
                    break;
                case 2:
                    verSaldo();
                    break;
                case 3:
                    verExtrato();
                    break;
                case 4:
                    criarCartaoCredito(scanner);
                    break;
                case 5:
                    definirValorFatura(scanner);
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

            System.out.println();
        }
    }

    private void registrarTransacao(Scanner scanner) {
        System.out.println("---- REGISTRAR TRANSAÇÃO ----");
        System.out.print("Tipo de transação (entrada/saída): ");
        String tipo = scanner.nextLine().toLowerCase();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        Categoria novaCategoria = new Categoria(categoria);
        Transacao transacao;

        if (tipo.equals("entrada")) {
            transacao = new Receitas(valor, descricao, novaCategoria, tipo);
        } else if (tipo.equals("saída")) {
            transacao = new Despesa(valor, descricao, novaCategoria, tipo);
        } else {
            System.out.println("Tipo de transação inválido!");
            return;
        }

        conta.registrarTransacao(transacao);

        System.out.println("Transação registrada com sucesso!");
    }

    private void verSaldo() {
        double saldo = conta.getSaldo();
        double saldoSemFatura = conta.getSaldoSemFatura();
        System.out.println("Saldo da conta (sem fatura): " + saldoSemFatura);
        System.out.println("Saldo da conta (com fatura): " + saldo);
    }

    private void verExtrato() {
        List<Transacao> transacoes = conta.getTransacoes();

        if (transacoes.isEmpty()) {
            System.out.println("Não há transações registradas.");
        } else {
            System.out.println("---- EXTRATO DA CONTA ----");
            for (Transacao transacao : transacoes) {
                System.out.println("Data: " + transacao.getData());
                System.out.println("Descrição: " + transacao.getDescricao());
                System.out.println("Valor: " + transacao.getValor());
                System.out.println("Categoria: " + transacao.getCategoria().getNome());
                System.out.println();
            }
        }
    }

    private void criarCartaoCredito(Scanner scanner) {
        System.out.println("---- CRIAR CARTÃO DE CRÉDITO ----");
        System.out.print("Número do cartão: ");
        String numeroCartao = scanner.nextLine();
        System.out.print("Limite de crédito: ");
        double limiteCredito = Double.parseDouble(scanner.nextLine());

        CartaoCredito cartaoCredito = new CartaoCredito(numeroCartao, limiteCredito);
        conta.adicionarCartaoCredito(cartaoCredito);

        System.out.println("Cartão de crédito criado com sucesso!");
    }

    private void definirValorFatura(Scanner scanner) {
        System.out.println("---- DEFINIR VALOR DA FATURA ----");
        System.out.print("Valor da fatura: ");
        double valorFatura = Double.parseDouble(scanner.nextLine());
        System.out.print("Descrição da fatura: ");
        String descricaoFatura = scanner.nextLine();

        conta.gerarFatura(valorFatura, descricaoFatura);

        System.out.println("Fatura gerada com sucesso!");
    }
}

