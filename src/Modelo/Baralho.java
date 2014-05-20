package Modelo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Baralho {

	private List<Carta> lista = new LinkedList<>();
	

	public Baralho() {
	}

	public Baralho(Baralho b) {
		lista = b.listarCartas();
	}

	public void adicionar(Carta c) {
		lista.add(new Carta(c));

	}

	public void remover(Carta c) {
		lista.remove(c);

	}

	public List<ErroDeValidacao> validar() {

		List<ErroDeValidacao> listaErros = new LinkedList<>();
		
		if (quantidadeCartas() < 40) {

			listaErros.add(ErroDeValidacao.NUM_CARTAS_INSUFICIENTE);
		}

		if (quantidadeCartas() > 60) {

			listaErros.add(ErroDeValidacao.NUM_CARTAS_EXCEDENTE);
		}

		if (verificaRepeticao()) {
			listaErros.add(ErroDeValidacao.CARTAS_REPETIDAS);
		}

		return listaErros;

	}

	private int quantidadeCartas() {
		return lista.size();
	}

	public boolean verificaRepeticao() {

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
			if (mapeamentoQuantidade.get(c) > 2) {
				existeRepeticao = true;
				break;
			}
		}

		return existeRepeticao;
	}

	// seria esse o método pra obter as cartas?
	public List<Carta> listarCartas() {
		List<Carta> cartas = new LinkedList<>();

		for (Carta c : lista) {

			cartas.add(new Carta(c));

		}
		/* Deve retornar uma copia da lista do baralho */
		return cartas;
	}

	public void montarBaralho(List<Carta> c) {
		for (Carta i : c) {

			lista.add(new Carta(i));

		}
	}

	
}
