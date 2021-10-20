package AtividadeHomework;
import java.util.Scanner;

public class Main {

    public static ContaCorrente criarContaCorrenteDeborah() {

        Cliente cliente1 = new Cliente("Deborah", "112233445");
        ContaCorrente contaDeborah = new ContaCorrente(cliente1, "1212.1", "122", 10000, 1000);
        return contaDeborah;
    }

    public static ContaPoupanca criarContaPoupancaJoao() {

        Cliente cliente3 = new Cliente("João", "990011234");
        ContaPoupanca contaJoao = new ContaPoupanca(cliente3, "33345", "124", 5000);
        return contaJoao;

    }

    public static ContaPagamento criarContaPagamentoMatheus() {

        Cliente cliente2 = new Cliente("Matheus", "1234657465");
        ContaPagamento contaMatheus = new ContaPagamento(cliente2, "121314", "123", 4000);
        return contaMatheus;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ContaCorrente contaDeborah = criarContaCorrenteDeborah();
        ContaPoupanca contaJoao = criarContaPoupancaJoao();
        ContaPagamento contaMatheus = criarContaPagamentoMatheus();


//        System.out.println("Dados iniciais");
//        contaJoao.imprimir();
//        contaDeborah.imprimir();
//        contaMatheus.imprimir();
//
//        System.out.println("----------------------Transações----------------------");
//        System.out.println("Saque de 600,00 na conta do João: ");
//        contaJoao.sacar(600);
//        contaJoao.imprimir();
//        System.out.println("======================================================");
//        System.out.println("Depósito de 1.000,00 na conta do João: ");
//        contaJoao.depositar(1000);
//        contaJoao.imprimir();
//        System.out.println("======================================================");
//        System.out.println("Creditar taxa na conta do João: ");
//        contaJoao.creditarTaxa();
//        contaJoao.imprimir();
//        System.out.println("======================================================");
//        System.out.println("Transferência de 2.000,00 da conta do João para a conta da Deborah: ");
//        contaJoao.transferir(contaDeborah,2000);
//        contaJoao.imprimir();
//        contaDeborah.imprimir();
//        System.out.println("======================================================");
//        System.out.println("Saque de 10.000,00 na conta do Matheus: ");
//        contaMatheus.sacar(10000);
//        contaMatheus.imprimir();
//        System.out.println("======================================================");
//        System.out.println("Depósito de 1.000,00 na conta do Matheus: ");
//        contaMatheus.depositar(1000);
//        contaMatheus.imprimir();
//        System.out.println("======================================================");
//        System.out.println("Transferência de 2.000,00 da conta do Matheus para a conta do João: ");
//        contaMatheus.transferir(contaJoao,2000);
//        contaJoao.imprimir();
//        contaMatheus.imprimir();
//        System.out.println("======================================================");
//        System.out.println("Saque de 100,00 na conta da Deborah: ");
//        contaDeborah.sacar(100);
//        contaDeborah.imprimir();
//        System.out.println("======================================================");
//        System.out.println("Transferência de 100,00 da conta da Deborah para a conta do João: ");
//        contaDeborah.transferir(contaJoao,100);
//        contaJoao.imprimir();
//        contaDeborah.imprimir();


    }
}

