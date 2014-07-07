
package modelo.jogo;

import modelo.jogo.Baralho;




public interface EstrategiaDeValidacaoDoBaralho {
    public void validar(Baralho b)throws ExcecaoQuebraDeRegrasDoBaralho;
}
