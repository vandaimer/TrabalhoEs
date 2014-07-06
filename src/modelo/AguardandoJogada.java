package modelo;

public class AguardandoJogada implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
		
		
	}

	@Override
	public void iniciar(Partida p) {
		p.notificarObservadores(this);
		
	}

	@Override
	public void fimDoJogo(Partida p) {
		p.notificarObservadores(this);
		
	}

	@Override
	public void verificandoVencedorDoTurno(Partida p) {
		p.notificarObservadores(this);
		
	}

	@Override
	public boolean fimDoJogo() {		
		return false;
	}

}
