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

        Baralho mesa = new Baralho();
        mesa.gerarBaralho();
        mesa.embaralhar();















    }
}
