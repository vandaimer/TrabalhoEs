

package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorEditorDeJogador;
import modelo.jogo.Portal;
import visao.janelas.FormEditorJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditarBaralho implements ActionListener{
private Portal portal;

    public EditarBaralho(Portal portal) {
        this.portal = portal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        FormEditorJogador form=new FormEditorJogador();
        ConfiguradorEditorDeJogador conf=new ConfiguradorEditorDeJogador(portal);
        form.aplicarConfiguracao(conf);
    }
    
    
}
