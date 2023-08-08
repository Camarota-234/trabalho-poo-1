import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

public class Jogo {
    private int tema;
    private int totalJogadores;
    private static JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
    private static int jogadorDaVez;
    private static int vencedorDaVez;

    public Jogo(int tema) {

        this.tema = tema;

        Scanner scanner = new Scanner(System.in);

        // Switch para mostrar tema que foi carregado ou encerrar programa (MELHORAR
        // CÓDIGO)
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

        // Criando baralho, carregando todas as cartas e embaralhando
        Baralho superTrunfo = new Baralho(tema);
        superTrunfo.Carregar();
        superTrunfo.embaralhar();

        System.out.println("================================");
        System.out.println("Baralho criado e embaralhado");

        // System.out.println("Qual a dificuldade desejada? (Digite um número de 1 a
        // 3)");

        // Criando dois jogadores e os colocando em um vetor de jogadores abstratos
        // (CRIAR OPÇÃO DE MAIS JOGADORES?)
        jogadores[0] = new JogadorReal("João Guilherme");
        jogadores[1] = new JogadorRandomico("Máquina");
        JogadorAbstrato jogador1 = jogadores[0];
        JogadorAbstrato jogador2 = jogadores[1];

        // Distribuindo cartas entre jogadores abstratos
        superTrunfo.distribuir(new JogadorAbstrato[] { jogador1, jogador2 });

        // Exibe início de partida e lista cartas de cada jogador uma vez
        System.out.println("================================");
        System.out.println("PARTIDA INICIADA");
        System.out.println("================================ \n");
        jogador1.getMonte().listarCartas();
        jogador2.getMonte().listarCartas();

        // Função com jogo em loop
        jogar(jogador1, jogador2);

        mostrarVencedor();

    }

    public void jogar(JogadorAbstrato jogador1, JogadorAbstrato jogador2) {
        int rodada = 0;
        int atributoEscolhido;
        int vencedorDaVez = 0;
        // While para repetir jogo até que vencedor seja detectado com 32 cartas

        while (!existeVencedor()) {

            rodada++;

            // Função que mostra a rodada, quantas cartas o jogador real tem e qual a
            // próxima carta
            // Será mostrada em todas as rodadas
            mostrarStatus(jogador1, rodada);

            // Se for vez do jogador real, dá a opção de escolher atributo, se for vez da
            // máquina,
            // atributo da rodada será escolhido aleatóriamente
            if (jogadorDaVez == 0) {
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
                System.out.println("Atributo escolhido: " + Carta.getAtributos().get(atributoEscolhido));
            }

            //Comparação das cartas em função de atributo escolhido
            //Vencedor da vez escolherá os atributos na próxima rodada
            vencedorDaVez = comparaCartas(atributoEscolhido);

            //Mostra cartas usadas na rodada
            mostraAmbasCartas(jogador1, jogador2);

            //Mostra vencedor da rodada
            if (vencedorDaVez == 0) {
                System.out.println("================================");
                System.out.println("VITÓRIA DO JOGADOR");
                System.out.println("================================ \n");
            } else {
                System.out.println("================================");
                System.out.println("VITÓRIA DA MÁQUINA");
                System.out.println("================================ \n");
            }

            //Vencedor da última rodada ganha a carta jogada pelo jogador oponente
            roubaCarta(vencedorDaVez);

            //transforma vencedor no proximo jogador
            jogadorDaVez = vencedorDaVez;
        }
    }

    // Função que mostra a rodada, quantas cartas o jogador real tem e qual a
    // próxima carta
    public void mostrarStatus(JogadorAbstrato jogador, int rodada) {
        System.out.println("================================");
        System.out.println("RODADA " + rodada);
        System.out.println("================================ ");
        System.out.println("VOCÊ POSSUI " + jogador.getMonte().contagemCartas() + " CARTAS");
        System.out.println("================================ ");
        System.out.println("SUA PRÓXIMA CARTA É: ");
        System.out.println(jogador.getMonte().pegarTopo().toString());
        System.out.println("================================ ");
    }

    // Escaneia número de atributo e retorna "atributoEscolhido", com número
    // referente ao atributo para a rodada
    public int escolherAtributo() {
        int atributoEscolhido;
        String texto = " ";
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            texto = texto + "[" + (i + 1) + "] " + Carta.getAtributos().get(i) + "\n";
        }
        System.out.println(texto + "\n");
        atributoEscolhido = scanner.nextInt();
        return atributoEscolhido;
    }

    // Gera número aleatório e retorna como "atributoEscolhido"
    public int maquinaEscolheAtributo() {
        Random gerador = new Random();
        int atributoEscolhido = gerador.nextInt(4);
        return atributoEscolhido;
    }

    //Compara a carta do topo de cada jogador e retorna o número do jogador ganhador, que já será
    //Usado para determinar quem joga a próxima rodada
    public static int comparaCartas(int atributo) {
        double maior = 0;
        int jogador = 0;
        for (int i = 0; i < jogadores.length; i++) {
            double valor = Double.valueOf(jogadores[i].getMonte().pegarTopo().dadoEscolhido(atributo)).doubleValue();
            if (i == 0)
                maior = valor;
            else {
                if (valor > maior) {
                    maior = valor;
                    jogador = i;
                } else if (valor == maior) {
                    vencedorDaVez = jogador;
                    break;
                }
            }
        }
        vencedorDaVez = jogador;
        return vencedorDaVez;
    }

    //Imprime dados das cartas de todos os jogadores
    public void mostraAmbasCartas(JogadorAbstrato jogador1, JogadorAbstrato jogador2) {
        System.out.println("Carta do jogador: ");
        System.out.println(jogador1.getMonte().pegarTopo().toString());
        System.out.println("Carta da máquina: ");
        System.out.println(jogador2.getMonte().pegarTopo().toString());
    }

    //Recebe uma cópia da carta do topo do monste do jogador oposto e retira original do jogo
    public void roubaCarta(int vencedorDaVez) {
        if (vencedorDaVez == 0) {
            jogadores[0].getMonte().addLast(jogadores[1].getMonte().pegarTopo());
            jogadores[1].getMonte().removeFirst();
        } else {
            jogadores[1].getMonte().addLast(jogadores[0].getMonte().pegarTopo());
            jogadores[0].getMonte().removeFirst();
        }
    }

    //Quando um jogador completa 32 cartas em seu baralho, imprime vencedor e retorna falso
    //para sair do loop do jogo
    public static boolean existeVencedor() {

        for (int i = 0; i < jogadores.length; i++) {
            if (jogadores[i].getMonte().size() == 32) {
                System.out.println("O JOGADOR " + i + " GANHOU");
            }
        }
        return false;
    }

    public void mostrarVencedor() {
        System.out.println("Mostrar Vencedor");
    }


    public static JogadorAbstrato[] getJogadores() {
        return Jogo.jogadores;
    }

    public static void setJogadores(JogadorAbstrato[] jogadores) {
        Jogo.jogadores = jogadores;
    }





}
