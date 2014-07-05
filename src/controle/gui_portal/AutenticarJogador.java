package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorAutenticador;
import modelo.Portal;
import visao.janelas.FormDadosDoJogador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AutenticarJogador implements ActionListener{
 
    private Portal portal;

    public AutenticarJogador( Portal portal) {
        this.portal = portal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConfiguradorAutenticador conf = new ConfiguradorAutenticador(portal);
        FormDadosDoJogador fautenticador = new FormDadosDoJogador();
        fautenticador.aplicarConfiguracao(conf);
    }
}