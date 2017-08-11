class Prova {
    private Questao[] questoes;

    public Prova(int quantidadeQuestoes) {

        this.questoes = new Questao[quantidadeQuestoes];

        questoes[0] = new Discursiva("Qual é o número da última versão de Java?", "8");

        ItemVerdadeiroFalso[] itens = new ItemVerdadeiroFalso[3];

        itens[0] = new ItemVerdadeiroFalso("Java foi lançada há mais de 20 anos atrás", true);
        itens[1] = new ItemVerdadeiroFalso("OO surgiu com a linguagem Java", false);
        itens[2] = new ItemVerdadeiroFalso("Eclipse é um editor de texto multilinguagem", true);

        questoes[1] = new VerdadeiroFalso(itens);

    }

    public void print() {
        int num = 1;
        for (Questao q : questoes) {
            System.out.print(num + ") ");
            System.out.println(q.getEnunciado() + "\n");
            num++;
        }

    }
}

class Questao {
    private String enunciado;

    Questao() {}

    public Questao(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getEnunciado() {
        return this.enunciado;
    }
}

class Discursiva extends Questao {
    private String gabarito;

    public Discursiva(String enunciado, String gabarito) {
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

class ItemVerdadeiroFalso {
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

class VerdadeiroFalso extends Questao {

    private ItemVerdadeiroFalso[] itens;
    private String enunciado;

    public VerdadeiroFalso(ItemVerdadeiroFalso[] itens) {
        this.itens = itens;
        this.enunciado = "Assinale verdadeiro ou falso para os itens: \n";

        for (ItemVerdadeiroFalso i : itens) {
            this.enunciado = this.enunciado.concat("( ) " + i.getEnunciado() + "\n");
        }

    }

    public String toString() {
        return this.enunciado;
    }

    public String getEnunciado() {
        return this.enunciado;
    }
}

public class AD1_2017_2 {
    public static void main(String[] args) {

        Prova prova = new Prova(2);

        prova.print();

    }
}

