
package Controle.gui_portal;

import Controle.configuradores_gui.ConfiguradorNovoJogador;
import Modelo.Portal;
import Visao.janelas.FormDadosDoJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NovoJogador implements  ActionListener{
    Portal portal;

    public NovoJogador(Portal portal) {
        this.portal = portal;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        ConfiguradorNovoJogador conf = new ConfiguradorNovoJogador(portal);
        FormDadosDoJogador fautenticador = new FormDadosDoJogador();
        fautenticador.aplicarConfiguracao(conf);
    
    }

    
}
