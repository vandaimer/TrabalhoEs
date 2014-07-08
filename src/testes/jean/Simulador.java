package testes.jean;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import modelo.jogo.Carta;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.CartaEfeito;
import modelo.jogo.partida.InformacaoDoTurno;
import modelo.jogo.servidor.controleremoto.ControleRemoto;


import modelo.util.Observador;

public class Simulador implements Observador {

	private ControleRemoto ctr;
	private StringBuilder log;

	public Simulador(ControleRemoto ctr) {
		this.ctr = ctr;
		log = new StringBuilder();
		log.append("meu log: ");
		log.append(this);
		log.append('\n');
	}

	@Override
	public void notificar(Object fonte, Object msg) {

		if ("iniciar_turno".equals(msg)) {
			log.append("Heee posso jogar\n");

			try {
				Random r = new Random();
				Thread.sleep(r.nextInt(5000));
				LinkedList<CartaAbstrata> l = new LinkedList();
				l.add(new Carta("larman", 1, r.nextInt(30), r.nextInt(30), r.nextInt(30)));
				l.add(new CartaEfeito("efeito", 2, r.nextInt(3), r.nextInt(3), r.nextInt(3)));
				l.add(new CartaEfeito("efeito", 3, r.nextInt(3), r.nextInt(3), r.nextInt(3)));

				ctr.jogar(l);
			} catch (Exception e) {
			}

			log.append("joguei\n");
		}



		if ("jogada_realizada".equals(msg)) {
			log.append("minha jogada foi aceita\n");
		}


		if ("atualizar_pontuacao".equals(msg)) {
			log.append("minha pontuacao foi atualizada\n");
		}

		if ("fim_do_jogo".equals(msg)) {
			log.append("O jogo acabou\n");
			System.out.println(log);

		}

	}
}
