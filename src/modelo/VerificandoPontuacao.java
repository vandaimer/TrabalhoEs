package modelo;

public class VerificandoPontuacao implements EstadoDaPartida{

	@Override
	public void jogar(Partida p, Jogador jgd, Jogada j) {
<<<<<<< HEAD
	
=======

>>>>>>> 9e912f343e6a9ae557b31a1f343184799d589b8d
		
	}

	@Override
	public void iniciar(Partida p) {
<<<<<<< HEAD
		
=======
	
>>>>>>> 9e912f343e6a9ae557b31a1f343184799d589b8d
		
	}

	@Override
	public void fimDoJogo(Partida p) {	
<<<<<<< HEAD
	
=======
		
>>>>>>> 9e912f343e6a9ae557b31a1f343184799d589b8d
		
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

<<<<<<< HEAD
	@Override
	public boolean fimDoJogo() {
		return false;
	}
=======

>>>>>>> 9e912f343e6a9ae557b31a1f343184799d589b8d

}
