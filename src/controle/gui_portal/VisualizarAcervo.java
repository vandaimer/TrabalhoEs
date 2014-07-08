
package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorVisualizadorDeCartas;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.Portal;
import modelo.jogo.Carta;
import visao.janelas.FormVisualizadorDeCartas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import visao.GUIPortal;


public class VisualizarAcervo implements  ActionListener{

    private Portal portal;
   private GUIPortal gp;

    public VisualizarAcervo(Portal portal, GUIPortal gp) {
        this.portal = portal;
        this.gp = gp;
    }

    
           
    @Override
    public void actionPerformed(ActionEvent e) {  
        
        FormVisualizadorDeCartas vs=new FormVisualizadorDeCartas();
        ConfiguradorVisualizadorDeCartas conf=new ConfiguradorVisualizadorDeCartas();
        List<CartaAbstrata> cartas=portal.obterAcervo();
        vs.listarCartas(cartas);
        vs.aplicarConfiguracao(conf);
        gp.incluir(vs);
    }
    
}
