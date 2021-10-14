package AtividadeHomework;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContaTest {

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso() {

        ContaCorrente contaCorrenteDeborah = Main.criarContaCorrenteDeborah();
        contaCorrenteDeborah.setSaldo(1000);
        contaCorrenteDeborah.setChequeEspecial(1000);

        boolean sacar = contaCorrenteDeborah.sacar(140);
        double saldo = contaCorrenteDeborah.getSaldo();

        assertTrue(sacar);
        assertEquals(860,saldo,0);
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        ContaCorrente contaCorrenteDeborah = Main.criarContaCorrenteDeborah();
        contaCorrenteDeborah.setSaldo(1000);
        contaCorrenteDeborah.setChequeEspecial(1000);

        boolean sacar = contaCorrenteDeborah.sacar(2500);
        double saldo = contaCorrenteDeborah.getSaldo();

        assertFalse(sacar);
        assertEquals(1000,saldo,0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso (){

        ContaPoupanca contaPoupancaJoao = Main.criarContaPoupancaJoao();
        contaPoupancaJoao.setSaldo(1000);
        contaPoupancaJoao.creditarTaxa();

        boolean sacar = contaPoupancaJoao.sacar(500);
        double saldo = contaPoupancaJoao.getSaldo();

        assertTrue(sacar);
        assertEquals(510,saldo,0);

    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {

        ContaPoupanca contaPoupancaJoao = Main.criarContaPoupancaJoao();
        contaPoupancaJoao.setSaldo(1000);
        contaPoupancaJoao.creditarTaxa();

        boolean sacar = contaPoupancaJoao.sacar(2000);
        double saldo = contaPoupancaJoao.getSaldo();

        assertFalse(sacar);
        assertEquals(1010,saldo,0);
    }

    @Test
    public void deveTestarSaqueContaPagamanetoEVerificarSaldoComSucesso() {

        ContaPagamento contaPagamentoMatheus = Main.criarContaPagamentoMatheus();
        contaPagamentoMatheus.setSaldo(1000);

        boolean sacar = contaPagamentoMatheus.sacar(500);
        double saldo = contaPagamentoMatheus.getSaldo();

        assertTrue(sacar);
        assertEquals(495.75 ,saldo,0);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {

        ContaPagamento contaPagamentoMatheus = Main.criarContaPagamentoMatheus();
        contaPagamentoMatheus.setSaldo(1000);

        boolean sacar = contaPagamentoMatheus.sacar(1100);
        double saldo = contaPagamentoMatheus.getSaldo();

        assertFalse(sacar);
        assertEquals(1000 ,saldo,0);

    }

    @Test
    public void deveTestarTranserenciaEVerificarSaldoComSucesso() {

        ContaPoupanca contaPoupancaJoao = Main.criarContaPoupancaJoao();
        contaPoupancaJoao.setSaldo(1000);

        ContaCorrente contaCorrenteDeborah = Main.criarContaCorrenteDeborah();
        contaCorrenteDeborah.setSaldo(1000);
        contaCorrenteDeborah.setChequeEspecial(1000);

        ContaPagamento contaPagamentoMatheus = Main.criarContaPagamentoMatheus();
        contaPagamentoMatheus.setSaldo(1000);

        boolean transferencia1 = contaCorrenteDeborah.transferir(contaPagamentoMatheus,100);
        boolean transferencia2 = contaCorrenteDeborah.transferir(contaPoupancaJoao,100);

        double saldoDeborah = contaCorrenteDeborah.getSaldo();
        double saldoMatheus = contaPagamentoMatheus.getSaldo();
        double saldoJoao = contaPoupancaJoao.getSaldo();


        assertTrue(transferencia1);
        assertTrue(transferencia2);
        assertEquals(800,saldoDeborah,0);
        assertEquals(1100,saldoMatheus,0);
        assertEquals(1100,saldoJoao,0);

    }

    @Test
    public void deveTestarTransferenciaSemSaldo() {
        ContaPoupanca contaPoupancaJoao = Main.criarContaPoupancaJoao();
        contaPoupancaJoao.setSaldo(1000);

        ContaCorrente contaCorrenteDeborah = Main.criarContaCorrenteDeborah();
        contaCorrenteDeborah.setSaldo(1000);
        contaCorrenteDeborah.setChequeEspecial(1000);

        ContaPagamento contaPagamentoMatheus = Main.criarContaPagamentoMatheus();
        contaPagamentoMatheus.setSaldo(1000);

        boolean transferencia1 = contaCorrenteDeborah.transferir(contaPagamentoMatheus,1100);
        boolean transferencia2 = contaCorrenteDeborah.transferir(contaPoupancaJoao,1100);

        double saldoDeborah = contaCorrenteDeborah.getSaldo();
        double saldoMatheus = contaPagamentoMatheus.getSaldo();
        double saldoJoao = contaPoupancaJoao.getSaldo();


        assertFalse(transferencia1);
        assertFalse(transferencia2);
        assertEquals(1000,saldoDeborah,0);
        assertEquals(1000,saldoMatheus,0);
        assertEquals(1000,saldoJoao,0);

    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso() {

        ContaPoupanca contaPoupancaJoao = Main.criarContaPoupancaJoao();
        contaPoupancaJoao.setSaldo(1000);

        ContaCorrente contaCorrenteDeborah = Main.criarContaCorrenteDeborah();
        contaCorrenteDeborah.setSaldo(1000);
        contaCorrenteDeborah.setChequeEspecial(1000);

        ContaPagamento contaPagamentoMatheus = Main.criarContaPagamentoMatheus();
        contaPagamentoMatheus.setSaldo(1000);

        boolean deposito1 = contaCorrenteDeborah.depositar(100);
        boolean deposito2 = contaPagamentoMatheus.depositar(100);
        boolean deposito3 = contaPoupancaJoao.depositar(100);
        double saldo1 = contaCorrenteDeborah.getSaldo();
        double saldo2 = contaPoupancaJoao.getSaldo();
        double saldo3 = contaPagamentoMatheus.getSaldo();

        assertTrue(deposito1);
        assertTrue(deposito2);
        assertTrue(deposito3);

        assertEquals(1100,saldo1,0);
        assertEquals(1100,saldo2,0);
        assertEquals(1100,saldo3,0);

    }

    @Test
    public void deveTestarDepositoNegativo() {

        ContaPoupanca contaPoupancaJoao = Main.criarContaPoupancaJoao();
        contaPoupancaJoao.setSaldo(1000);

        ContaCorrente contaCorrenteDeborah = Main.criarContaCorrenteDeborah();
        contaCorrenteDeborah.setSaldo(1000);
        contaCorrenteDeborah.setChequeEspecial(1000);

        ContaPagamento contaPagamentoMatheus = Main.criarContaPagamentoMatheus();
        contaPagamentoMatheus.setSaldo(1000);

        boolean deposito1 = contaCorrenteDeborah.depositar(-100);
        boolean deposito2 = contaPagamentoMatheus.depositar(-100);
        boolean deposito3 = contaPoupancaJoao.depositar(-100);
        double saldo1 = contaCorrenteDeborah.getSaldo();
        double saldo2 = contaPoupancaJoao.getSaldo();
        double saldo3 = contaPagamentoMatheus.getSaldo();

        assertFalse(deposito1);
        assertFalse(deposito2);
        assertFalse(deposito3);

        assertEquals(1000,saldo1,0);
        assertEquals(1000,saldo2,0);
        assertEquals(1000,saldo3,0);

    }

}
