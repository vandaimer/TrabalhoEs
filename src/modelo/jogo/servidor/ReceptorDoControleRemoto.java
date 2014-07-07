package modelo.jogo.servidor;

import modelo.metodoremoto.MetodoRemotoPartida;
import modelo.jogo.Jogador;
import modelo.jogo.partida.Partida;
import java.io.Serializable;
import modelo.jogo.servidor.controleremoto.Finalizar;
import modelo.jogo.servidor.controleremoto.NotificarObservadores;
import modelo.util.Conector;
import modelo.util.Mensagem;
import modelo.util.Observador;
import testes.jean.Telefone;

public class ReceptorDoControleRemoto implements Observador,Serializable {

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
    public void notificar(Object fonte, Object msg) {

        if (fonte.equals(tel)) {

            if (msg instanceof MetodoRemotoPartida) {
                MetodoRemotoPartida m = (MetodoRemotoPartida) msg;
                m.aceitar(_p);
            }

            return;
        }

        if (fonte.equals(_p)) {

            Mensagem m = (Mensagem) msg;
            Serializable assunto = m.obterAssunto();

            if ("iniciar_turno".equals(assunto)) {
                
                tel.falar(new NotificarObservadores("iniciar_turno"));
                return;
            }

            if ("jogada_realizada".equals(assunto) && _jgd.equals(m.obterConteudo())) {
                tel.falar(new NotificarObservadores("jogada_realizada"));
                return;
            }

            if ("atualizar_pontuacao".equals(assunto)) {
              tel.falar(new NotificarObservadores("atualizar_pontuacao"));
                return;
            }

            if ("fim_do_jogo".equals(assunto)) {
                tel.falar(new NotificarObservadores("fim_do_jogo"));
                tel.falar(new Finalizar());
                tel.desligar();
                return;
            }

        }

    }
}
