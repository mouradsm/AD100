public class Discursiva extends Questao {
    private String gabarito;

    Discursiva(String enunciado, String gabarito) {
        super(enunciado);
        this.gabarito = gabarito;
    }

    public String getGabarito() {
        return this.gabarito;
    }

    public String toString() {
        return this.getEnunciado() + "\n";
    }
}
