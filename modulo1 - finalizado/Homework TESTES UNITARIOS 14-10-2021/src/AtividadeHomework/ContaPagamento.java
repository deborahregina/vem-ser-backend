package AtividadeHomework;

public class ContaPagamento extends Conta implements Impressao {

    static final double TAXA_SAQUE = 4.25;

    public ContaPagamento() {
    }

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }



    @Override
    public void imprimir() {
        System.out.println("Nome do cliente: "+getCliente().getNome() +" | Número da conta: " + getNumeroConta() + " | Agência: " + getAgencia() + " | Saldo: "+ df.format(getSaldo()));
    }

    @Override
    public boolean sacar(double valor) {
        if (getSaldo() > (valor + TAXA_SAQUE) && valor > 0) {
            setSaldo(getSaldo() - valor - TAXA_SAQUE);
            return true;
        }
        System.out.println("Saldo insuficiente. Saque máximo de: " + df.format(getSaldo()));
        return false;
    }
}
