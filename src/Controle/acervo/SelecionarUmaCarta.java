
package Controle.acervo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Carta;
import Visao.visualizadordecartas.VisualizadorDeCartas;

public class SelecionarUmaCarta implements ActionListener {

    private VisualizadorDeCartas v;

    public SelecionarUmaCarta(VisualizadorDeCartas v) {
        this.v = v;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Carta c = v.obterCartaSelecionada();
        v.mostrar(c);
    }
    
}
