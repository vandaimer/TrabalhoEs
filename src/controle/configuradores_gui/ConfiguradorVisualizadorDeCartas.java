
package controle.configuradores_gui;

import controle.Configurador;
import controle.gui_visualizador_de_cartas.SelecionarUmaCarta;
import visao.GUIVisualizadorDeCartas;

public class ConfiguradorVisualizadorDeCartas implements Configurador<GUIVisualizadorDeCartas> {

    
    @Override
    public void configurar(GUIVisualizadorDeCartas t) {
        t.selecionarUmaCarta(new SelecionarUmaCarta(t));
        t.tornarVisivel(true);
    }
    
}
