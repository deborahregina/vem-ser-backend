package AtividadeHomework;

public class ContaCorrente {

    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;
    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    @Override
    public String toString(){
        return "Número da conta: " + numeroConta + "\nAgência: " + agencia + "\nSalto: "+saldo;
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
