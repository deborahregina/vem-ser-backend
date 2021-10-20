package deborah.regs.dbc;

public class Palavra {
    private String palavraEmPt;
    private String palavraEmIngles;

    public Palavra(String palavraEmPt, String palavraEmIngles) {
        this.palavraEmPt = palavraEmPt;
        this.palavraEmIngles = palavraEmIngles;
    }

    public String getPalavraEmPt() {
        return palavraEmPt;
    }

    public void setPalavraEmPt(String palavraEmPt) {
        this.palavraEmPt = palavraEmPt;
    }

    public String getPalavraEmIngles() {
        return palavraEmIngles;
    }

    public void setPalavraEmIngles(String palavraEmIngles) {
        this.palavraEmIngles = palavraEmIngles;
    }

    public void traducao(String palavra) {
        if (palavra.equalsIgnoreCase(palavraEmPt)) {
            System.out.println(palavraEmIngles);
        }
        if (palavra.equalsIgnoreCase(palavraEmIngles)) {
            System.out.println(palavraEmPt);
        }
    }
}
