
package Controle.configuradores_gui;

import Controle.Configurador;
import Controle.gui_visualizador_de_cartas.SelecionarUmaCarta;
import Visao.GUIVisualizadorDeCartas;

public class ConfiguradorVisualizadorDeCartas implements Configurador<GUIVisualizadorDeCartas> {

    
    @Override
    public void configurar(GUIVisualizadorDeCartas t) {
        t.selecionarUmaCarta(new SelecionarUmaCarta(t));
        t.tornarVisivel(true);
    }
    
}
