package modelo;

public class AguardandoIniciar implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
		p.notificarObservadores(this);
		
	}

	@Override
	public void iniciar(Partida p) {
		if(p.quantidadeJogadoresValida()){
			p.notificarObservadores(new Mensagem("iniciar", null));
			p.fixarEstado(new AguardandoJogada());
			p.incrementarTurno();
		}
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
		return false;
	}

}
