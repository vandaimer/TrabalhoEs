package testes.jean;

import java.io.IOException;
import java.util.LinkedList;
import modelo.Carta;
import modelo.ConectorCliente;
import modelo.ControleRemoto;
import modelo.Jogador;
import modelo.Observado;
import modelo.Observador;

public class TesteControleRemoto {

    public static void main(String[] args) throws IOException, InterruptedException {

        Jogador j = new Jogador("jean", "1");
        ConectorCliente c = new ConectorCliente("localhost", 1234);
        Thread.sleep(1000);
        final ControleRemoto r = new ControleRemoto(j, c);
        r.registrar(new Observador() {

            @Override
            public void notificar(Observado fonte, Object msg) {
                System.out.println(msg);

               
            }
        });

        r.iniciar();

    }

}
