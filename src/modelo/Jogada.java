package modelo;

import java.io.Serializable;

public class Jogada implements Serializable {

    private Baralho _b;

    public Jogada(Baralho b) {
        _b = b;
    }

    public void baralhoValido(EstrategiaDeValidacaoDoBaralho e) throws ExcecaoQuebraDeRegrasDoBaralho {
        _b.validar(e);
    }

}
