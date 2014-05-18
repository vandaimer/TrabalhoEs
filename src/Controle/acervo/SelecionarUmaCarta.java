
package Controle.acervo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Carta;
import Visao.acervo.VitrineDoAcervo;

public class SelecionarUmaCarta implements ActionListener {

    private VitrineDoAcervo v;

    public SelecionarUmaCarta(VitrineDoAcervo v) {
        this.v = v;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Carta c = v.obterCartaSelecionada();
        v.mostrar(c);
    }
    
}
