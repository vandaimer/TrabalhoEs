package modelo;

import java.util.List;

public class Partida {
    
    private EstadoDaPartida _estado;
    
    
    public Partida() {
        _estado = null;//insere estado inicial

    }
    
    void fixarEstado(EstadoDaPartida e) {
        _estado = e;
    }
    
    public synchronized void jogar(Jogador jgd, Jogada j) {
        _estado.jogar(this, jgd, j);
    }
    
    public synchronized void comprar(Jogador jgd, Baralho b) {
        _estado.comprar(this, jgd, b);
    }
    
}
