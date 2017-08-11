public class ItemVerdadeiroFalso {
    private String enunciado;
    private boolean gabarito;

    ItemVerdadeiroFalso(String enunciado, boolean gabarito) {
        this.enunciado = enunciado;
        this.gabarito = gabarito;
    }

    public String getEnunciado() {
        return enunciado;
    }
}
