package modelo.metodoremoto;

import java.util.List;
import modelo.jogo.Carta;
import modelo.metodoremoto.MetodoRemotoReceptor;
import modelo.jogo.servidor.ReceptorDoControleRemoto;


public class Jogar implements MetodoRemotoReceptor {
    
    private List<Carta> cartas;

    public Jogar(List<Carta> cartas) {
        this.cartas = cartas;
    }
    
    
    @Override
    public void aceitar(ReceptorDoControleRemoto p) {
        p.jogar(cartas);
    }
    
}
