package AtividadeHomework;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente1 = new Cliente();
        cliente1.nome = "Deborah";
        cliente1.cpf = "112233445";

        Cliente cliente2 = new Cliente();
        cliente2.nome = "Matheus";
        cliente2.cpf = "11223345";

        ContaCorrente contaDeborah = new ContaCorrente(); //
        contaDeborah.cliente = cliente1;
        contaDeborah.agencia = 1122;
        contaDeborah.numeroConta = "1234";
        contaDeborah.saldo = 1000.00;
        contaDeborah.chequeEspecial = 400.00;

        ContaCorrente contaMatheus = new ContaCorrente();
        contaMatheus.cliente = cliente2;
        contaMatheus.agencia = 1125;
        contaMatheus.numeroConta = "123456";
        contaMatheus.saldo = 5000.00;
        contaMatheus.chequeEspecial = 1100.00;

        boolean opcoesOk = true;
        while (opcoesOk) {
            System.out.println("Escolha uma conta para efetuar uma operação: ");
            System.out.println("1- " + cliente1.nome);
            System.out.println("2- " + cliente2.nome);
            int opcaoCliente = scanner.nextInt();
            System.out.println("Qual operação deseja realizar: \n1- Depositar \n2- Transferir \n3- Sacar \n4- Obter saldo total \n5- Imprimir dados da conta\n6-Sair");
            int opcaoDeTransacao = scanner.nextInt();

            switch (opcaoDeTransacao) {
                case 1:
                    System.out.println("Qual valor deseja depositar? ");
                    double valorDeposito = scanner.nextDouble();
                    if (opcaoCliente == 1 && contaDeborah.depositar(valorDeposito)) {
                        System.out.println("O saldo atual desta conta é: " + contaDeborah.saldo);
                    }
                    if (opcaoCliente == 1 && !contaDeborah.depositar(valorDeposito)) {
                        System.out.println("Não foi possível realizar essa operação!");
                    }
                    if (opcaoCliente == 2 && contaMatheus.depositar(valorDeposito)) {
                        System.out.println("O saldo atual desta conta é: " + contaMatheus.saldo);
                    }
                    if (opcaoCliente == 2 && !contaMatheus.depositar(valorDeposito)) {
                        System.out.println("Não foi possível realizar essa operação!");
                    }
                    break;
                case 2:
                    if (opcaoCliente == 1) {
                        System.out.println("Deseja transferir para " + cliente2.nome + " \n1- sim \n2- não");
                        int opcaoConfirma = scanner.nextInt();
                        if (opcaoConfirma == 2) {
                            break;
                        }
                        if (opcaoConfirma == 1) {
                            System.out.println("Digite a quantia a ser transferida: ");
                            double valorTransferencia = scanner.nextDouble();
                            if (contaDeborah.transferir(contaMatheus, valorTransferencia)) {
                                System.out.println("O novo saldo de Matheus é: " + contaMatheus.saldo);
                            }
                            else {
                                System.out.println("Não foi possível realizar a transferência");
                            }
                        }
                    }
                    if (opcaoCliente == 2) {
                        System.out.println("Deseja transferir para " + cliente1.nome + " \n1- sim \n2- não");
                        int opcaoConfirma = scanner.nextInt();
                        if (opcaoConfirma == 2) {
                            break;
                        }
                        if (opcaoConfirma == 1) {
                            System.out.println("Digite a quantia a ser transferida: ");
                            double valorTransferencia = scanner.nextDouble();
                            if (contaMatheus.transferir(contaDeborah, valorTransferencia)) {
                                System.out.println("O novo saldo de Deborah é: " + contaDeborah.saldo);
                            }
                            else {
                                System.out.println("não foi possível realizar a transferência");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Quanto deseja sacar? ");
                    double valorSaque = scanner.nextDouble();
                    if (opcaoCliente == 1) {
                        if (contaDeborah.sacar(valorSaque)) {
                            System.out.println("O novo saldo desta conta é: " + contaDeborah.saldo);
                        }
                        else {
                            System.out.println("Não foi possível realizar o saque.");
                        }
                    }
                    if (opcaoCliente == 2) {
                        if (contaMatheus.sacar(valorSaque)) {
                            System.out.println("O novo saldo desta conta é: " + contaMatheus.saldo);
                        }
                        else {
                            System.out.println("Não foi possível realizar o saque.");
                        }
                    }
                    break;
                case 4:
                    if (opcaoCliente == 1) {
                        System.out.println(contaDeborah.retornarSaldoComChequeEspecial());
                    }
                    if (opcaoCliente == 2) {
                        System.out.println(contaMatheus.retornarSaldoComChequeEspecial());
                    }
                    break;
                case 5:
                    if (opcaoCliente == 1) {
                        contaDeborah.imprimirContaCorrente();
                    }
                    if (opcaoCliente == 2) {
                        contaMatheus.imprimirContaCorrente();
                    }
                    break;
                case 6:
                    opcoesOk = false;
                default:
                    System.out.println("Operacao inválida.");
                    break;

            }

        }
    }
}
