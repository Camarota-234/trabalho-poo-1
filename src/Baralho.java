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
import java.util.List;

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

    public void Carregar(int tema) {

        InputStream fluxo = null;
        InputStreamReader leitor = null;
        BufferedReader leitorComBuffer = null;

        try {
            switch (tema) {
                case 1:
                    fluxo = new FileInputStream("deuses.csv");
                    break;
                case 2:
                    fluxo = new FileInputStream("carros.csv");
                    break;
                case 3:
                    fluxo = new FileInputStream("dinos.csv");
                    break;
                case 4:
                    fluxo = new FileInputStream("jogadores.csv");
            }

            leitor = new InputStreamReader(fluxo);
            leitorComBuffer = new BufferedReader(leitor);

            String linha = leitorComBuffer.readLine();

            List<String> atributos = new ArrayList();
            List<String> unidade = new ArrayList();

            String[] nomeAtributos = linha.split(",");
            for (String i : nomeAtributos) {
                atributos.add(i);
            }
            Carta.setAtributos(atributos);

            linha = leitorComBuffer.readLine();
            String[] unidadeAtributos = linha.split(",");
            for (String i : unidadeAtributos) {
                unidade.add(i);
            }
            Carta.setUnidade(unidade);

            linha = leitorComBuffer.readLine();

            while (linha != null) {

                String[] dados = linha.split(",");

                Carta carta = new Carta(dados[0], dados[1], Double.parseDouble(dados[2]),
                        Double.parseDouble(dados[3]), Double.parseDouble(dados[4]), Double.parseDouble(dados[5]),
                        dados[6], dados[7]);

                Atributo valor = new Atributo();
                valor.setValor(atributos.subList(1, atributos.size()));
                carta.setValor(valor);
                this.add(carta);
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

    public Carta pegarTopo() {
        return this.getFirst();
    }

    public void listarCartas() {
        System.out.println(this);
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public int contagemCartas() {
        return this.size();
    }

}
