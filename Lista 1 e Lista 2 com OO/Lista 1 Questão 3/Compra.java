package deborah.regs.dbc;

public class Compra {
    private double valorProprio;
    private double valorPago;
    private double troco;

    public Compra(double valorProprio, double valorPago) {
        this.valorProprio = valorProprio;
        this.valorPago = valorPago;
    }

    public double getValorProprio() {
        return valorProprio;
    }

    public double getTroco() {
        return troco;
    }

    public void setTroco(double troco) {
        this.troco = troco;
    }

    public void setValorProprio(double valorProprio) {
        this.valorProprio = valorProprio;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public boolean calculaTroco(double valorProprio, double valorPago) {
        boolean valido = false;
        if (valorPago > valorProprio) {
            this.troco = this.valorPago - this.valorProprio;
            valido = true;
        }
        else {
            this.troco = 0;
        }
        return valido;
    }

    @Override
    public String toString() {
        String efetuado = "Não ";
        if (calculaTroco(valorProprio,valorPago)){
            return "Foi possível realizar o pagamento, e o troco é: " + troco;
        }
        else {
            return "Não foi possível realizar o pagamento.";
        }
    }

}
