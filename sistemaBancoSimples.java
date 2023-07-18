package com.mycompany.sistemabancosimples;
import java.util.Scanner;

public class sistemaBancoSimples {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean verificador = false;

        System.out.println("=================================");
        System.out.println("|Seja bem vindo ao Alura Bank   |");
        System.out.println("=================================");

        System.out.println("Para começarmos a realizar suas transações e recebimentos. Por favor me infome seu nome: ");
        String nomeCliente = scanner.next();
        System.out.println("Agora digite, se o sua conta é corrente (corrente) ou poupança (poupanca): ");
        String tipoDeConta = scanner.next();
        while (verificador == false) {
            if (tipoDeConta.equalsIgnoreCase("corrente") || tipoDeConta.equalsIgnoreCase("poupanca")) {
                verificador = true;
                break;
            } else {
                System.out.println("Não entendi, por favor me informe se é corrente ou poupança: ");
                tipoDeConta = scanner.next();
            }
        }
        System.out.println("Por fim, me informe o seu saldo atual: ");
        double saldoConta = scanner.nextDouble();

        String informacao = """
                ****************************
                Cliente: %s
                Tipo de conta: %s
                Saldo Inicial: %.2f reais
                ****************************
                """.formatted(nomeCliente, tipoDeConta, saldoConta);
        String operacoes = """

                Operações:

                1- Consultar saldo
                2- Receber valor
                3- Transferir valor
                4- Sair

                Digite a opção a desejada:
                """;
        System.out.println(informacao);

        int opcao = 0;
        while (opcao != 4) {
            System.out.println(operacoes);
            opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("O seu saldo atual é " + saldoConta + " reais");

            }else if (opcao == 2) {
                System.out.println("Quanto será o valor a receber: ");
                double receberValor = scanner.nextDouble();
                saldoConta += receberValor;
                System.out.println("O saldo da conta atualizado é " + saldoConta + " reais");

            }else if (opcao == 3) {
                System.out.println("Informe qual o valor a ser transferido: ");
                double transferirSaldo = scanner.nextDouble();
                if (transferirSaldo > saldoConta) {
                    System.out.println("O valor da transferência, não pode ser maior que o saldo. \nSaldo atual: " + saldoConta + " reais");
                    System.out.println("Gostaria ainda de realizar uma transferência? (Sim/Não)");
                    String transferirSimNão = scanner.next();
                    if (transferirSimNão.equalsIgnoreCase("não")) {
                        System.out.println("Tudo bem, voltaremos para caixa de Operações");
                    }else if (transferirSimNão.equalsIgnoreCase("sim")) {
                        System.out.println("Informe qual o valor a ser transferido: ");
                        transferirSaldo = scanner.nextDouble();
                        if (transferirSaldo > saldoConta) {  // Aqui seria a ultima verificação se o pedido do usuário para transferência é maior que o saldo que possuí //
                            System.out.println("Você não possui fundos suficientes!\nIremos voltar a caixa de operações.");
                        }else{
                            saldoConta -= transferirSaldo;
                            System.out.println("Transferência realizada com sucesso!");
                            System.out.println("O saldo da conta atualizado é " + saldoConta + " reais");
                        }                              
                    }else{
                        System.out.println("Não entendi, voltaremos para a caixa de operações."); 
                    }
                }else{
                    saldoConta -= transferirSaldo;
                    System.out.println("Transferência realizada com sucesso!");
                    System.out.println("O saldo da conta atualizado é " + saldoConta + " reais");  
                }

            }else if (opcao == 4){
                System.out.println("Operações finalizadas, o Alura Bank agradece!");  // Mensagem de agradecimento do Banco, após finalização de processos//
                break;
            }else{
                System.out.println("\nOpção inválida!\nTente novamente.");
            }
        }
    }
}
