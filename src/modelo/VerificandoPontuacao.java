package modelo;

public class VerificandoPontuacao implements EstadoDaPartida{

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
		//atualizar o score através da comparação de cartas
		
		if(p.fimDeJogo()){
			//enviar o score atual como mensagem no notificar
			p.notificarObservadores(new Mensagem("Fim do jogo", null));
			p.fixarEstado(new FimDoJogo());
		}else{
			p.notificarObservadores(new Mensagem("pontuacao", null));
			p.fixarEstado(new AguardandoIniciar());
		}		
	}

	@Override
	public boolean fimDoJogo() {
		// TODO Auto-generated method stub
		return false;
	}

}
