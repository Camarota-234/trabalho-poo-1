import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Baralho extends LinkedList<Carta> {

    private ArrayList<Carta> cartas;
    private int tema;

    public Baralho(int tema) {
        this.setTema(tema);
    }

    public void Adicionar(Carta carta) {
        cartas.add(carta);
    }

    public void Excluir(Carta carta) {
        cartas.remove(carta);
    }

    public void gerarBaralho() {

        InputStream fluxo = null;
        InputStreamReader leitor = null;
        BufferedReader leitorComBuffer = null;

        try {
            fluxo = new FileInputStream("cartas.csv");
            leitor = new InputStreamReader(fluxo);
            leitorComBuffer = new BufferedReader(leitor);

            String linha = leitorComBuffer.readLine();

            linha = leitorComBuffer.readLine();
            while (linha != null) {

                String[] dados = linha.split(",");
                this.add(new Carta(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]));
                linha = leitorComBuffer.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                leitorComBuffer.close();
                leitor.close();
                fluxo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void embaralhar() {
        Collections.shuffle(this);
    }

    public void distribuir(JogadorAbstrato[] jogadores) {
        int jogador = 0;
        Iterator<Carta> iterador = this.iterator();

        while (iterador.hasNext()) {

            if (jogadores[jogador].getMonte() == null)
                jogadores[jogador].setMonte(new Baralho(this.tema));

            jogadores[jogador].getMonte().add(iterador.next());
            iterador.remove();

            jogador = (jogador + 1) % jogadores.length;
        }
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

}
