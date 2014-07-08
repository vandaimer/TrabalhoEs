package modelo.jogo;


import java.io.Serializable;
import java.util.LinkedList;




public class Jogada implements Serializable, Comparable<Jogada> {

	private Baralho _b;
	private Jogador _j;

	public Jogada(Baralho b) {
		_b = b;
	}

	public Jogada(Baralho b, Jogador j) {
		_b = b;
		_j = j;
	}


	public void baralhoValido(EstrategiaDeValidacaoDoBaralho e)
			throws ExcecaoQuebraDeRegrasDoBaralho {
		_b.validar(e);
	}

	private CartaAbstrata obterCartaEfetiva() {
		LinkedList<CartaEfeito> cartasEfeito = new LinkedList<>();
		CartaAbstrata umaCarta = null;

		for (CartaAbstrata c : _b.listarCartas()) {


			if (c instanceof CartaEfeito) {
				cartasEfeito.add((CartaEfeito) c);

			}
			if(c instanceof Carta){
				umaCarta = c;
			}

		}
		
		for(CartaEfeito e: cartasEfeito){
			
			umaCarta = e.decorar(umaCarta);
		}

		return umaCarta;


	}

	public Jogador getJogador() {
		return _j;
	}

	@Override
	public int compareTo(Jogada o) {
		CartaAbstrata minha = obterCartaEfetiva();
		CartaAbstrata outraCarta = o.obterCartaEfetiva();
		
		return minha.compareTo(outraCarta);
	}

}
