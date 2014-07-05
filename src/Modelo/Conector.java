
package Modelo;

import java.io.Serializable;


public interface Conector {

    
    public void enviar(Serializable o);
    public  Serializable receber();
    public void fechar();
    public boolean estaConectado();


}
