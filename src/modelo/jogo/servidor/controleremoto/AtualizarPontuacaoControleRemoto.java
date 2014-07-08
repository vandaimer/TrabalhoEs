package modelo.jogo.servidor.controleremoto;

import java.io.Serializable;
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
