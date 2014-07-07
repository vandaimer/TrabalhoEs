
package modelo.metodoremoto;


import java.io.Serializable;
import modelo.jogo.servidor.ReceptorDoControleRemoto;


public interface MetodoRemotoReceptor extends Serializable{

    public void aceitar(ReceptorDoControleRemoto p);
}
