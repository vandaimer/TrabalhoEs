package modelo.jogo.servidor;

import java.io.IOException;

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






