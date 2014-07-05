

package visao;

import controle.Configuravel;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


public interface GUIPortal extends Configuravel<GUIPortal>{
    
    public void autenticarJogador(ActionListener a);
    public void novoJogador(ActionListener a);
    public void editarBaralho(ActionListener a);
    public void visualizarAcervo(ActionListener a);
    public void sair(ActionListener a);

    public void habilitarAutenticarJogador(boolean b);
    public void habilitarNovoJogador(boolean b);
    public void habilitarEditarBaralho(boolean b);
    public void habilitarVisualizarAcervo(boolean b);
    
    public void tornarVisivel(boolean v);
}
