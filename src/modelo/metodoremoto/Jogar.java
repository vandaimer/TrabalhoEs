package modelo.metodoremoto;

import java.util.List;

import modelo.jogo.Carta;
import modelo.jogo.CartaAbstrata;
import modelo.metodoremoto.MetodoRemotoReceptor;
import modelo.jogo.servidor.ReceptorDoControleRemoto;


public class Jogar implements MetodoRemotoReceptor {
    
    private List<CartaAbstrata> cartas;

    public Jogar(List<CartaAbstrata> cartas) {
        this.cartas = cartas;
    }
    
    
    @Override
    public void aceitar(ReceptorDoControleRemoto p) {
        p.jogar(cartas);
    }
    
}
