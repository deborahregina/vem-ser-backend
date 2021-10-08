package AtividadeHomework;

public class Contato {
    String descricao;
    String telefone;
    int tipo;

    public void imprimirContato() {
        String tipoContato;

        if (this.tipo == 1) {
            tipoContato = "Residencial";
        }
        else {
            tipoContato = "Comercial";
        }
        System.out.println("Tipo de contato: " + tipoContato + "\nTelefone: " + telefone + "\nDescriçaõ: " + descricao);
    }
}
