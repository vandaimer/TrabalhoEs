package modelo.metodoremoto;

import modelo.metodoremoto.MetodoRemotoPartida;
import modelo.jogo.Jogador;
import modelo.jogo.partida.Partida;

public class SinalizarReconhecimento implements MetodoRemotoPartida {
    
    private Jogador _j;
    
    public SinalizarReconhecimento(Jogador j) {
        _j = j;
    }
    
    @Override
    public void aceitar(Partida p) {
        p.sinalizarReconhecimento(_j);
        
    }
    
}
