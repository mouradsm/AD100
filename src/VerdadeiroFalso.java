public class VerdadeiroFalso extends Questao {
    private ItemVerdadeiroFalso[] itens;
    private String enunciado;

    VerdadeiroFalso(ItemVerdadeiroFalso[] itens) {
        this.itens = itens;
    }

    public ItemVerdadeiroFalso[] getItens() {
        return this.itens;
    }

    public String toString() {
        this.enunciado = "Assinale verdadeiro ou falso para os itens: \n";
        for (ItemVerdadeiroFalso i : itens) {
            this.enunciado += ("( )" + i.getEnunciado() + "\n");
        }

        return this.enunciado;
    }

    public String getEnunciado() {
        return this.enunciado;
    }
}
