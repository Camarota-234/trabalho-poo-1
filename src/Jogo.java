import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Jogo {
    private int tema;
    private int totalJogadores;
    private static JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
    private static int jogadorDaVez;

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
        // jogador2.getMonte().listarCartas();

        jogar(jogador1, jogador2);
        totalJogadores = Jogo.getJogadores().length;

        mostrarVencedor();

    }

    public void jogar(JogadorAbstrato jogador1, JogadorAbstrato jogador2) {
        int rodada = 0;
        int vez = 0;
        int atributoEscolhido;
        while (!existeVencedor()) {

            mostrarStatus(jogador1);

            if (jogadorDaVez() == 0) {
                System.out.println("================================");
                System.out.println("SUA VEZ DE JOGAR");
                System.out.println("================================ \n");
                System.out.println("Escolha um atributo: ");
                atributoEscolhido = escolherAtributo();

            } else {
                System.out.println("================================");
                System.out.println("VEZ DA MÁQUINA");
                System.out.println("================================ \n");
                atributoEscolhido = maquinaEscolheAtributo();

            }
            comparaCartas(atributoEscolhido);
        }

    }

    public int escolherAtributo() {
        int atributoEscolhido;
		String texto = " ";
        Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			texto = texto + "[" + (i+1) + "] " + Carta.getAtributos().get(i) + "\n";
		}
		System.out.println(texto);
		atributoEscolhido = scanner.nextInt();
        scanner.close();
        return atributoEscolhido + 1;
	}

    public int maquinaEscolheAtributo() {

        Random gerador = new Random();
        int atributoEscolhido = gerador.nextInt(4);
        return atributoEscolhido;
    }

    public static int comparaCartas(int atributo) {
		double maior = 0;
		int jogador = 0;
		for (int i = 0; i <jogadores.length; i++) {
			double valor = Double.valueOf(Carta.getValor().get(i)).doubleValue();
			if (i == 0)
				maior = valor;
			else {
				if (valor > maior) {
					maior = valor;
					jogador = i;
				}
				else if(valor == maior) {
					jogadorDaVez = jogador;
					break;
				}
			}
		}
		jogadorDaVez = jogador;
		return jogador;
	}

    public static int jogadorDaVez() {

        return 1;

    }

    public void mostrarStatus(JogadorAbstrato jogador) {
        int rodada = 1;
        System.out.println("================================");
        System.out.println("RODADA " + rodada);
        System.out.println("================================ ");
        System.out.println("VOCÊ POSSUI " + jogador.getMonte().contagemCartas() + " CARTAS");
        System.out.println("================================ ");
        System.out.println("SUA PRÓXIMA CARTA É: ");
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

    public static JogadorAbstrato[] getJogadores() {
        return Jogo.jogadores;
    }

    public static void setJogadores(JogadorAbstrato[] jogadores) {
        Jogo.jogadores = jogadores;
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

    public void mostrarVencedor() {
        System.out.println("Mostrar Vencedor");
    }

}
