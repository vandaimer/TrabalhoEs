package modelo.jogo.partida;

import java.io.Serializable;
import java.util.List;

import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogada;

public class InformacaoDoTurno implements Serializable {

    private Jogada _jgd;
    private Integer _pontuacao;
    private Integer _turno;

    public InformacaoDoTurno(Jogada jgd, Integer pontuacao, Integer turno) {
        _jgd = jgd;
        _pontuacao = pontuacao;
        _turno = turno;
    }

    public Jogada obterJogada() {
        return _jgd;
    }

    public Integer obterPontuacao() {
        return _pontuacao;
    }

    public Integer obterTurno() {
        return _turno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nJogador: " + _jgd.getJogador().getNome() + "\t" + "Pontuacao: " + _pontuacao + "\t Turno atual: " + _turno + "\n Cartas jogadas: ");
        List<CartaAbstrata> c = _jgd.getBaralhoJogada().listarCartas();
        for (CartaAbstrata cartaAbstrata : c) {
            sb.append(cartaAbstrata.toString());
            sb.append("\n");
        }

        return sb.toString();

    }

}
