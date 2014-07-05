package controle.gui_dados_do_jogador;

import visao.GUIDadosDoJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuandoCancelar implements ActionListener {

    private GUIDadosDoJogador aut;

    public QuandoCancelar(GUIDadosDoJogador aut) {
        this.aut = aut;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        aut.fechar();
    }

}
