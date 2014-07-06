package modelo;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Partida extends ObservadoImpl{

    private EstadoDaPartida _estado;
    private int _numDeJogadores;
    private List<Jogador> jogadores = new LinkedList<Jogador>();
    private Map<Jogador, Jogada> mapaJogadas = new Hashtable<Jogador, Jogada>();
    private List<Observador> observadores = new LinkedList<Observador>();
    int _turnoAtual;

    


    public Partida(int numDeJogadores) {
        _estado = new AguardandoIniciar();//insere estado inicial
        _numDeJogadores = numDeJogadores;
        _turnoAtual = 0;

    }

    public void limparJogadas() {
        mapaJogadas.clear();
    }

    public void verificarJogada(Jogada j) {

    }

    public synchronized void iniciar() {
        _estado.iniciar(this);
    }

    public void incrementarTurno() {
        _turnoAtual++;
    }

    public boolean quantidadeJogadoresValida() {

        return jogadores.size() == _numDeJogadores;
    }

    public boolean fimDeJogo() {
        return _estado.fimDoJogo();
    }

    public void adicionarJogador(Jogador j) throws IllegalArgumentException {
        jogadores.add(j);
    }

    public void adicionarJogada(Jogador jgd, Jogada j) {
        mapaJogadas.put(jgd, j);
    }

    void fixarEstado(EstadoDaPartida e) {
        _estado = e;
    }

    public synchronized void jogar(Jogador jgd, Jogada j) {
        _estado.jogar(this, jgd, j);
    }

    public boolean associacaoCompleta() {
        for (Jogador j : jogadores) {
            if (!(mapaJogadas.containsKey(j))) {
                return false;
            }
        }
        return true;
    }

    
}
