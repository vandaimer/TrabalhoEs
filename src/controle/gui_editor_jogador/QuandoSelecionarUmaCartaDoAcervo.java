
package controle.gui_editor_jogador;


import modelo.jogo.CartaAbstrata;
import visao.GUIEditorDejogador;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class QuandoSelecionarUmaCartaDoAcervo implements ListSelectionListener {

    private GUIEditorDejogador gui;
    
    public QuandoSelecionarUmaCartaDoAcervo(GUIEditorDejogador gui) {
        this.gui = gui;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        CartaAbstrata c = gui.obterCartaSelecionadaDoAcervo();
        gui.mostrarCartaDoAcervo(c);
        
    }
    
}
