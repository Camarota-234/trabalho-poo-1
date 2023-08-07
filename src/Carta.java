import java.util.List;

public class Carta {
    private static List<String> atributos;
    private static List<String> valor;
    private static List<String> unidade;
    private String nome;
    private String codigo;
    private String dado1;
    private String dado2;
    private String dado3;
    private String dado4;
    private String curiosidade;
    private String curiosidade2;

    public Carta(String codigo, String nome, String curiosidade1, String curiosidade2, String dado1, String dado2, String dado3, String dado4) {

        this.nome = nome;
        this.codigo = codigo;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.dado3 = dado3;
        this.dado4 = dado4;
        this.curiosidade = curiosidade1;
        this.curiosidade2 = curiosidade2;
    }

    public String toString() {
        String textoNome = " ";
        String textoDados = " ";
        String textoFinal;
        String[] dados1 = {dado1, dado2, dado3, dado4};

        for (int i = 0; i < atributos.size(); i++) {
            textoDados = textoDados + "\n" + atributos.get(i) + ": " + dados1[i] + " " + unidade.get(i);
        }

        textoNome = textoNome + "Nome: " + this.nome + "\nCódigo: " + this.codigo;
        textoFinal = textoNome + textoDados;
        return textoFinal;
    }

    public static List<String> getAtributos() {
        return atributos;
    }

    public static void setAtributo(List<String> atributos) {
        Carta.atributos = atributos;
    }

    public static List<String> getUnidade() {
        return unidade;
    }

    public static void setUnidade(List<String> unidade) {
        Carta.unidade = unidade;
    }

    public static List<String> getValor() {
        return valor;
    }

    public static void setValor(List<String> valor) {
        Carta.valor = valor;
    }

}
