
package Controle.acervo;

import Controle.Configurador;
import Visao.acervo.VitrineDoAcervo;

public class ConfiguradorVitrine implements Configurador<VitrineDoAcervo> {
    
    @Override
    public void configurar(VitrineDoAcervo t) {
        t.selecionarUmaCarta(new SelecionarUmaCarta(t));
    }
    
}
