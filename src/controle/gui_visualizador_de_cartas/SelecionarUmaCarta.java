package controle.gui_visualizador_de_cartas;

import modelo.jogo.Carta;
import visao.GUIVisualizadorDeCartas;
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
