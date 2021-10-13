package deborah.regs.dbc;

public class Main {

    public static void main(String[] args) {

        Cachorro dog = new Cachorro("Catioro");
        Gato cat = new Gato("Miauzinho");
        Cachorro dogQuetemnome = new Cachorro("Thor");
        Animal gatoEspecial = new Gato();
        Animal cachorroEspecial = new Cachorro("Mel");

        System.out.println(dog.late());
        System.out.println(dogQuetemnome.getNome() + " " + cachorroEspecial.getNome());
        System.out.println(dog.caminha());
        System.out.println(cat.mia());
        System.out.println(cat.caminha());

    }
}
