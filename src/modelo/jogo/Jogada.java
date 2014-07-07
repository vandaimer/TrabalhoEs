package modelo.jogo;

import modelo.jogo.Baralho;
import java.io.Serializable;

public class Jogada implements Serializable,Comparable<Jogada> {


    private Baralho _b;
    private Jogador _j;

    public Jogada(Baralho b) {
        _b = b;
    }
    public Jogada(Baralho b, Jogador j){
    	_b = b;
    	_j = j;
    }

    public void baralhoValido(EstrategiaDeValidacaoDoBaralho e) throws ExcecaoQuebraDeRegrasDoBaralho {
        _b.validar(e);
    }
    public Carta obterCartaEfetiva(){
    	return null;
    }
    public Jogador getJogador(){
    	return _j;
    }

	@Override
	public int compareTo(Jogada o) {
		
		return 0;
	}


    
    

}
