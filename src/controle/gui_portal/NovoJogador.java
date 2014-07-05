
package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorNovoJogador;
import modelo.Portal;
import visao.janelas.FormDadosDoJogador;
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
        fautenticador.setVisible(true);
    }

    
}
