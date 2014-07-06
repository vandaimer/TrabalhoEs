package testes.jean;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import modelo.ConectorCliente;
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
        ControleRemoto ctr = portal.conectarAoOponente("177.132.96.43", 1234);
        //ControleRemoto ctr = portal.conectarAoOponente("192.168.1.3", 1234);
        conectar("177.132.96.43", 1234);
    }

    public static void conectar(String ip, int porta) {
        try {

            Socket sc = new Socket(ip, porta);
            ConectorCliente con = new ConectorCliente(sc);
            System.out.println(con.receber());
            con.enviar("porraaaa");
            sc.close();
        } catch (Exception e) {
        }
    }

}
