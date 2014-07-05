package modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class ServidorDePartida {

    private Thread tServico;

    public ServidorDePartida(int porta, int numJogadores) throws IOException {
        tServico = new Thread(new Servico(porta, numJogadores));
    }

    public ServidorDePartida(int porta) throws IOException {
        this(porta, 2);
    }

    public synchronized void iniciarServico() {

        if (!tServico.isAlive()) {
            tServico.start();

        }

    }

}

class Servico implements Runnable {

    private int _porta;
    private int _numMaxJogadores;
    private Partida partida = new Partida();
    private ServerSocket _svsocket;
    private List<ReceptorDoControleRemoto> receptores = new LinkedList<ReceptorDoControleRemoto>();

    public Servico(int porta, int numJogadores) throws IOException {
        _porta = porta;
        _numMaxJogadores = numJogadores;
        _svsocket = new ServerSocket(_porta);

    }

    public void aceitarJogadores() throws IOException {

        while (true) {

            ConectorCliente cliente = new ConectorCliente(_svsocket.accept());
            new Thread(new AprovarConexao(cliente, this)).start();

        }
    }

    public synchronized void incluirJogador(Jogador j, Conector con)  {
        
        if (receptores.size() != _numMaxJogadores) {

            receptores.add(new ReceptorDoControleRemoto(j, con));
            partida.adicionarJogador(j);
            return;
        }

    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}

class AprovarConexao implements Runnable {

    private Conector _con;
    private Servico _servico;

    public AprovarConexao(Conector con, Servico servico) {
        _con = con;
        _servico = servico;
    }

    @Override
    public void run() {

    }

}


class Cal implements Callable<List<ReceptorDoControleRemoto>>{

    @Override
    public List<ReceptorDoControleRemoto> call() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}