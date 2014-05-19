
package Visao;

import Controle.Configuravel;
import java.awt.event.ActionListener;


public interface GUIEditorDeBaralho extends Configuravel<GUIEditorDeBaralho>{
 
    public void adicionarUmaCarta(ActionListener a);
    public void removerUmaCarta(ActionListener a);
    public void salvarAlteracoes(ActionListener a);
    public void tornarVisivel(boolean b);
}
