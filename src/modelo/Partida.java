package modelo;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Partida implements Observado {

	private EstadoDaPartida _estado;
	private int _numDeJogadores;
	private List<Jogador> jogadores = new LinkedList<Jogador>();   
	private Map<Jogador, Jogada> mapaJogadas;
	int _turnoAtual;

	public Partida(int numDeJogadores) {    	
		_estado = null;//insere estado inicial
		_numDeJogadores = numDeJogadores;
		_turnoAtual = 0;

	}
	public void verificarJogada(Jogada j){
		//verificar jogada
		try{
			ValidacaoMao v = new ValidacaoMao();
			

		}catch(ExcecaoQuebraDeRegrasDoBaralho e){
			
		}

	}

	public synchronized void iniciar() {    	
	}
	public void incrementarTurno(){
		_turnoAtual++;
	}
	public boolean quantidadeJogadoresValida(){

		return jogadores.size() != _numDeJogadores;
	}
	public boolean fimDeJogo() {
		return _estado.fimDoJogo();
	}

	public void adicionarJogador(Jogador j) throws IllegalArgumentException {
		jogadores.add(j);
	}
	public void adicionarJogada(Jogador jgd, Jogada j){
		mapaJogadas.put(jgd, j);    	
	}

	void fixarEstado(EstadoDaPartida e) {
		_estado = e;
	}

	public synchronized void jogar(Jogador jgd, Jogada j) {
		_estado.jogar(this, jgd, j);
	}
	public boolean associacaoCompleta(){
		
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
