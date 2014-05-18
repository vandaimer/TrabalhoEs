
package Controle.autenticador;

import Modelo.Portal;
import Visao.autenticador.VAutenticador;
import Controle.Configurador;

public class ConfiguradorAutenticador implements Configurador<VAutenticador>{
private Portal portal;

    public ConfiguradorAutenticador(Portal portal) {
        this.portal = portal;
    }

    @Override
    public void configurar(VAutenticador t) {
    
    }


    
}
