package testes.jean;

import java.io.IOException;
import modelo.jogo.Jogador;
import modelo.jogo.Portal;
import modelo.jogo.servidor.ExcececaoConexaoRecusada;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import modelo.persistencia.Fabrica;
import modelo.persistencia.FabricaFerramentasPersistencia;
import modelo.persistencia.RepositorioDeJogoDB;

public class TesteDeEstimulos {

    public static void main(String[] args) throws ExcececaoConexaoRecusada, IOException {
        FabricaFerramentasPersistencia fabrica = new Fabrica("150.162.52.177", "jogoes", "@fuckingpassword@", "engenhariasoftware");
        Portal p = new Portal(new RepositorioDeJogoDB(fabrica));
        p.autenticar(new Jogador("rodrigo", "mel"));
        ControleRemoto controle = p.conectarAoOponente("localhost", 1234);
        Simulador s=new Simulador(controle);
        controle.registrar(s);
        controle.iniciar();
        
       
    }

}
