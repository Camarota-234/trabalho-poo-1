import java.util.List;

public class Carta {
    private static List<String> atributos;
    private Atributo valor;
    private static List<String> unidade;
    private String nome;
    private String codigo;
    private Double dado1;
    private Double dado2;
    private Double dado3;
    private Double dado4;
    private int dadoEscolhido;
    private String curiosidade2;
    private Double[] dados2 = {dado1, dado2, dado3, dado4};

    public Carta(String codigo, String nome, String curiosidade1, String curiosidade2, Double dado1, Double dado2, Double dado3, Double dado4) {

        this.nome = nome;
        this.codigo = codigo;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.dado3 = dado3;
        this.dado4 = dado4;
        this.curiosidade2 = curiosidade2;
    }

    public String toString() {
        String textoNome = "";
        String textoDados = "";
        String textoFinal;
        Double[] dados1 = {dado1, dado2, dado3, dado4};

        for (int i = 0; i < atributos.size(); i++) {
            textoDados = textoDados + "\n" + atributos.get(i) + ": " + dados1[i] + " " + unidade.get(i);
        }

        textoNome = textoNome + "Nome: " + this.nome + "\nCódigo: " + this.codigo;
        textoFinal = textoNome + textoDados;
        return textoFinal + "\n";
    }

    public static List<String> getAtributos() {
        return atributos;
    }

    public static void setAtributos(List<String> atributos) {
        Carta.atributos = atributos;
    }

    public static List<String> getUnidade() {
        return unidade;
    }

    public static void setUnidade(List<String> unidade) {
        Carta.unidade = unidade;
    }

    public Atributo getValor() {
		return valor;
	}
	public void setValor(Atributo valor) {
		this.valor = valor;
	}

    public double dadoEscolhido(int escolha) {

        if (escolha == 1) {
            return dado1;
        } else if (escolha == 2) {
            return dado2;
        } else if (escolha == 3) {
            return dado3;
        } else {
            return dado4;
        }

    }

}
