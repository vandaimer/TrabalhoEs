package modelo;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConectorCliente implements Conector {

    private Socket _socket;

    public ConectorCliente(Socket s) {
        _socket = s;
    }

    public ConectorCliente(String ip, int porta) {
        try {
            _socket = new Socket(ip, porta);

        } catch (UnknownHostException e) {
            _socket = null;
             e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            _socket = null;
        }

    }

    @Override
    public void enviar(Serializable o) {
        try {

            OutputStream saida = _socket.getOutputStream();
            ObjectOutputStream objo = new ObjectOutputStream(saida);
            objo.writeObject(o);

        } catch (IOException e) {

        }

    }

    @Override
    public Serializable receber() {

        try {

            InputStream entrada = _socket.getInputStream();
            ObjectInputStream objo = new ObjectInputStream(entrada);
            return (Serializable) objo.readObject();

        } catch (IOException | ClassNotFoundException e) {
            return null;
        }

    }

    @Override
    public void fechar() {
        try {
            _socket.close();
        } catch (IOException e) {

        }

    }

    @Override
    public boolean estaConectado() {
        return _socket != null;
    }

}
