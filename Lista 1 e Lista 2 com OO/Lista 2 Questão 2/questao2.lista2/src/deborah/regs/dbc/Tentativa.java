package deborah.regs.dbc;

public class Tentativa {
    private int numero;

    public Tentativa(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean acertou(int digitado) {
        if (digitado == numero) {
            return true;
        }
        else {
            return false;
        }
    }
    public void comparaNumero(int digitado) {
        if (digitado > numero) {
            System.out.println("O número digitado é maior que o número correto, tente novamente.");
        }
        else if (digitado < numero) {
            System.out.println("o número digitado é menor que o número correto, tente novamente.");
        }
    }
}
