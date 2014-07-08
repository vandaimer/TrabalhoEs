
package controle.gui_jogo;

import javax.swing.JOptionPane;
import modelo.util.Observador;
import visao.GUIJogo;


public class ObservadorDoControleRemoto implements Observador{

    private GUIJogo _gj;

    public ObservadorDoControleRemoto(GUIJogo gj) {
        _gj = gj;
    }
    
    
    @Override
    public void notificar(Object fonte, Object msg) {
        JOptionPane.showMessageDialog(null,"teste: "+ msg);
    }
    
}