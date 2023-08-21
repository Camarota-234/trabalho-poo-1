import java.util.Scanner;


// Trabalho feito pelos alunos:
//
// Igor Barbosa Lino.  Matrícula: 202201636
// João Dinízio Neto. Matrícula: 202201637
// João Guilherme Camarota. Matrícula: 202201638
// Nicholas Kenzo Costa. Matrícula: 202201659
// William Iabagata de Afini. Matrícula: 202201678

public class Principal {
    public static void main(String[] args) throws Exception {
        int tema;
        do {
            System.out.println("Bem vindo ao jogo Super Trunfo!");
            System.out.println("================================");
            System.out.println("Escolha o tema:\n (1) Deuses  \n (2) Carros \n (3) Dinossauros \n (4) Jogadores");
            System.out.println("Ou digite (5) para sair\n");

            Scanner scanner = new Scanner(System.in);
            tema = scanner.nextInt();
            Jogo jogo = new Jogo(tema);
            tema = 5;
        } while (tema != 5);
        System.out.println("\n[ PROGRAMA ENCERRADO ]");
        System.exit(0);
    }
}
