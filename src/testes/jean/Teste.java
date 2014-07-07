package testes.jean;

import java.io.IOException;

import modelo.jogo.servidor.controleremoto.ControleRemoto;
import modelo.jogo.Jogador;
import modelo.jogo.Portal;
import modelo.persistencia.RepositorioDeJogoDB;

import modelo.persistencia.Fabrica;

public class Teste {

    public static void main(String[] args) throws IOException, InterruptedException {

        iniciarLadoServidor();
        iniciarLadoCliente();

    }

    public static void iniciarLadoCliente() throws IOException, InterruptedException {
        Jogador j = new Jogador("rodrigo", "mel");
        Portal p = new Portal(new RepositorioDeJogoDB(new Fabrica("150.162.52.177", "jogoes", "@fuckingpassword@", "engenhariasoftware")));
        p.autenticar(j);
        ControleRemoto r = p.conectarAoOponente("localhost", 1234);
        Simulador s = new Simulador(r);
        r.registrar(s);
        r.iniciar();
    
    }

    public static void iniciarLadoServidor() throws IOException, InterruptedException {

        Portal portal = new Portal(new RepositorioDeJogoDB(new Fabrica("150.162.52.177", "jogoes", "@fuckingpassword@", "engenhariasoftware")));
        Jogador j = new Jogador("jean", "1234");
        portal.autenticar(j);
        System.out.println("Servidor Iniciado");
        ControleRemoto ctr = portal.criarPartida(1234);
        Simulador s = new Simulador(ctr);
        ctr.registrar(s);
        ctr.iniciar();
    }

}


