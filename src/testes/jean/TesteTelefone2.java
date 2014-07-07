
package testes.jean;

import java.io.IOException;
import java.net.ServerSocket;
import modelo.util.ConectorCliente;
import modelo.util.Observado;
import modelo.util.Observador;


public class TesteTelefone2 {

    
    public static void main(String[] args) throws IOException {
        ServerSocket ss=new ServerSocket(1234);
        ConectorCliente c = new ConectorCliente(ss.accept());
        
        Telefone t = new Telefone(c);
      
        t.registrar(new Observador() {
      
            
            @Override
            public void notificar(Object fonte, Object msg) {
                System.out.println("ouvi: "+msg);
            }
        });
        
        t.falar("cuuu");
        t.falar("cuuu");
        
        t.ligar();
        
       
        
        //t.desligar();
    }
    
    
}
