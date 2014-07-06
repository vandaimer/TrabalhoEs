package modelo;

import java.io.Serializable;

public class ReceptorDoControleRemoto implements Observador {

    private Jogador _jgd;
    private Conector _con;
    private Thread tLeitura;
    private Partida _p;

    public ReceptorDoControleRemoto(Partida p, Jogador jgd, Conector con) {
        _jgd = jgd;
        _con = con;
        _p = p;

    }

    public void iniciar() {

    }

    public void finalizar() {

    }

    @Override
    public void notificar(Observado fonte, Object msg) {

        if (fonte.equals(_p)) {
            try {
                
                _con.enviar((Serializable) msg);
                
            } catch (Exception e) {
            }

        }
    }

}
