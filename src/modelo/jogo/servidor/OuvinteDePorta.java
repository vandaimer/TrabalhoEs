
package modelo.jogo.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import modelo.util.ConectorCliente;

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