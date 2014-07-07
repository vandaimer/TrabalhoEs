package modelo.jogo.partida.estados;

import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.jogo.partida.Partida;
import modelo.util.Mensagem;

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
		p.notificarObservadores(new Mensagem("atualizar_pontuacao", 100));
		if(p.fimDeJogo()){
			//enviar o score atual como mensagem no notifica
			FimDoJogo f=new FimDoJogo();
                        p.fixarEstado(f);
                        f.fimDoJogo(p);
                        
		}else{
			IniciandoTurno it=new IniciandoTurno();
			p.fixarEstado(new IniciandoTurno());
                        
                        it.iniciar(p);
                        
		}		
	}

	@Override
	public void verificandoReconhecimento(Partida p, Jogador jgd) {
		// TODO Auto-generated method stub
		
	}


}
