package controle.gui_montar_jogada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;
import modelo.jogo.Carta;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.CartaEfeito;
import modelo.jogo.Jogador;
import modelo.jogo.servidor.controleremoto.ControleRemoto;

public class EnviarJogada implements ActionListener {

    private ControleRemoto _ctr;
    private Jogador _jd;

    public EnviarJogada(ControleRemoto ctr, Jogador jd) {
        _ctr = ctr;
        _jd = jd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Random r = new Random();
        LinkedList<CartaAbstrata> l = new LinkedList();
        l.add(new Carta("larman", 1, r.nextInt(30), r.nextInt(30), r.nextInt(30)));
        l.add(new CartaEfeito("efeito", 2, r.nextInt(3), r.nextInt(3), r.nextInt(3)));
        l.add(new CartaEfeito("efeito", 3, r.nextInt(3), r.nextInt(3), r.nextInt(3)));
        
        
       // _ctr.jogar(_jd.obterCartasAtuais());
        _ctr.jogar(l);

    }

}
