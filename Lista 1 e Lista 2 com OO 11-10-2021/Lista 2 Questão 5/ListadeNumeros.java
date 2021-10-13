package deborah.regs.dbc;

public class ListadeNumeros {
    private int [] inteiros;

    public ListadeNumeros(int[] inteiros) {
        this.inteiros = inteiros;
    }

    public int[] getInteiros() {
        return inteiros;
    }

    public void setInteiros(int[] inteiros) {
        this.inteiros = inteiros;
    }

    public void imprimeListaOrdemInversa(int i) {
        System.out.println("Ordem inversa: ");
        for (int k = i; k >= 0; k -- ) {
            System.out.println(inteiros[k]);
        }
    }
    public void imprimeListaOrdemCerta(int i) {
        System.out.println("Ordem correta: ");
        for (int j = 0; j < i; j ++){
            System.out.println(inteiros[j]);
        }
    }
}
