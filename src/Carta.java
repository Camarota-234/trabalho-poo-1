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
    private String trunfo;
    private boolean ehTrunfo;

    public Carta(String codigo, String nome, String curiosidade1, String curiosidade2, Double dado1, Double dado2,
            Double dado3, Double dado4, String trunfo) {

        this.nome = nome;
        this.codigo = codigo;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.dado3 = dado3;
        this.dado4 = dado4;
        this.trunfo = trunfo;
    }

    public String toString() {
        String textoNome = "";
        String textoDados = "";
        String textoTrunfo = "";
        String textoFinal;
        Double[] dados1 = { dado1, dado2, dado3, dado4 };
        boolean ehtrunfo = trunfo.contains("true");

        //Cria texto com nome e código
        textoNome = textoNome + "Nome: " + this.nome + "\nCódigo: " + this.codigo;

        //Cria texto com atributos e valores
        for (int i = 0; i < atributos.size(); i++) {
            textoDados = textoDados + "\n" + atributos.get(i) + ": " + dados1[i] + " " + unidade.get(i);
        }

        //Cria texto se carta for super trunfo
        if (ehtrunfo == true) {
            setTrunfo(ehtrunfo);
            textoTrunfo = textoTrunfo +  "\n" + "SUPER TRUNFO\n";
        }

        textoFinal = textoNome + textoDados + textoTrunfo;

        return textoFinal + "\n";
    }

    public boolean ehGrupoA() {
        if (codigo.contains("A")) {
            return true;
        } else {
            return false;
        }
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean ehTrunfo() {
      return ehTrunfo;
    }

    public void setTrunfo(boolean ehTrunfo) {
      this.ehTrunfo = ehTrunfo;
    }

}
