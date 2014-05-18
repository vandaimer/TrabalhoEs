
package Controle.acervo;

import Controle.Configurador;
import Visao.visualizadordecartas.VisualizadorDeCartas;

public class ConfiguradorVisualizadorDeCartas implements Configurador<VisualizadorDeCartas> {
    
    @Override
    public void configurar(VisualizadorDeCartas t) {
        t.selecionarUmaCarta(new SelecionarUmaCarta(t));
    }
    
}
