
package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorVisualizadorDeCartas;
import modelo.Portal;
import modelo.Carta;
import visao.janelas.FormVisualizadorDeCartas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class VisualizarAcervo implements  ActionListener{

    private Portal portal;
   

    public VisualizarAcervo(Portal portal ) {
        this.portal = portal;
     
    }
           
    @Override
    public void actionPerformed(ActionEvent e) {  
        
        FormVisualizadorDeCartas vs=new FormVisualizadorDeCartas();
        ConfiguradorVisualizadorDeCartas conf=new ConfiguradorVisualizadorDeCartas();
        vs.aplicarConfiguracao(conf);
        List<Carta> cartas=portal.obterAcervo();
        vs.listarCartas(cartas);
        
    }
    
}
