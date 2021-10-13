package AtividadeHomework;

public class ContaPoupanca extends Conta implements Impressao{

    static final double JUROS_MENSAIS = 1.01;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        setSaldo(getSaldo()*JUROS_MENSAIS);
    }

    @Override
    public void imprimir() {
        System.out.println("Nome do cliente: "+getCliente().getNome() +" | Número da conta: " + getNumeroConta() + " | Agência: " + getAgencia() + " | Saldo: "+ df.format(getSaldo()));
    }

}
