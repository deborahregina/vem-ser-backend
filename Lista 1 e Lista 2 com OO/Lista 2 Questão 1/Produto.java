package deborah.regs.dbc;

public class Produto {
    private String nome;
    private double valor;
    private double desconto;

    public Produto(String nome, double valor,double desconto) {
        this.nome = nome;
        this.valor = valor;
        this.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public void aplicaDesconto() {
        System.out.println("Item: " + nome +"\nPreço unitário: " + valor + "\nPromoção: " + nome);
        System.out.println("------------------------");
        for (int i = 1;i <= 10; i++) {
            desconto = valor - valor*0.05*i;
            System.out.println(String.format("%d X R$%.2f = %.2f",i,desconto,desconto*i));
        }
    }
}
