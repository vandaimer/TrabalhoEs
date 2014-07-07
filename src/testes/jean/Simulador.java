package testes.jean;

import java.util.LinkedList;
import java.util.Random;
import modelo.Carta;
import modelo.ControleRemoto;
import modelo.Observado;
import modelo.Observador;

public class Simulador implements Observador {

    private ControleRemoto ctr;
    private boolean fim = false;

    public Simulador(ControleRemoto ctr) {
        this.ctr = ctr;
    }

    public boolean fim() {
        return fim;
    }

    @Override
    public void notificar(Observado fonte, Object msg) {

        if ("iniciar_turno".equals(msg)) {
            
            System.out.println("Heee posso jogar");
            try {
                Random r = new Random();
                Thread.sleep(r.nextInt(5000));
                ctr.jogar(new LinkedList<Carta>());
            } catch (Exception e) {
            }

            System.out.println("joguei");
        }

        if ("jogada_realizada".equals(msg)) {
            System.out.println("minha jogada foi aceita");
        }

        if ("atualizar_pontuacao".equals(msg)) {
            System.out.println("minha pontuacao foi atualizada");
        }

        if ("fim_do_jogo".equals(msg)) {
            System.out.println("O jogo acabou");
            fim = true;
        }

    }
}