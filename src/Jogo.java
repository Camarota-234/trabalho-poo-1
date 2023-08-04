import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {
    private int tema;
    private static JogadorAbstrato[] jogadores = new JogadorAbstrato[2];

    public Jogo(int tema) {

        this.tema = tema;

        Scanner scanner = new Scanner(System.in);

        switch (tema) {
            case 1:
                System.out.println("Baralho carregado com tema Personalidades histórias");
                break;
            case 2:
                System.out.println("Baralho carregado com tema Motos");
                break;
            case 3:
                System.out.println("Baralho carregado com tema Dinossauros");
                break;
            case 4:
                System.out.println("OK");
                break;
            default:
                System.out.println("Esta não é uma opção válida");
                System.out.println("\n[ PROGRAMA ENCERRADO ]");
                System.exit(0);
                break;
        }

        Baralho superTrunfo = new Baralho(tema);
        superTrunfo.Carregar();
        superTrunfo.embaralhar();

        System.out.println("================================");
        System.out.println("Baralho criado e embaralhado");
        // System.out.println("Qual a dificuldade desejada? (Digite um número de 1 a
        // 3)");
        jogadores[0] = new JogadorReal("João Guilherme");
        jogadores[1] = new JogadorRandomico("Máquina");

        JogadorAbstrato jogador1 = jogadores[0];
        JogadorAbstrato jogador2 = jogadores[1];

        superTrunfo.distribuir(new JogadorAbstrato[] { jogador1, jogador2 });

        System.out.println("================================");
        System.out.println("PARTIDA INICIADA");
        System.out.println("================================ \n");

        // jogador1.getMonte().listarCartas();

        jogar(jogador1, jogador2);

        // mostrarVencedor();

    }

    public void jogar(JogadorAbstrato jogador1, JogadorAbstrato jogador2) {

        while (!existeVencedor()) {

            mostrarStatus(jogador1);
            mostrarJogadorDaVez();
        }

    }

    public void mostrarStatus(JogadorAbstrato jogador) {
        int rodada = 1;
        System.out.println("================================");
        System.out.println("RODADA " + rodada);
        System.out.println("================================ ");
        System.out.println("VOCÊ POSSUI " + jogador.getMonte().contagemCartas() + " CARTAS");
        System.out.println("================================ ");
        System.out.println("SUA PRÓXIMA CARTA É: " );
        System.out.println(jogador.getMonte().pegarTopo().toString());
        System.out.println("================================ ");
        rodada++;
    }

    public void mostrarJogadorDaVez() {
        String jogadorDaVez = "a";
        System.out.println("================================");
        System.out.println("TURNO DO JOGADOR: " + jogadorDaVez);
        System.out.println("================================ \n");
    }

    public static boolean existeVencedor() {

        boolean vencedor = false;
        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i].getMonte().size() == 32) {
                System.out.println("O JOGADOR " + i + " GANHOU");
                vencedor = true;
            }
        }

        return vencedor;
    }


}
