package modelo.jogo.partida.estados;

import modelo.jogo.partida.estados.EstadoDaPartida;
import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.jogo.partida.Partida;
import modelo.util.Mensagem;

public class FimDoJogo implements EstadoDaPartida{


	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
		
	}

	@Override
	public void iniciar(Partida p) {
		

	}

	@Override
	public void fimDoJogo(Partida p) {		
		p.notificarObservadores(new Mensagem("fim_do_jogo", null));
                p.sinalizarFimDeJogo();
	}

	@Override
	public void verificandoVencedorDoTurno(Partida p) {


	}

	@Override
	public void verificandoReconhecimento(Partida p, Jogador jgd) {
		// TODO Auto-generated method stub
		
	}




}
