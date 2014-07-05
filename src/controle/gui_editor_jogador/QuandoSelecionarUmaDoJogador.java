package controle.gui_editor_jogador;

import modelo.Carta;
import visao.GUIEditorDejogador;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class QuandoSelecionarUmaDoJogador implements ListSelectionListener {
    
    private GUIEditorDejogador gui;
    
    public QuandoSelecionarUmaDoJogador(GUIEditorDejogador gui) {
        this.gui = gui;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Carta c = gui.obterCartaSelecionadaDoJogador();
        gui.mostrarCartaDoJogador(c);
    }
    
}