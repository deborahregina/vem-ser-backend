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
        if (valor < (saldo + chequeEspecial) && valor > 0) {
            saldo = saldo - valor;
        }
        return valor < (saldo + chequeEspecial) && valor > 0;

    }

    public boolean depositar (double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
        }
        return valor > 0;
    }

    public double retornarSaldoComChequeEspecial() {

        return saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente conta, double valor) {
        if ((this.saldo + this.chequeEspecial) > valor && valor > 0 ) {
            this.saldo -= valor;
            conta.saldo += valor;
        }
        return (this.saldo + this.chequeEspecial) > valor && valor > 0;
    }
}
