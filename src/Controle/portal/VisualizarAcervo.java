
package Controle.portal;

import Controle.Portal;
import Modelo.Carta;
import Visao.acervo.VitrineDoAcervo;
import Visao.portal.VPortal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class VisualizarAcervo implements  ActionListener{

    private Portal portal;
    private VPortal vportal;

    public VisualizarAcervo(VPortal vportal,Portal portal ) {
        this.portal = portal;
        this.vportal = vportal;
    }
           
    @Override
    public void actionPerformed(ActionEvent e) {  
        VitrineDoAcervo vitrine = vportal.criarVitrine();
        List<Carta> cartas=portal.obterAcervo();
        vitrine.listarCartas(cartas);
    }
    
}
