package testes.jean;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import modelo.Carta;
import modelo.ControleRemoto;
import modelo.Jogador;
import modelo.Observado;
import modelo.Observador;
import modelo.Portal;
import modelo.RepositorioDeJogoDB;
import modelo.persistencia.Fabrica;

public class Teste {

    public static void main(String[] args) throws IOException, InterruptedException {

        Portal portal = new Portal(new RepositorioDeJogoDB(new Fabrica("150.162.52.177", "jogoes", "@fuckingpassword@", "engenhariasoftware")));
        Jogador j = new Jogador("jean", "1234");
        portal.autenticar(j);
        servir(portal, 1234);
    }

    public static void conectar(Portal p, String ip, int porta) throws IOException, InterruptedException {

        ControleRemoto ctr = p.conectarAoOponente(ip, porta);
        System.out.println("conectado ao oponente");
        Thread.sleep(2000);
        ctr.jogar(new LinkedList<Carta>());

    }

    public static void servir(Portal p, int porta) throws IOException, InterruptedException {

        ControleRemoto ctr = p.criarPartida(porta);
        Simulador s = new Simulador(ctr);

        while (!s.fim()) {}

    }
    
    
}


