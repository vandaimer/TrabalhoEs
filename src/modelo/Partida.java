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
    
    public Partida(int numDeJogadores, ControladorDePartida ctr) {
        
        _estado = new IniciandoTurno();//insere estado inicial
        _numDeJogadores = numDeJogadores;
        _turnoAtual = 0;
        _ctr = ctr;
        
    }
    
    public void limparJogadas() {
        mapaJogadas.clear();
    }
    
    public void verificarJogada(Jogada j) {
        
    }
    
    public boolean realizouJogada(Jogador j) {
        return mapaJogadas.containsKey(j);
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
        return _turnoAtual == 2;
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

    public boolean contemJogador(List<Jogador> reconhecidos) {
        if (jogadores.size() != reconhecidos.size()) {
            return false;
        }
        return jogadores.containsAll(reconhecidos);
        
    }
    
    public void sinalizarReconhecimento(Jogador j) {
        _estado.verificandoReconhecimento(this, j);
    }
    
}
