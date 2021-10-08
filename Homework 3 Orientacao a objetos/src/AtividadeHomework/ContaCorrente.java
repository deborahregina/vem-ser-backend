package AtividadeHomework;

public class ContaCorrente {

    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("Número da conta: " + numeroConta + "\nAgência: " + agencia);
    }

    public boolean sacar (double valor) {

        return valor < (saldo + chequeEspecial) && valor > 0;

    }

    public boolean depositar (double valor) {
        return valor > 0;
    }

    public double retornarSaldoComChequeEspecial() {

        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta, double valor) {

        return (this.saldo + this.chequeEspecial) > valor && valor > 0;
    }
}
