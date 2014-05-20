package Controle.gui_editor_jogador;

import Modelo.Carta;
import Visao.GUIEditorDejogador;
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
