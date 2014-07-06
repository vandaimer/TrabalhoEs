/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testes.smurf;

import java.io.IOException;

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
    	System.out.print("partida criada");
        
    }
}
