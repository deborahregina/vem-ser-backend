package AtividadeHomework;

import java.text.DecimalFormat;

public abstract class Conta implements Movimentacao {

    public DecimalFormat df = new DecimalFormat("###,###.00");
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    public Conta() {

    }

    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
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

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    @Override
    public boolean sacar(double valor) {
        if (getSaldo() >= valor && valor > 0) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        System.out.println("Saldo insuficiente. Saque máximo de: " + df.format(getSaldo()));
        return false;
    }

    @Override
    public boolean depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
        }
        return valor > 0;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (this.getSaldo() > valor && valor > 0) {
            conta.setSaldo(conta.getSaldo() + valor);
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }
        System.out.println("Saldo insuficente. Transferência máxima de: " + df.format(getSaldo()));
        return false;
    }

}
