package modelo;

public class AguardandoIniciar implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
	
		
	}

	@Override
	public void iniciar(Partida p) {		
		if(p.quantidadeJogadoresValida()){
			p.notificarObservadores(new Mensagem("iniciar_turno", null));
			p.fixarEstado(new AguardandoJogada());
			p.incrementarTurno();
                        p.limparJogadas();
		}
	}

	@Override
	public void fimDoJogo(Partida p) {
	
		
	}

	@Override
	public void verificandoVencedorDoTurno(Partida p) {
	
		
	}



}
