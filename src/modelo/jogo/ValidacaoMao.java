package modelo.jogo;

import java.util.List;

import modelo.jogo.Baralho;

public class ValidacaoMao implements EstrategiaDeValidacaoDoBaralho{
	
	private int quantidadeEfeitos = 2;
	private int quantidadeMaximaMao = 3;
	
	public ValidacaoMao(){
		
	}	
	private int possuiMonstro(List<CartaAbstrata> l){
		int quantidade = 0;
		for (CartaAbstrata cA : l) {
			if(cA instanceof Carta){
				quantidade++;				
			}
		}
		return quantidade;
	}
	
	

	@Override
	public void validar(Baralho b) throws ExcecaoQuebraDeRegrasDoBaralho {
		//nula invalida
		if(b.equals(null)){
			throw new ExcecaoQuebraDeRegrasDoBaralho("Quantidade de cartas inválidas");
		}
		List<CartaAbstrata> mao = b.listarCartas();
		if(mao.size() > 3){
			throw new ExcecaoQuebraDeRegrasDoBaralho("Quantidade de cartas excedida");
		}
		int teste = possuiMonstro(mao);
		System.out.println(teste);
		if(possuiMonstro(mao) > 1){
			throw new ExcecaoQuebraDeRegrasDoBaralho("Quantidade de monstro excedida: "+possuiMonstro(mao));			
		}
		if(possuiMonstro(mao) == 0){
			throw new ExcecaoQuebraDeRegrasDoBaralho("Quantidade de monstro deve ser uma: "+possuiMonstro(mao));
		}
	}

}
