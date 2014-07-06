package modelo;

public class AguardandoJogada implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
		//vou fazer algum coisa
		
		try{
			j.baralhoValido(new ValidacaoMao());
			p.adicionarJogada(jgd, j);
			p.notificarObservadores(new Mensagem("Jogada realizada", jgd));
			if(p.associacaoCompleta()){
				p.fixarEstado(new VerificandoPontuacao());
			}
			
		}catch(ExcecaoQuebraDeRegrasDoBaralho e){
			p.notificarObservadores(new Mensagem("Excecao", e));
		}
		
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
