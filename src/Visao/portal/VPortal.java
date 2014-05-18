

package Visao.portal;

import Controle.Configuravel;
import Modelo.Portal;
import Controle.portal.EditarBaralho;
import Visao.visualizadordecartas.VisualizadorDeCartas;
import java.awt.event.ActionListener;


public interface VPortal extends Configuravel<VPortal>{
    
    public void autenticarJogador(Portal p);
    public void autenticarJogador(ActionListener a);
    public void editarBaralho(ActionListener a);
    public EditarBaralho criarEditorDeBaralho(Portal p);
    public VisualizadorDeCartas visualizadorDeCartas();
    public void visualizarAcervo(ActionListener a);
    
}
