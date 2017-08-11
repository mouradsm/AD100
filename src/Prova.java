
public class Prova {
    private Questao[] questoes;

    Prova(int quantidadeQuestoes) {

        this.questoes = new Questao[quantidadeQuestoes];

        questoes[0] = new Discursiva("Qual é o número da última versão de Java?", "8");

        ItemVerdadeiroFalso[] itens = new ItemVerdadeiroFalso[3];

        itens[0] = new ItemVerdadeiroFalso("Java foi lançada há mais de 20 anos atrás", true);
        itens[1] = new ItemVerdadeiroFalso("OO surgiu com a linguagem Java", false);
        itens[2] = new ItemVerdadeiroFalso("Eclipse é um editor de texto multilinguagem", true);

        questoes[1] = new VerdadeiroFalso(itens);

    }

    public String toString() {
        String p = "";
        for (Questao q : questoes) {
            p += q.getEnunciado() + "\n\n";
        }

        return p;
    }

    public void addQuestao() {

    }
}
