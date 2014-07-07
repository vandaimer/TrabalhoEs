package modelo;

public class VerificandoPontuacao implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {



		
	}

	@Override
	public void iniciar(Partida p) {
		
	}

	@Override
	public void fimDoJogo(Partida p) {	
		
	}

	@Override
	public void verificandoVencedorDoTurno(Partida p) {
		//atualizar o score através da comparação de cartas
		
		if(p.fimDeJogo()){
			//enviar o score atual como mensagem no notifica
			FimDoJogo f=new FimDoJogo();
                        p.fixarEstado(f);
                        f.fimDoJogo(p);
                        
		}else{
			p.notificarObservadores(new Mensagem("pontuacao", null));
			p.fixarEstado(new AguardandoIniciar());
		}		
	}


}
