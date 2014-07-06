package modelo;

import java.io.Serializable;

public interface EstadoDaPartida extends Serializable{

    public void jogar(Partida p, Jogador jgd, Jogada j);
    public void iniciar(Partida p);
    public void fimDoJogo(Partida p);
    public void verificandoVencedorDoTurno(Partida p);
    public boolean fimDoJogo();
    
   

}
