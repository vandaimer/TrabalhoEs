
package modelo.metodoremoto;

import modelo.jogo.partida.Partida;
import java.io.Serializable;


public interface MetodoRemotoPartida extends Serializable{

    public void aceitar(Partida p);
}
