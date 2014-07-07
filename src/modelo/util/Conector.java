
package modelo.util;

import java.io.Serializable;


public interface Conector {

    
    
    /**
     * O metodo envia um objeto atraves da rede. 
     
     */
    public void enviar(Serializable o);
    
    /**
     * O metodo bloqueia o fluxo ate receber um objeto. 
     * @return Retorna o Objeto lido, caso ocorra algum erro de leitura
     * ele retorno null.
     */
    public  Serializable receber();
        
    
    /**
     * O metodo encerra a conexao. 
     */
    public void fechar();
        
    
    /**
     * Verifica se a conexao esta aberta.
     * @return estado da conexao.
     */
    public boolean estaConectado();


}
