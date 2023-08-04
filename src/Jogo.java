import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {
    private int tema;
    private static JogadorAbstrato[] jogadores;

    public Jogo(int tema) {
        this.tema = tema;
        jogadores[0] = new JogadorReal("João Guilherme");
        jogadores[1] = new JogadorRandomico("Máquina");

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
        JogadorReal jogador1 = new JogadorReal("João");
        JogadorRandomico jogador2 = new JogadorRandomico("Maria");

        superTrunfo.distribuir(new JogadorAbstrato[] { jogador1, jogador2 });

        System.out.println("================================");
        System.out.println("PARTIDA INICIADA");
        System.out.println("================================ \n");

        jogador1.getMonte().listarCartas();

        jogar();

    }

    public void mostrarStatus() {
        int rodada = 1;
        System.out.println("================================");
        System.out.println("RODADA " + rodada);
        System.out.println("================================ \n");
        System.out.println("VOCÊ AINDA TEM " + rodada);
        System.out.println("================================ \n");
        rodada++;
    }

    public void mostrarJogadorDaVez() {

        System.out.println("================================");
        System.out.println("TURNO DO ");
        System.out.println("================================ \n");
    }

    public void jogar() {

        while (ganhou() == false) {

            mostrarStatus();
            mostrarJogadorDaVez();

        }

    }

    public static boolean ganhou() {

        boolean vencedor = false;

        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i].getMonte().size() == 32) {
                System.out.println("O JOGADOR " + i + " GANHOU O JOGO!");
                vencedor = true;
            }
        }
        return vencedor;
    }
}
