
package Controle.portal;

import Controle.Configurador;
import Modelo.Portal;
import Visao.portal.VPortal;


public class ConfiguradorPortal implements Configurador<VPortal> {
    private Portal portal;

    public ConfiguradorPortal(Portal portal) {
        this.portal = portal;
    }
    
    
    
    @Override
    public void configurar(VPortal v){
    v.autenticarJogador(new AutenticarJogador(v, portal));
    v.visualizarAcervo(new VisualizarAcervo(v, portal));
    v.editarBaralho(new VisualizarAcervo(v, portal));
    }
}
