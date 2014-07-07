package modelo;

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




}
