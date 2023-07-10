package FinApp;
import java.util.Scanner;
import java.util.List;

public class MenuUsuario {
    private Usuario usuario;
    private Scanner scanner;

    public MenuUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        boolean sair = false;

        while (!sair) {
            System.out.println("---- MENU DO USUÁRIO ----");
            System.out.println("1. Criar conta");
            System.out.println("2. Acessar conta");
            System.out.println("3. Ver pontos");
            System.out.println("4. Ver relatório financeiro");
            System.out.println("5. Criar planejamento financeiro");
            System.out.println("6. Ver planejamentos");
            System.out.println("7. Ver saldo total");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarConta(scanner);
                    break;
                case 2:
                    acessarConta(scanner);
                    break;
                case 3:
                    verPontos();
                    break;
                case 4:
                    verRelatorioFinanceiro();
                    break;
                case 5:
                    criarPlanejamentoFinanceiro(scanner);
                    break;
                case 6:
                    verPlanejamentos();
                    break;
                case 7:
                    verSaldoTotal();
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

        scanner.close();
    }

    private void criarConta(Scanner scanner) {
        System.out.println("---- CRIAR CONTA ----");
        System.out.print("Número da conta: ");
        String numero = scanner.nextLine();
        System.out.print("Descrição da conta: ");
        String descricao = scanner.nextLine();

        Conta novaConta = new Conta(numero, descricao, 0.0, usuario);
        usuario.adicionarConta(novaConta);

        System.out.println("Conta criada com sucesso!");
    }

    private void acessarConta(Scanner scanner) {
        System.out.println("---- ACESSAR CONTA ----");
        System.out.println("Contas disponíveis:");

        List<Conta> contas = usuario.getContas();
        for (int i = 0; i < contas.size(); i++) {
            Conta conta = contas.get(i);
            System.out.println((i + 1) + ". " + conta.getDescricao());
        }

        System.out.print("Escolha o número da conta: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha >= 1 && escolha <= contas.size()) {
            Conta contaSelecionada = contas.get(escolha - 1);
            MenuConta menuConta = new MenuConta(contaSelecionada);
            menuConta.exibirMenu(scanner); // Passa o Scanner como parâmetro para o MenuConta
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private void verPontos() {
        Pontos pontos = usuario.getPontos();
        System.out.println("Você possui " + pontos.getSaldo() + " pontos.");
    }

    private void verRelatorioFinanceiro() {
        RelatorioFinanceiro relatorio = new RelatorioFinanceiro();
        relatorio.gerarRelatorio(usuario);
    }

    private void criarPlanejamentoFinanceiro(Scanner scanner) {
        System.out.println("---- CRIAR PLANEJAMENTO FINANCEIRO ----");
        System.out.print("Objetivo: ");
        String objetivo = scanner.nextLine();
        System.out.print("Saldo alvo: ");
        double saldoAlvo = scanner.nextDouble();
        scanner.nextLine();

        PlanejamentoFinanceiro novoPlanejamento = new PlanejamentoFinanceiro(objetivo, saldoAlvo);
        usuario.adicionarPlanejamento(novoPlanejamento);

        System.out.println("Planejamento financeiro criado com sucesso!");
    }

    private void verPlanejamentos() {
        List<PlanejamentoFinanceiro> planejamentos = usuario.getPlanejamentos();

        if (planejamentos.isEmpty()) {
            System.out.println("Não há planejamentos cadastrados.");
        } else {
            System.out.println("---- PLANEJAMENTOS FINANCEIROS ----");
            for (PlanejamentoFinanceiro planejamento : planejamentos) {
                double saldoAtual = usuario.getSaldoTotal();
                double saldoFaltante = planejamento.getSaldoAlvo() - saldoAtual;

                System.out.println("Objetivo: " + planejamento.getObjetivo());
                System.out.println("Saldo faltante: " + saldoFaltante);
                if (saldoFaltante <= 0) {
                    System.out.println("Objetivo alcançado!");
                }
                System.out.println();
            }
        }
    }


    private void verSaldoTotal() {
        double saldoTotal = usuario.getSaldoTotal();
        System.out.println("Saldo total: " + saldoTotal);
    }
}