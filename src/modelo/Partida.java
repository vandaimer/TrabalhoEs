package modelo;

import java.util.LinkedList;
import java.util.List;

public class Partida implements Observado {

    private EstadoDaPartida _estado;
    private int _numDeJogadores;
    private List<Jogador> jogadores = new LinkedList<Jogador>();
    private boolean _fimJogo_teste = false;

    public Partida(int numDeJogadores) {
        _estado = null;//insere estado inicial
        _numDeJogadores = numDeJogadores;

    }

    public void iniciar() {

        if (jogadores.size() != _numDeJogadores) {
            notificarObservadores("fim_de_jogo");
            _fimJogo_teste = true;
        }

    }

    public boolean fimDeJogo() {
        return _fimJogo_teste;
    }

    public void adicionarJogador(Jogador j) throws IllegalArgumentException {
    }

    void fixarEstado(EstadoDaPartida e) {
        _estado = e;
    }

    public synchronized void jogar(Jogador jgd, Jogada j) {
        _estado.jogar(this, jgd, j);
    }

    public synchronized void comprar(Jogador jgd, Baralho b) {
        _estado.comprar(this, jgd, b);
    }

    @Override
    public void registrar(Observador o) {

    }

    @Override
    public void remover(Observador o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notificarObservadores(Object msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
