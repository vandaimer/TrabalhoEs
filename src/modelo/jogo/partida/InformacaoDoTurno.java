package modelo.jogo.partida;

import java.io.Serializable;
import java.util.List;

import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogada;

public class InformacaoDoTurno implements Serializable {

    private Jogada _jgd;
    private Integer _pontuacao;

    public InformacaoDoTurno(Jogada jgd, Integer pontuacao) {
        _jgd = jgd;
        _pontuacao = pontuacao;
    }

    public Jogada obterJogada() {
        return _jgd;
    }

    public Integer obterPontuacao() {
        return _pontuacao;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nJogador: " + _jgd.getJogador().getNome() + "\t" + "Pontuacao: " + _pontuacao + "\n Cartas jogadas: ");
        List<CartaAbstrata> c = _jgd.getBaralhoJogada().listarCartas();
        for (CartaAbstrata cartaAbstrata : c) {
            sb.append(cartaAbstrata.toString());
            sb.append("\n");
        }

        return sb.toString();

    }

}
