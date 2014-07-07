package modelo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ServidorDePartida {

    private Thread tServico;

    public ServidorDePartida(int porta, int numJogadores, int timeOut) throws IOException {
        tServico = new Thread(new Servico(porta, numJogadores, timeOut));

        if (porta < 0) {
            throw new IllegalArgumentException("O nuemro da porta deve ser positivo.");
        }

        if (numJogadores < 2) {
            throw new IllegalArgumentException("O numero minimo de jogadores deve ser 2.");
        }

        if (!(timeOut > 0)) {
            throw new IllegalArgumentException("O tempo de espera pra conexao de ser maior que zero.");
        }

    }

    public ServidorDePartida(int porta) throws IOException {
        this(porta, 2, 10000);
    }

    public ServidorDePartida() throws IOException {
        this(1234);
    }

    public synchronized void iniciarServico() {

        if (!tServico.isAlive()) {
            tServico.start();

        }

    }

}

class Servico implements Runnable,ControladorDePartida {

    private final ServerSocket _svsocket;
    private final List<ReceptorDoControleRemoto> receptores = new LinkedList<>();
    private final Partida partida;
    private final int _numMaxJogadores;
    private final Thread _ouvintePorta;
    private final Semaphore semafaro = new Semaphore(0);

    public Servico(int porta, int numJogadores, int timeOut) throws IOException {

        _numMaxJogadores = numJogadores;
        _svsocket = new ServerSocket(porta);
        _ouvintePorta = new Thread(new OuvinteDePorta(_svsocket, this));
        _svsocket.setSoTimeout(timeOut);
        partida = new Partida(_numMaxJogadores,this);

    }

    private void aceitarJogadores() throws IOException {

        if (!_ouvintePorta.isAlive()) {
            _ouvintePorta.start();
        }

    }

    public synchronized void aprovarConexao(Conector con) {

        if (receptores.size() == _numMaxJogadores) {
            con.enviar(new ExcececaoConexaoRecusada("O numero de jogadores aceito no servidor foi excedido."));
            return;
        }

        try {

            Jogador j = (Jogador) con.receber();
            partida.adicionarJogador(j);
            ReceptorDoControleRemoto recp = new ReceptorDoControleRemoto(partida, j, con);
            receptores.add(recp);
            partida.registrar(recp);
            con.enviar(j);

        } catch (IllegalArgumentException e) {
            con.enviar(e);
        }

        if (receptores.size() == _numMaxJogadores && _ouvintePorta.isAlive()) {
            _ouvintePorta.interrupt();
            liberaSemafaro();

        }

    }

    public void liberaSemafaro() {
        semafaro.release();
    }

    @Override
    public void run() {

        try {

            aceitarJogadores();
            semafaro.acquire();
            
            for (ReceptorDoControleRemoto r : receptores) {

                r.iniciar();
            }

            partida.iniciar();
            semafaro.acquire();
 
            for (ReceptorDoControleRemoto r : receptores) {
                r.finalizar();
            }
            _svsocket.close();
          
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void notificarFimDeJogo() {
    liberaSemafaro();
    }

}

class AprovarConexao implements Runnable {

    private final Conector _con;
    private final Servico _s;

    public AprovarConexao(Conector con, Servico s) {
        _con = con;
        _s = s;
    }

    @Override
    public void run() {
        _s.aprovarConexao(_con);
    }

}

class OuvinteDePorta implements Runnable {

    private final ServerSocket _svd;
    private final Servico _s;
    private int _nTimeOut = 0;

    public OuvinteDePorta(ServerSocket svd, Servico s) {
        _svd = svd;
        _s = s;

    }

    @Override
    public void run() {

        while (true) {

            try {

                Socket socket = _svd.accept();
                ConectorCliente cliente = new ConectorCliente(socket);
                new Thread(new AprovarConexao(cliente, _s)).start();
                _nTimeOut = 0;

            } catch (SocketTimeoutException e) {

                if (++_nTimeOut == 6) {
                    _s.liberaSemafaro();
                    System.out.println(_nTimeOut);
                    break;
                }

            } catch (IOException e) {
                if (_svd.isClosed()) {
                    break;
                }
            }

        }
    }

}
