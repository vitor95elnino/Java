package com.mycompany.tp2;
import java.util.Scanner;

public class TP2 {
    
    public static void main(String[] args) {
        ContaService contaService = new ContaService();
        Scanner input = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU - GESTÃO DE CONTAS =====");
            System.out.println("1. Criar Conta");
            System.out.println("2. Consultar Conta");
            System.out.println("3. Alterar Conta");
            System.out.println("4. Eliminar Conta");
            System.out.println("5. Levantamentos");
            System.out.println("6. Depósitos");
            System.out.println("7. Transferências");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = input.nextInt();
            input.nextLine(); // limpar buffer

            String nConta, nome, morada;
            double valor;

            switch (opcao) {
                case 1:
                    System.out.println("Tipo de conta: 1) Prazo  2) Ordem  3) Ordenado");
                    int tipo = input.nextInt();
                    input.nextLine();
                    System.out.print("Número da conta: ");
                    nConta = input.nextLine();
                    System.out.print("Nome do titular: ");
                    nome = input.nextLine();
                    System.out.print("Morada: ");
                    morada = input.nextLine();
                    System.out.print("Saldo inicial: ");
                    valor = input.nextDouble();
                    input.nextLine();

                    Conta novaConta = null;
                    if (tipo == 1) {
                        System.out.print("Prazo em dias: ");
                        int prazo = input.nextInt();
                        input.nextLine();
                        System.out.print("Data de criação: ");
                        String data = input.nextLine();
                        System.out.print("Taxa de juro: ");
                        double taxa = input.nextDouble();
                        input.nextLine();
                        novaConta = new ContaPrazo(nConta, nome, morada, valor, prazo, data, taxa);
                    } else if (tipo == 2) {
                        System.out.print("Saldo mínimo: ");
                        double saldoMin = input.nextDouble();
                        input.nextLine();
                        System.out.print("Tem cartão de crédito? (true/false): ");
                        boolean cartao = input.nextBoolean();
                        input.nextLine();
                        novaConta = new ContaOrdem(nConta, nome, morada, valor, saldoMin, cartao);
                    } else if (tipo == 3) {
                        System.out.print("Saldo mínimo: ");
                        double saldoMin = input.nextDouble();
                        input.nextLine();
                        System.out.print("Tem cartão de crédito? (true/false): ");
                        boolean cartao = input.nextBoolean();
                        input.nextLine();
                        System.out.print("Limite negativo: ");
                        double limite = input.nextDouble();
                        input.nextLine();
                        novaConta = new ContaOrdenado(nConta, nome, morada, valor, saldoMin, cartao, limite);
                    }
                    if (novaConta != null) {
                        contaService.criar(novaConta);
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Erro ao criar conta.");
                    }
                    break;

                case 2:
                    System.out.print("Número da conta: ");
                    nConta = input.nextLine();
                    Conta conta = contaService.consultar(nConta);
                    if (conta != null) {
                        System.out.println("Nome: " + conta.getNomeConta());
                        System.out.println("Morada: " + conta.getMorada());
                        System.out.println("Saldo: " + conta.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.print("Número da conta: ");
                    nConta = input.nextLine();
                    System.out.print("Novo nome: ");
                    nome = input.nextLine();
                    System.out.print("Nova morada: ");
                    morada = input.nextLine();
                    if (contaService.alterar(nConta, nome, morada)) {
                        System.out.println("Conta alterada.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Número da conta: ");
                    nConta = input.nextLine();
                    if (contaService.eliminar(nConta)) {
                        System.out.println("Conta eliminada.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 5:
                    System.out.print("Número da conta: ");
                    nConta = input.nextLine();
                    System.out.print("Valor a levantar: ");
                    valor = input.nextDouble();
                    input.nextLine();
                    if (contaService.levantar(nConta, valor)) {
                        System.out.println("Levantamento efetuado.");
                    } else {
                        System.out.println("Erro: saldo insuficiente ou conta não encontrada.");
                    }
                    break;

                case 6:
                    System.out.print("Número da conta: ");
                    nConta = input.nextLine();
                    System.out.print("Valor a depositar: ");
                    valor = input.nextDouble();
                    input.nextLine();
                    if (contaService.depositar(nConta, valor)) {
                        System.out.println("Depósito efetuado.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 7:
                    System.out.print("Número da conta de origem: ");
                    String deConta = input.nextLine();
                    System.out.print("Número da conta de destino: ");
                    String paraConta = input.nextLine();
                    System.out.print("Valor a transferir: ");
                    valor = input.nextDouble();
                    input.nextLine();
                    if (contaService.transferir(deConta, paraConta, valor)) {
                        System.out.println("Transferência efetuada.");
                    } else {
                        System.out.println("Erro na transferência. Verifique contas ou saldo.");
                    }
                    break;

                case 0:
                    System.out.println("A sair...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        input.close();
    }
}

