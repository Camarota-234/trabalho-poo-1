public class JogadorReal extends JogadorAbstrato {
    private Baralho monte;
    private String nome;

    public JogadorReal(String nome) {
        super(nome);
    }

    public void setMonte(Baralho monte) {
        this.monte = monte;
    }

    public Baralho getMonte() {
        return this.monte;
    }

    public boolean vencedorPartida() {
        return false;
    }

    public String toString() {
        return "JOGADOR: " + nome ;
    }
}
