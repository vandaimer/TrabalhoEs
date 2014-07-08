package controle.gui_jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import modelo.jogo.Carta;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.CartaEfeito;
import modelo.jogo.Jogador;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import visao.GUIEditorDejogador;

public class EnviarJogada implements ActionListener {

    private ControleRemoto _ctr;
    private Jogador _jd;
    private GUIEditorDejogador _gui;

    public EnviarJogada(ControleRemoto _ctr, Jogador _jd, GUIEditorDejogador _gui) {
        this._ctr = _ctr;
        this._jd = _jd;
        this._gui = _gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        _ctr.jogar(_jd.obterCartasAtuais());

        _gui.fechar();

    }

}
