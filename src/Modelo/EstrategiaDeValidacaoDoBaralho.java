
package Modelo;

import java.util.List;


public interface EstrategiaDeValidacaoDoBaralho {
    List<ErroDeValidacao> validar(Baralho b);
}
