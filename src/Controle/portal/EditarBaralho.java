

package Controle.portal;

import Controle.Portal;
import Visao.portal.VPortal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditarBaralho implements ActionListener{
private VPortal vportal;
private Portal portal;

    public EditarBaralho(VPortal vportal, Portal portal) {
        this.vportal = vportal;
        this.portal = portal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    vportal.criarEditorDeBaralho(portal);
    }
    
    
}
