import java.util.ArrayList;

class Prova {

    private ArrayList<Questao> questoes;
    private int quantidadeQuestoes;

    public Prova(int quantidadeQuestoes){
    	this.quantidadeQuestoes = quantidadeQuestoes;
    	this.questoes = new ArrayList<Questao>();

        //UTILIZEI O PADRÃO BUIDER PARA DINAMIZAR A CRIAÇÃO DAS QUESTÕES SEM PRECISAR ITERAÇAO.
        Discursiva discursiva = new Discursiva.DiscursivaBuilder("Qual é o número da última versão de Java?", "8").build();

        VerdadeiroFalso verdadeiroFalso = new VerdadeiroFalso.VerdadeiroFalsoBuilder()
                .item(new ItemVerdadeiroFalso("Java foi lançada há mais de 20 anos atrás", true))
                .item(new ItemVerdadeiroFalso("OO surgiu com a linguagem Java", false))
                .item(new ItemVerdadeiroFalso("Eclipse é um editor de texto multilinguagem", true))
                .build();

        this.questoes.add(discursiva);
        this.questoes.add(verdadeiroFalso);
    }

    public void print() {

    	if(this.quantidadeQuestoes != this.questoes.size()){
    		System.out.println("ERRO: A quantidade de questões enviadas deve ser igual quantidade informada!");
    		return;
    	}
    	
        int num = 1;
        for (Questao q : questoes) {
            System.out.print(num + ") ");
            System.out.println(q.getEnunciado() + "\n");
            num++;
        }
    }
    
    public int getQuantidadeQuestoes() {
    	return this.quantidadeQuestoes;
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

    private Discursiva(DiscursivaBuilder builder) {
        super(builder.enunciado);
        this.gabarito = builder.gabarito;
    }
    
    public static class DiscursivaBuilder {
    	private String enunciado;
    	private String gabarito;
    	
    	public DiscursivaBuilder(String enunciado, String gabarito){
    		this.enunciado = enunciado;
    		this.gabarito = gabarito;
    	}
    	
        public Discursiva build() {
        	return new Discursiva(this);
        }
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
        return this.enunciado;
    }
}

class VerdadeiroFalso extends Questao {

    private ArrayList<ItemVerdadeiroFalso> itens;
    private String enunciado;

    private VerdadeiroFalso(VerdadeiroFalsoBuilder builder) {
    	this.itens = builder.itens;
    	this.enunciado = builder.enunciado;
    }
    
    public static class VerdadeiroFalsoBuilder {
    	private ArrayList<ItemVerdadeiroFalso> itens;
    	private String enunciado;
    	
    	public VerdadeiroFalsoBuilder() {
    		itens = new ArrayList<ItemVerdadeiroFalso>();
    		this.enunciado = "Assinale verdadeiro ou falso para os itens: \n";
    	}
    	
    	public VerdadeiroFalsoBuilder item(ItemVerdadeiroFalso item) {
    		this.itens.add(item);
    		
    		return this;
    	}
    	
    	public VerdadeiroFalso build() {		
    		for (ItemVerdadeiroFalso i : this.itens) {
    			this.enunciado = enunciado.concat("( ) " + i.getEnunciado() + "\n");
    		}
    		
    		return new VerdadeiroFalso(this);
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

