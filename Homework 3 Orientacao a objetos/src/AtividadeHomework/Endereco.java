package AtividadeHomework;

public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco(){
        String tipoEndereco;

        if (this.tipo == 1) {
        tipoEndereco = "Residencial";
        }
        else {
            tipoEndereco = "Comercial";
        }
        System.out.println("Tipo de endereço: " +tipoEndereco+"\nLogradouro: " + logradouro + "\nNúmero: " + numero + "\ncep: " + cep + "\nCidade: " + cidade + "\nPaís: " + pais);
    }
}
