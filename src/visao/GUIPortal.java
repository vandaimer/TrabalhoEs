

package visao;

import controle.Configuravel;

import java.awt.event.ActionListener;



public interface GUIPortal extends Configuravel<GUIPortal>{
    
    public void autenticarJogador(ActionListener a);
    public void novoJogador(ActionListener a);
    public void editarBaralho(ActionListener a);
    public void visualizarAcervo(ActionListener a);
    public void sair(ActionListener a);
    public void conectarAoOponente(ActionListener a);
    public void criarPartida(ActionListener a);

    public void habilitarConectarAoOponente(boolean b);
    public void habilitarCriarPartida(boolean b);
    public void habilitarAutenticarJogador(boolean b);
    public void habilitarNovoJogador(boolean b);
    public void habilitarEditarBaralho(boolean b);
    public void habilitarVisualizarAcervo(boolean b);
    
    public String mostrarJanelaDeEntradaSimples(String msg);
    public void tornarVisivel(boolean v);
    public void mostrarMensagem(String m);
}
