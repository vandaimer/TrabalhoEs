

package controle.gui_jogo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.jogo.servidor.controleremoto.ControleRemoto;


public class VisualizarPontuacao implements ActionListener{
    
    private ControleRemoto ctr;

    public VisualizarPontuacao(ControleRemoto ctr) {
        this.ctr = ctr;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
