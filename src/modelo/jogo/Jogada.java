package modelo.jogo;

import modelo.jogo.Baralho;
import java.io.Serializable;

public class Jogada implements Serializable, Comparable<Jogada> {

    private Baralho _b;

    public Jogada(Baralho b) {
        _b = b;
    }

    public void baralhoValido(EstrategiaDeValidacaoDoBaralho e) throws ExcecaoQuebraDeRegrasDoBaralho {
        _b.validar(e);
    }

	@Override
	public int compareTo(Jogada o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
    

}
