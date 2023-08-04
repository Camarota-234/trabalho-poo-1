public abstract class JogadorAbstrato {
    private String nome;
    private Baralho monte;

    public JogadorAbstrato(String nome) {
        this.nome = nome;
    }

    public void setMonte(Baralho monte) {
        this.monte = monte;
    }

    public Baralho getMonte() {
        return this.monte;
    }

    public abstract boolean vencedorPartida();

    public abstract String toString();

}
