package modelo.jogo.servidor.controleremoto;

import java.io.Serializable;
import java.util.HashMap;

import modelo.jogo.Jogador;
import modelo.metodoremoto.MetodoRemotoControleRemoto;

public class AtualizarPontuacaoControleRemoto implements MetodoRemotoControleRemoto{

	private Serializable _pontuacao;
	public AtualizarPontuacaoControleRemoto(Serializable pontuacao) {
		_pontuacao = pontuacao;
	}
	
	@Override
	public void aceitar(ControleRemoto c) {
		c.atualizarPontuacao(_pontuacao);
		
	}

}
