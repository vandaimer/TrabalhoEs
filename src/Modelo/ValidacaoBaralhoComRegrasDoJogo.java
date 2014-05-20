package Modelo;

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
    public List<ErroDeValidacao> validar(Baralho b) {
        List<Carta> cartas = b.listarCartas();
        List<ErroDeValidacao> listaErros = new LinkedList<>();

        int quantidadeCartas = cartas.size();

        if (quantidadeCartas < _qtdMininaDeCartas) {

            listaErros.add(ErroDeValidacao.NUM_CARTAS_INSUFICIENTE);
        }

        if (quantidadeCartas > _qtdMaximaDeCartas) {

            listaErros.add(ErroDeValidacao.NUM_CARTAS_EXCEDENTE);
        }

        if (verificaRepeticao(cartas)) {
            listaErros.add(ErroDeValidacao.CARTAS_REPETIDAS);
        }
        return listaErros;
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
