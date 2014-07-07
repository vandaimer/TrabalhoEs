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

import modelo.Carta;
import modelo.ConectorCliente;
import modelo.ControleRemoto;
import modelo.ExcececaoConexaoRecusada;
import modelo.Jogador;
import modelo.Portal;
import modelo.RepositorDeJogoEmMemoria;
import modelo.RepositorioDeJogoDB;
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
		ControleRemoto r = p.conectarAoOponente("192.168.1.4",1234);
		
		Thread.sleep(5000);
		r.jogar(new LinkedList<Carta>());
		
		Thread.sleep(10000);
		r.jogar(new LinkedList<Carta>());


	}
	/*Portal portal = new Portal(new RepositorioDeJogoDB(new Fabrica("150.162.52.177", "jogoes", "@fuckingpassword@", "engenhariasoftware")));
        Jogador j = new Jogador("jean", "1234");
        portal.autenticar(j);        
        ControleRemoto ctr = portal.conectarAoOponente("192.168.1.3", 1234);
        Thread.sleep(2000);
        ctr.jogar(new LinkedList<Carta>());*/

}
