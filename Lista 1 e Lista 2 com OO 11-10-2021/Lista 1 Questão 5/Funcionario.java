package deborah.regs.dbc;
import java.text.DecimalFormat;

public class Funcionario {
    double horaDeTrabalho;
    int horasNormais;
    int horas50Extra;
    int horas100Extra;

    public Funcionario(double horaDeTrabalho, int horasNormais, int horas50Extra, int horas100Extra) {
        this.horaDeTrabalho = horaDeTrabalho;
        this.horasNormais = horasNormais;
        this.horas50Extra = horas50Extra;
        this.horas100Extra = horas100Extra;
    }

    public Funcionario() {

    }

    public double getHoraDeTrabalho() {
        return horaDeTrabalho;
    }

    public void setHoraDeTrabalho(double horaDeTrabalho) {
        this.horaDeTrabalho = horaDeTrabalho;
    }

    public int getHorasNormais() {
        return horasNormais;
    }

    public void setHorasNormais(int horasNormais) {
        this.horasNormais = horasNormais;
    }

    public int getHoras50Extra() {
        return horas50Extra;
    }

    public void setHoras50Extra(int horas50Extra) {
        this.horas50Extra = horas50Extra;
    }

    public int getHoras100Extra() {
        return horas100Extra;
    }

    public void setHoras100Extra(int horas100Extra) {
        this.horas100Extra = horas100Extra;
    }

    public void menuDeCalculo() {
        System.out.println("Digite o valor da hora trabalhada: ");
        this.horaDeTrabalho = Main.scanner.nextDouble();
        System.out.println("Digite o número de horas normais trabalhadas: ");
        this.horasNormais = Main.scanner.nextInt();
        System.out.println("Digite o número de horas extras 50%: ");
        this.horas50Extra = Main.scanner.nextInt();
        System.out.println("Digite o número de horas extras 100%: ");
        this.horas100Extra = Main.scanner.nextInt();
    }

    public String calculaSalario() {
        return "Salário do funcionário: R$"+ Main.df.format(horaDeTrabalho*(horaDeTrabalho + 1.5*horas50Extra + 2*horas100Extra));
    }
}
