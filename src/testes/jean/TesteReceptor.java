package testes.jean;

import java.io.IOException;
import java.net.ServerSocket;
import modelo.ConectorCliente;
import modelo.ControladorDePartida;
import modelo.Jogador;
import modelo.Partida;
import modelo.ReceptorDoControleRemoto;

public class TesteReceptor {
    
    public static void main(String[] args) throws IOException {
        
        Partida p = new Partida(1, new ControladorDePartida() {
            
            @Override
            public void notificarFimDeJogo() {
                
            }
        });
        
        Jogador j = new Jogador("jean", "1");
        p.adicionarJogador(j);
        
        ServerSocket ss = new ServerSocket(1234);
        ConectorCliente con = new ConectorCliente(ss.accept());
        con.enviar("uma msg");
        con.enviar("uma msg");
        con.enviar("uma msg");
        con.enviar("uma msg");
        con.enviar("uma msg");
        con.enviar("uma msg");
        con.enviar("uma msg");
        
//        ReceptorDoControleRemoto rc = new ReceptorDoControleRemoto(p,j,con);
//        p.registrar(rc);
//        rc.iniciar();
//        
        
    }
}
