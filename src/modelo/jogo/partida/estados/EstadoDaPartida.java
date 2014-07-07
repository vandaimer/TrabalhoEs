package modelo.jogo.partida.estados;


import java.io.Serializable;
import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.jogo.partida.Partida;


public interface EstadoDaPartida extends Serializable{
	
	
	
    public void jogar(Partida p, Jogador jgd, Jogada j);
    public void iniciar(Partida p);
    public void fimDoJogo(Partida p);
    public void verificandoVencedorDoTurno(Partida p);
    public void verificandoReconhecimento(Partida p, Jogador jgd);
    
   

}
