package modelo.jogo.servidor;

import java.io.Serializable;
import modelo.util.Conector;
import modelo.util.ObservadoImpl;

public class Telefone extends ObservadoImpl {

    private final Conector con;
    private Thread tleitor;

    public Telefone(Conector con) {
        this.con = con;
    }

    public void falar(Serializable palavra) {
        con.enviar(palavra);
    }

    class Leitor implements Runnable {

        @Override
        public void run() {

            while (true) {
                Serializable leitura = con.receber();

                if (leitura == null) {
                    break;
                }

                notificarObservadores(leitura);

            }

        }

    }

    public void ligar() {

        if (tleitor == null) {
            tleitor = new Thread(new Leitor());
            tleitor.start();
        }

    }

    public void desligar() {

        if (tleitor != null) {
            tleitor.interrupt();
            tleitor = null;
            con.fechar();
        }

    }
}
