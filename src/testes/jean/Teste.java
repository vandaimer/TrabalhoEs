package testes.jean;

import java.io.IOException;
import java.util.LinkedList;
import modelo.Carta;
import modelo.ControleRemoto;
import modelo.Jogador;
import modelo.Portal;
import modelo.RepositorioDeJogoDB;
import modelo.persistencia.Fabrica;

public class Teste {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        Portal portal = new Portal(new RepositorioDeJogoDB(new Fabrica("150.162.52.177", "jogoes", "@fuckingpassword@", "engenhariasoftware")));
        Jogador j = new Jogador("jean", "1234");
        portal.autenticar(j);        
        ControleRemoto ctr = portal.conectarAoOponente("192.168.1.3", 1234);
        Thread.sleep(2000);
        ctr.jogar(new LinkedList<Carta>());
        
    }
    
}
