package modelo.jogo.partida.estados;

import modelo.jogo.partida.estados.EstadoDaPartida;
import modelo.jogo.partida.estados.VerificandoPontuacao;
import modelo.jogo.ExcecaoQuebraDeRegrasDoBaralho;
import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.util.Mensagem;
import modelo.jogo.ValidacaoMao;
import modelo.jogo.partida.Partida;

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
			p.notificarObservadores(new Mensagem("jogada_invalida", e));
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
