

package Visao.portal;

import Controle.Configuravel;
import Modelo.Portal;
import Controle.portal.EditarBaralho;
import Visao.acervo.VitrineDoAcervo;
import java.awt.event.ActionListener;


public interface VPortal extends Configuravel<VPortal>{
    
    public void autenticarJogador(Portal p);
    public void autenticarJogador(ActionListener a);
    public void editarBaralho(ActionListener a);
    public EditarBaralho criarEditorDeBaralho(Portal p);
    public VitrineDoAcervo criarVitrine();
    public void visualizarAcervo(ActionListener a);
    
}
