import java.util.List;

public class Carta {
    private static List<String> atributo;
    private static List<String> unidade;
    private String nome;
    private String codigo;
    private String dado1;
    private String dado2;
    private String dado3;
    private String dado4;
    private String curiosidade;
    private String superTrunfo;

    public Carta(String codigo, String nome, String dado1, String dado2, String dado3, String dado4, String curiosidade,
            String superTrunfo) {

        this.nome = nome;
        this.codigo = codigo;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.dado3 = dado3;
        this.dado4 = dado4;
        this.curiosidade = curiosidade;
        this.superTrunfo = superTrunfo;
    }

    public String toString() {
        return "Código: " + codigo + " Nome: " + nome + " Atributo 1: " + getAtributo();
    }

    public static List<String> getAtributo() {
        return atributo;
    }

    public static void setAtributo(List<String> atributos) {
        Carta.atributo = atributos;
    }

    public static List<String> getUnidade() {
        return unidade;
    }

    public static void setUnidade(List<String> unidade) {
        Carta.unidade = unidade;
    }

}
