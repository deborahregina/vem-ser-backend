package AtividadeHomework;

public class ContaCorrente extends Conta implements Impressao {


    private double chequeEspecial;

    public ContaCorrente(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome do cliente: "+getCliente().getNome() +" | Número da conta: " + getNumeroConta() + " | Agência: " + getAgencia() + " | Saldo: "+ df.format(getSaldo()) + " | Cheque Especial: " + df.format(chequeEspecial));
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar (double valor) {
        if (valor < (getSaldo() + chequeEspecial) && valor > 0) {
            setSaldo(getSaldo() - valor);
            return true;
        }
        System.out.println("Saldo não suficiente! Sacar menos de: " + (getSaldo()+chequeEspecial));
        return valor < (getSaldo() + chequeEspecial) && valor > 0;
    }


}
