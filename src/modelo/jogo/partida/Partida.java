package modelo.jogo.partida;

import modelo.jogo.partida.estados.AguardandoReconhecimento;
import modelo.jogo.partida.estados.EstadoDaPartida;

import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.util.ObservadoImpl;
import modelo.util.Observador;

public class Partida extends ObservadoImpl {

	private EstadoDaPartida _estado;
	private int _numDeJogadores;
	private List<Jogador> jogadores = new LinkedList<Jogador>();
	private Map<Jogador, Jogada> mapaJogadas = new Hashtable<Jogador, Jogada>();
	private List<Observador> observadores = new LinkedList<Observador>();
	private int _turnoAtual;
	private ControladorDePartida _ctr;
	private Map<Jogador,Integer> pontuacao = new Hashtable<Jogador,Integer>();

	public Partida(int numDeJogadores, ControladorDePartida ctr) {

		_estado = new AguardandoReconhecimento();//insere estado inicial
		_numDeJogadores = numDeJogadores;
		_turnoAtual = 0;
		_ctr = ctr;
		//inicializarPontuacao();

	}

	public void limparJogadas() {
		mapaJogadas.clear();
	}

	public void verificarJogada(Jogada j) {

	}

	public boolean realizouJogada(Jogador j) {
		return mapaJogadas.containsKey(j);
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
		pontuacao.put(j, new Integer(0));

	}

	public void adicionarJogada(Jogador jgd, Jogada j) {
		mapaJogadas.put(jgd, j);
	}

	public void fixarEstado(EstadoDaPartida e) {
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

	public synchronized void sinalizarReconhecimento(Jogador j) {
		_estado.verificandoReconhecimento(this, j);
	}
	public void inicializarPontuacao(){
		for (Jogador j : jogadores) {    		
			pontuacao.put(j, new Integer(0));
		}
	}
	public void verificarPontuacao(){

		LinkedList<Jogada> rank = new LinkedList<Jogada>(mapaJogadas.values());    	
		Collections.sort(rank);
		Jogada jd = rank.getLast();
		Integer valor = pontuacao.get(jd.getJogador())+1;
		pontuacao.put(jd.getJogador(),valor);
	}
	public Map<Jogador,Integer> getPontuacao(){
		return pontuacao;
	}
	public Map<Jogador,Jogada> getJogadaTurno(){
		return mapaJogadas;
	}
	public List<InformacaoDoTurno> obterInformacaoTurno(){
		List<InformacaoDoTurno> inf = new LinkedList<>();
		
		for (Jogador jogador : jogadores) {
			inf.add(new InformacaoDoTurno(mapaJogadas.get(jogador),pontuacao.get(jogador),_turnoAtual));
		}
		
		return inf;
		
	}
	


}

