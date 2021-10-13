package AtividadeHomework;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente cliente1 = new Cliente("Deborah", "112233445");

        Cliente cliente2 = new Cliente("Matheus","1234657465");


        ContaCorrente contaDeborah = new ContaCorrente(cliente1,"1212.1",12, 10000,1000);

        ContaCorrente contaMatheus = new ContaCorrente(cliente2,"121314",123,4000,600);

        boolean opcoesOk = true;
        while (opcoesOk) {
            System.out.println("Escolha uma conta para efetuar uma operação: ");
            System.out.println("1- " + cliente1.getNome());
            System.out.println("2- " + cliente2.getNome());
            int opcaoCliente = scanner.nextInt();
            System.out.println("Qual operação deseja realizar: \n1- Depositar \n2- Transferir \n3- Sacar \n4- Obter saldo total \n5- Imprimir dados da conta\n6-Sair");
            int opcaoDeTransacao = scanner.nextInt();

            switch (opcaoDeTransacao) {
                case 1:
                    System.out.println("Qual valor deseja depositar? ");
                    double valorDeposito = scanner.nextDouble();
                    if (opcaoCliente == 1 && contaDeborah.depositar(valorDeposito)) {
                        System.out.println("O saldo atual desta conta é: " + contaDeborah.getSaldo());
                    }
                    if (opcaoCliente == 1 && !contaDeborah.depositar(valorDeposito)) {
                        System.out.println("Não foi possível realizar essa operação!");
                    }
                    if (opcaoCliente == 2 && contaMatheus.depositar(valorDeposito)) {
                        System.out.println("O saldo atual desta conta é: " + contaMatheus.getSaldo());
                    }
                    if (opcaoCliente == 2 && !contaMatheus.depositar(valorDeposito)) {
                        System.out.println("Não foi possível realizar essa operação!");
                    }
                    break;
                case 2:
                    if (opcaoCliente == 1) {
                        System.out.println("Deseja transferir para " + cliente2.getNome() + " \n1- sim \n2- não");
                        int opcaoConfirma = scanner.nextInt();
                        if (opcaoConfirma == 2) {
                            break;
                        }
                        if (opcaoConfirma == 1) {
                            System.out.println("Digite a quantia a ser transferida: ");
                            double valorTransferencia = scanner.nextDouble();
                            if (contaDeborah.transferir(contaMatheus, valorTransferencia)) {
                                System.out.println("O novo saldo de Matheus é: " + contaMatheus.getSaldo());
                            }
                            else {
                                System.out.println("Não foi possível realizar a transferência");
                            }
                        }
                    }
                    if (opcaoCliente == 2) {
                        System.out.println("Deseja transferir para " + cliente1.getNome() + " \n1- sim \n2- não");
                        int opcaoConfirma = scanner.nextInt();
                        if (opcaoConfirma == 2) {
                            break;
                        }
                        if (opcaoConfirma == 1) {
                            System.out.println("Digite a quantia a ser transferida: ");
                            double valorTransferencia = scanner.nextDouble();
                            if (contaMatheus.transferir(contaDeborah, valorTransferencia)) {
                                System.out.println("O novo saldo de Deborah é: " + contaDeborah.getSaldo());
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
                            System.out.println("O novo saldo desta conta é: " + contaDeborah.getSaldo());
                        }
                        else {
                            System.out.println("Não foi possível realizar o saque.");
                        }
                    }
                    if (opcaoCliente == 2) {
                        if (contaMatheus.sacar(valorSaque)) {
                            System.out.println("O novo saldo desta conta é: " + contaMatheus.getSaldo());
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
                        System.out.println(contaDeborah.toString());
                    }
                    if (opcaoCliente == 2) {
                        System.out.println(contaMatheus.toString());
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
