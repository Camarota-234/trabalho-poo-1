public abstract class JogadorAbstrato {
    private String nome;
    private Baralho monte;

    public JogadorAbstrato(String nome) {
        this.nome = nome;
    }

    public Baralho getMonte() {
        return this.monte;
    }

    public void setMonte(Baralho monte) {
        this.monte = monte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
