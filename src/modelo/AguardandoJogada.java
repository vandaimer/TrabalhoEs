package modelo;

public class AguardandoJogada implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
		//vou fazer algum coisa
		if(p.realizouJogada(jgd)){
			return;
		}

		try{
			j.baralhoValido(new ValidacaoMao());
			p.adicionarJogada(jgd, j);
			p.notificarObservadores(new Mensagem("jogada_realizada", jgd));

			if(p.associacaoCompleta()){
				VerificandoPontuacao v=new VerificandoPontuacao();
				p.fixarEstado(v);
				v.verificandoVencedorDoTurno(p);

			}


		}catch(ExcecaoQuebraDeRegrasDoBaralho e){
			p.notificarObservadores(new Mensagem("Excecao", e));
		}

	}

	@Override
	public void iniciar(Partida p) {


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
