

package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorEditorDeJogador;
import modelo.jogo.Portal;
import visao.janelas.FormEditorJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import visao.GUIPortal;


public class EditarBaralho implements ActionListener{
private Portal portal;
private GUIPortal gp;

    public EditarBaralho(Portal portal, GUIPortal gp) {
        this.portal = portal;
        this.gp = gp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        FormEditorJogador form=new FormEditorJogador();
        ConfiguradorEditorDeJogador conf=new ConfiguradorEditorDeJogador(portal);
        form.aplicarConfiguracao(conf);
        gp.incluir(form);
    }
    
    
}
