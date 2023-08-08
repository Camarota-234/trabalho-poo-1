public class JogadorReal extends JogadorAbstrato {
    private Baralho monte;
    private String nome;

    public JogadorReal(String nome) {
        super(nome);
    }

    public Baralho getMonte() {
        return this.monte;
    }

    public void setMonte(Baralho monte) {
        this.monte = monte;
    }

}
