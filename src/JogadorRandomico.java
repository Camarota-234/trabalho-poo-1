public class JogadorRandomico extends JogadorAbstrato {
    private Baralho monte;

    public JogadorRandomico(String nome) {
        super(nome);
    }

    public Baralho getMonte() {
        return this.monte;
    }

    public void setMonte(Baralho monte) {
        this.monte = monte;
    }

}
