import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws Exception {
        int tema;
        do {
            System.out.println("Bem vindo ao jogo Super Trunfo!");
            System.out.println("================================");
            System.out.println("Escolha o tema:\n (1) Personalidades históricas \n (2) Motos \n (3) Dinossauros");
            System.out.println("Ou digite (4) para sair");
            System.out.println("");

            Scanner scanner = new Scanner(System.in);
            tema = scanner.nextInt();
            Jogo jogo = new Jogo(tema);
            tema = 4;
        } while (tema != 4);
        System.out.println("\n[ PROGRAMA ENCERRADO ]");
        System.exit(0);
    }
}
