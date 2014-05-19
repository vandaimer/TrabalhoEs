package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Baralho {

    private List<Carta> lista;

    public Baralho() {
        lista = new ArrayList<>();
    }

    public void adicionar(Carta c) {
        lista.add(new Carta(c));
    }

    public ErroDeValidacao validar() {
       
        return ErroDeValidacao.NAO_HOUVE_ERRO;
    
    }

    //seria esse o método pra obter as cartas?
    public List<Carta> listarCartas() {
        List<Carta> cartas = new ArrayList<>();

        for (Carta c : lista) {
       
            cartas.add(new Carta(c));

        }
        /*Deve retornar uma copia da lista do baralho*/
        return cartas;
    }

    public void remover(Carta c) {
        lista.remove(c);
    }

    public void montarBaralho(List<Carta> c) {
        for (Carta i : c) {
            
            lista.add(new Carta(i));
        }
    }
}
