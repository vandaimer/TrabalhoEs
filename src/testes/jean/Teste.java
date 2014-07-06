package testes.jean;

import java.io.IOException;
import modelo.ConectorCliente;
import modelo.Jogador;
import modelo.ServidorDePartida;

public class Teste {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServidorDePartida sv = new ServidorDePartida(1234);
        sv.iniciarServico();
        System.out.println("Esperando");
        Thread.sleep(2000);
       
        Jogador j1 = new Jogador("Jean", "j");
        Jogador j2 = new Jogador("Rodz", "j");

        ConectorCliente c1 = new ConectorCliente("localhost", 1234);
        System.out.println("Enviar cliente 1");
        c1.enviar(j1);
        System.out.println(c1.receber());
        //ConectorCliente c2 = new ConectorCliente("localhost", 1234);
        
//       System.out.println("Enviar cliente 2");
//        c2.enviar(j2);
//        System.out.println(c2.receber());
//        
        System.out.println("fim dos envios");
    }

}
