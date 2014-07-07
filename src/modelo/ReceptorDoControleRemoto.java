package modelo;

import java.io.Serializable;
import testes.jean.Telefone;

public class ReceptorDoControleRemoto implements Observador {

    private Jogador _jgd;
    private Partida _p;
    private Telefone tel;

    public ReceptorDoControleRemoto(Partida p, Jogador jgd, Conector con) {
        _jgd = jgd;
        _p = p;
        tel = new Telefone(con);

    }

    public void iniciar() {
        tel.registrar(this);
        _p.registrar(this);
        tel.ligar();

    }

  

    @Override
    public void notificar(Observado fonte, Object leitura) {

        if (fonte.equals(tel)) {

            if (leitura instanceof MetodoRemotoPartida) {
                MetodoRemotoPartida m = (MetodoRemotoPartida) leitura;
                m.aceitar(_p);
            }

        }

        if (fonte.equals(_p)) {

            tel.falar((Serializable) leitura);

            if ("fim_do_jogo".equals(leitura)) {
                tel.desligar();
            }
        }

    }
}
