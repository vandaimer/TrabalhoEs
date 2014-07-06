package testes.jean;

import java.io.IOException;
import java.util.LinkedList;
import modelo.Carta;
import modelo.ControleRemoto;
import modelo.Jogador;
import modelo.Portal;
import modelo.RepositorDeJogoEmMemoria;

public class Teste {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Portal portal = new Portal(new RepositorDeJogoEmMemoria());
        Jogador j = new Jogador("jean", "1");
        portal.criarJogador(j);
        portal.autenticar(j);
        ControleRemoto ctr = portal.conectarAoOponente("192.168.1.3", 1234);    
        ctr.jogar(new LinkedList<Carta>());
    
    }
    
}
