package modelo;

import java.util.LinkedList;
import java.util.List;

public class AguardandoReconhecimento implements EstadoDaPartida {

    private List<Jogador> reconhecimentoJogadores = new LinkedList<Jogador>();

    @Override
    public void jogar(Partida p, Jogador jgd, Jogada j) {
        // TODO Auto-generated method stub

    }

    @Override
    public void iniciar(Partida p) {
        // TODO Auto-generated method stub

    }

    @Override
    public void fimDoJogo(Partida p) {
        // TODO Auto-generated method stub

    }

    @Override
    public void verificandoVencedorDoTurno(Partida p) {
        // TODO Auto-generated method stub

    }

    @Override
    public void verificandoReconhecimento(Partida p, Jogador jgd) {
        if (reconhecimentoJogadores.contains(jgd)) {
            return;
        }
        reconhecimentoJogadores.add(jgd);

        if (p.contemJogador(reconhecimentoJogadores)) {

            if (!p.quantidadeJogadoresValida()) {

                FimDoJogo f = new FimDoJogo();
                p.fixarEstado(f);
                f.fimDoJogo(p);
                return;
            }

            IniciandoTurno ag = new IniciandoTurno();
            p.fixarEstado(ag);
            ag.iniciar(p);

        }

    }

}
