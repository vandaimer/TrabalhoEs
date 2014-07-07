package modelo.jogo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Baralho implements Serializable{

    private List<Carta> lista = new LinkedList<>();

    public Baralho() {
    }

    public Baralho(Baralho b) {
        lista = b.listarCartas();
    }

    public void adicionar(Carta c) {
        lista.add(new Carta(c));

    }

    public void remover(Carta c) {
        lista.remove(c);

    }

    public void validar(EstrategiaDeValidacaoDoBaralho e) throws ExcecaoQuebraDeRegrasDoBaralho{
        e.validar(this);
    }

    // seria esse o método pra obter as cartas?
    public List<Carta> listarCartas() {
        List<Carta> cartas = new LinkedList<>();

        for (Carta c : lista) {

            cartas.add(new Carta(c));

        }
        /* Deve retornar uma copia da lista do baralho */
        return cartas;
    }

    public void montarBaralho(List<Carta> c) {
        for (Carta i : c) {

            lista.add(new Carta(i));

        }
    }

}
