package deborah.regs.dbc;

public class ListadeNumeros { // reutilizando a classe da questão anterior, pois também é uma lista de números

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
        public boolean procuraNumero(int j) {
            for (int i = 0; i < inteiros.length; i++) {
                if (inteiros[i] == j) {
                    System.out.println("O número " + inteiros[i] + " está no vetor");
                    return true;
                }
            }
            System.out.println("O número " + j + " não está no vetor");
            return false;
    }
}
