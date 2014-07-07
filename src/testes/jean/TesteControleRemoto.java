package testes.jean;

import java.io.IOException;
import java.util.LinkedList;
import modelo.jogo.Carta;
import modelo.util.ConectorCliente;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import modelo.jogo.Jogador;
import modelo.util.Observado;
import modelo.util.Observador;

public class TesteControleRemoto {

    public static void main(String[] args) throws IOException, InterruptedException {

        Jogador j = new Jogador("jean", "1");
        ConectorCliente c = new ConectorCliente("localhost", 1234);
        Thread.sleep(1000);
        final ControleRemoto r = new ControleRemoto(j, c);
        r.registrar(new Observador() {

            @Override
            public void notificar(Object fonte, Object msg) {
                System.out.println(msg);

               
            }
        });

        r.iniciar();

    }

}
