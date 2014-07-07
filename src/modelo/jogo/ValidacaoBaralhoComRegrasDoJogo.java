package modelo.jogo;

import modelo.jogo.Carta;
import modelo.jogo.Baralho;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ValidacaoBaralhoComRegrasDoJogo implements EstrategiaDeValidacaoDoBaralho {

    int _qtdMininaDeCartas = 5,
            _qtdMaximaDeCartas = 10,
            _qtdMaximaDeCartasRepetidas = 2;

    public ValidacaoBaralhoComRegrasDoJogo() {

    }

    public ValidacaoBaralhoComRegrasDoJogo(int qtdMininaDeCartas, int qtdMaximaDeCartas, int qtdMaximaDeCartasRepetidas) {
        _qtdMininaDeCartas = qtdMininaDeCartas;
        _qtdMaximaDeCartas = qtdMaximaDeCartas;
        _qtdMaximaDeCartasRepetidas = qtdMaximaDeCartasRepetidas;
    }

    @Override
    public void validar(Baralho b) throws ExcecaoQuebraDeRegrasDoBaralho {
        List<Carta> cartas = b.listarCartas();
        int quantidadeCartas = cartas.size();

        if (quantidadeCartas < _qtdMininaDeCartas) {
            throw new ExcecaoQuebraDeRegrasDoBaralho("Numero de cartas insuficiente.");
        }

        
        if (verificaRepeticao(cartas)) {
            throw new ExcecaoQuebraDeRegrasDoBaralho("Repeticao de cartas acima do limite.");

        }

        if (quantidadeCartas > _qtdMaximaDeCartas) {

            throw new ExcecaoQuebraDeRegrasDoBaralho("Numero total de cartas execido.");
        }

    }

    private boolean verificaRepeticao(List<Carta> lista) {

        boolean existeRepeticao = false;
        HashMap<Carta, Integer> mapeamentoQuantidade = new HashMap<>();
        for (Carta c : lista) {

            if (!mapeamentoQuantidade.containsKey(c)) {
                mapeamentoQuantidade.put(c, 1);
            } else {
                int qtdade = mapeamentoQuantidade.get(c);
                qtdade++;
                mapeamentoQuantidade.put(c, qtdade);
            }

        }

        for (Carta c : mapeamentoQuantidade.keySet()) {
            if (mapeamentoQuantidade.get(c) > _qtdMaximaDeCartasRepetidas) {
                existeRepeticao = true;
                break;
            }
        }

        return existeRepeticao;
    }

}
