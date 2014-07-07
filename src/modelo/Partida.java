package modelo;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Partida extends ObservadoImpl {

    private EstadoDaPartida _estado;
    private int _numDeJogadores;
    private List<Jogador> jogadores = new LinkedList<Jogador>();
    private Map<Jogador, Jogada> mapaJogadas = new Hashtable<Jogador, Jogada>();
    private List<Observador> observadores = new LinkedList<Observador>();
    private int _turnoAtual;
    private ControladorDePartida _ctr;

<<<<<<< HEAD
    


    public Partida(int numDeJogadores) {
=======
    public Partida(int numDeJogadores, ControladorDePartida ctr) {
>>>>>>> 9e912f343e6a9ae557b31a1f343184799d589b8d
        _estado = new AguardandoIniciar();//insere estado inicial
        _numDeJogadores = numDeJogadores;
        _turnoAtual = 0;
        _ctr = ctr;

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
        return _turnoAtual == 10;
    }

    public void sinalizarFimDeJogo() {
        _ctr.notificarFimDeJogo();
    }

    public void adicionarJogador(Jogador j) throws IllegalArgumentException {
        if (jogadores.contains(j)) {
            throw new IllegalArgumentException("Usuario ja inserido na partida.");
        }

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
