package modelo;

public class FimDoJogo implements EstadoDaPartida{


	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
		p.notificarObservadores(this);
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
		// TODO Auto-generated method stub
		return true;
	}


}
