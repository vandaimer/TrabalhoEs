package modelo.jogo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Baralho implements Serializable{

    private List<CartaAbstrata> lista = new LinkedList<>();

    public Baralho() {
    }

    public Baralho(Baralho b) {
        lista = b.listarCartas();
    }

    public void adicionar(CartaAbstrata c) {
        lista.add(c.clonar());

    }

    public void remover(CartaAbstrata c) {
        lista.remove(c);

    }

    public void validar(EstrategiaDeValidacaoDoBaralho e) throws ExcecaoQuebraDeRegrasDoBaralho{
        e.validar(this);
    }

    // seria esse o método pra obter as cartas?
    public List<CartaAbstrata> listarCartas() {
        List<CartaAbstrata> cartas = new LinkedList<>();

        for (CartaAbstrata c : lista) {

            cartas.add(c.clonar());

        }
        /* Deve retornar uma copia da lista do baralho */
        return cartas;
    }

    public void montarBaralho(List<CartaAbstrata> c) {
        for (CartaAbstrata i : c) {

            lista.add(i.clonar());

        }
    }

}
