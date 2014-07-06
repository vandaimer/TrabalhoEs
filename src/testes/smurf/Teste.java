/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes.smurf;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import modelo.ConectorCliente;

import modelo.ExcececaoConexaoRecusada;
import modelo.Jogador;
import modelo.Portal;
import modelo.RepositorDeJogoEmMemoria;

/**
 *
 * @author jean
 */
public class Teste {
    public static void main(String[] args) throws ExcececaoConexaoRecusada, IOException {
    	Jogador j = new Jogador("rodrigo", "123");
    	Portal p = new Portal(new RepositorDeJogoEmMemoria());
    	p.criarJogador(j);
    	p.autenticar(j);    	
    	p.criarPartida(1234);
    	System.out.println("partida criada");
        servir(1234);
    }
    
        public static void servir( int porta) {
        try {

            ServerSocket sv=new ServerSocket(porta);
            Socket sc = sv.accept();
            ConectorCliente con = new ConectorCliente(sc);
            con.enviar("conexao aceita");
            System.out.println(con.receber());
           sv.close();

        } catch (Exception e) {
        }
    }
}
