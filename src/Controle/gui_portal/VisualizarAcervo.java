
package Controle.gui_portal;

import Controle.configuradores_gui.ConfiguradorVisualizadorDeCartas;
import Modelo.Portal;
import Modelo.Carta;
import Visao.janelas.FormVisualizadorDeCartas;
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
