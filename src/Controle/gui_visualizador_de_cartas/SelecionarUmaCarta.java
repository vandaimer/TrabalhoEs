package Controle.gui_visualizador_de_cartas;

import Modelo.Carta;
import Visao.GUIVisualizadorDeCartas;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionarUmaCarta implements ListSelectionListener {

    private GUIVisualizadorDeCartas v;

    public SelecionarUmaCarta(GUIVisualizadorDeCartas v) {
        this.v = v;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Carta c = v.obterCartaSelecionada();
        v.mostrar(c);

    }

}
