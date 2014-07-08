package controle.gui_montar_jogada;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        _ctr.jogar(_jd.obterCartasAtuais());

    }

}
