package modelo.jogo.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;
import modelo.jogo.Jogador;
import modelo.jogo.partida.ControladorDePartida;
import modelo.jogo.partida.Partida;
import modelo.util.Conector;

class Servico implements Runnable, ControladorDePartida {

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
        partida = new Partida(_numMaxJogadores, this);

    }

    private void aceitarJogadores() throws IOException, InterruptedException {

        if (!_ouvintePorta.isAlive()) {
            _ouvintePorta.start();
        }
        semafaro.acquire();
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

    public void iniciarReceptores() throws InterruptedException {
        for (ReceptorDoControleRemoto r : receptores) {

            r.iniciar();
        }
        semafaro.acquire();
    }

    public void finalizarConexao() throws IOException {
        _svsocket.close();
    }

    @Override
    public void notificarFimDeJogo() {
        liberaSemafaro();
    }

    @Override
    public void run() {

        try {

            aceitarJogadores();
            iniciarReceptores();
            finalizarConexao();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace(System.out);
        }

    }

}
