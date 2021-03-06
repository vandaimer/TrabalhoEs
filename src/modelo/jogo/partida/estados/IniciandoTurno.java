package modelo.jogo.partida.estados;

import modelo.jogo.partida.estados.EstadoDaPartida;
import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.jogo.partida.Partida;
import modelo.util.Mensagem;

public class IniciandoTurno implements EstadoDaPartida {

    @Override
    public void jogar(Partida p, Jogador jgd, Jogada j) {

    }

    @Override
    public void iniciar(Partida p) {

        p.limparJogadas();
        p.incrementarTurno();
        AguardandoJogada ag = new AguardandoJogada();
        p.fixarEstado(ag);
        p.notificarObservadores(new Mensagem("iniciar_turno", null));

    }

    @Override
    public void fimDoJogo(Partida p) {

    }

    @Override
    public void verificandoVencedorDoTurno(Partida p) {

    }

    @Override
    public void verificandoReconhecimento(Partida p, Jogador jgd) {
        // TODO Auto-generated method stub

    }

}
