
package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorNovoJogador;
import modelo.jogo.Portal;
import visao.janelas.FormDadosDoJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visao.GUIPortal;


public class NovoJogador implements  ActionListener{
    private Portal portal;
    private GUIPortal gp;

    public NovoJogador(Portal portal, GUIPortal gp) {
        this.portal = portal;
        this.gp = gp;
    }
    

    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        ConfiguradorNovoJogador conf = new ConfiguradorNovoJogador(portal);
        FormDadosDoJogador fautenticador = new FormDadosDoJogador("Cadastro de Jogador");
        fautenticador.aplicarConfiguracao(conf);
        gp.incluir(fautenticador);
        fautenticador.setVisible(true);
        
    }

    
}
