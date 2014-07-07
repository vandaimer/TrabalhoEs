package modelo;

public class IniciandoTurno implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
		

	}

	@Override
	public void iniciar(Partida p) {		

		p.notificarObservadores(new Mensagem("iniciar_turno", null));
		p.limparJogadas();
		p.incrementarTurno();
		p.fixarEstado(new AguardandoJogada());
		
	}

	@Override
	public void fimDoJogo(Partida p) {


	}

	@Override
	public void verificandoVencedorDoTurno(Partida p) {


	}

	@Override
	public void verificandoReconhecimento(Partida p, Jogador jgd) {
		// TODO Auto-generated method stub

	}



}
