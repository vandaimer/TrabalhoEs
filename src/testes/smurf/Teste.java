/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.smurf;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;


import testes.jean.Simulador;
import modelo.jogo.Carta;
import modelo.util.ConectorCliente;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import modelo.jogo.servidor.ExcececaoConexaoRecusada;
import modelo.jogo.Jogador;
import modelo.jogo.Portal;
import modelo.persistencia.RepositorioDeJogoDB;
import modelo.persistencia.Fabrica;



/**
 *
 * @author jean
 */
public class Teste {

    public static void main(String[] args) throws ExcececaoConexaoRecusada, IOException, InterruptedException {
        Jogador j = new Jogador("rodrigo", "mel");
        Portal p = new Portal(new RepositorioDeJogoDB(new Fabrica("150.162.52.177", "jogoes", "@fuckingpassword@", "engenhariasoftware")));
        p.autenticar(j);

        
        ControleRemoto r = p.conectarAoOponente("localhost", 1234);
        
        Simulador s = new Simulador(r);
        r.registrar(s);
        r.iniciar();
        

    }

}
