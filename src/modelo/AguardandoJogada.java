package modelo;

public class AguardandoJogada implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
		//vou fazer algum coisa
		
		try{
			j.baralhoValido(new ValidacaoMao());
			p.adicionarJogada(jgd, j);
			p.notificarObservadores(new Mensagem("jogada_realizada", jgd));
<<<<<<< HEAD
			if(p.associacaoCompleta()){
				VerificandoPontuacao v = new VerificandoPontuacao();				
				p.fixarEstado(v);
				v.verificandoVencedorDoTurno(p);
				
			}
=======
			
                        if(p.associacaoCompleta()){
                                VerificandoPontuacao v=new VerificandoPontuacao();
				p.fixarEstado(v);
                                v.verificandoVencedorDoTurno(p);
			
                        }
>>>>>>> 9e912f343e6a9ae557b31a1f343184799d589b8d
			
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

	

}
