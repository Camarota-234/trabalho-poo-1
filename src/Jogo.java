import java.util.Scanner;
import java.util.ArrayList;

public class Jogo {
    private int tema;

    public Jogo(int tema) {
        this.tema = tema;
        Scanner scanner = new Scanner(System.in);

        switch (tema) {
            case 1: System.out.println("Baralho carregado com tema Personalidades histórias"); break;
            case 2: System.out.println("Baralho carregado com tema Motos"); break;
            case 3: System.out.println("Baralho carregado com tema Dinossauros"); break;
            case 4: System.out.println("OK"); break;
            default: System.out.println("Esta não é uma opção válida");
            System.out.println("\n[ PROGRAMA ENCERRADO ]");
            System.exit(0); break;
        }

        Baralho superTrunfo = new Baralho(tema);
        superTrunfo.gerarBaralho();
        superTrunfo.embaralhar();

        System.out.println("================================");
        System.out.println("Baralho criado e embaralhado");
        //System.out.println("Qual a dificuldade desejada? (Digite um número de 1 a 3)");
        JogadorReal jogador1 = new JogadorReal("João");
        JogadorRandomico jogador2 = new JogadorRandomico("Maria");

        superTrunfo.distribuir(new JogadorAbstrato[]{jogador1, jogador2});





















    }
}
