package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorAutenticador;
import modelo.jogo.Portal;
import visao.janelas.FormDadosDoJogador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import visao.GUIPortal;

public class AutenticarJogador implements ActionListener{
 
    private Portal portal;
    private GUIPortal gp;

    public AutenticarJogador(Portal portal, GUIPortal gp) {
        this.portal = portal;
        this.gp = gp;
    }
    

    

    @Override
    public void actionPerformed(ActionEvent e) {
        ConfiguradorAutenticador conf = new ConfiguradorAutenticador(portal);
        FormDadosDoJogador fautenticador = new FormDadosDoJogador("Atenticador de Jogador");
        fautenticador.aplicarConfiguracao(conf);
        gp.incluir(fautenticador);
    }
}