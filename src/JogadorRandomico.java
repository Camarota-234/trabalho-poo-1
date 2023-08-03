public class JogadorRandomico extends JogadorAbstrato {
    private Baralho monte;
    private String nome;

    public JogadorRandomico(String nome) {
        super(nome);
    }

    public void setMonte(Baralho monte) {
        this.monte = monte;
    }

    public Baralho getMonte() {
        return this.monte;
    }

}
