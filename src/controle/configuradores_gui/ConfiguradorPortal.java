package controle.configuradores_gui;

import controle.Configurador;
import controle.gui_portal.AutenticarJogador;
import controle.gui_portal.EditarBaralho;
import controle.gui_portal.NovoJogador;
import controle.gui_portal.ObservadorDoPortal;
import controle.gui_portal.Sair;
import controle.gui_portal.VisualizarAcervo;
import modelo.Portal;
import visao.GUIPortal;

public class ConfiguradorPortal implements Configurador<GUIPortal> {

    private Portal portal;

    public ConfiguradorPortal(Portal portal) {
        this.portal = portal;
    }

    @Override
    public void configurar(GUIPortal v) {

        v.autenticarJogador(new AutenticarJogador(portal));
        v.visualizarAcervo(new VisualizarAcervo(portal));
        v.novoJogador(new NovoJogador(portal));
        v.editarBaralho(new EditarBaralho(portal));
        v.sair(new Sair());
        portal.registrar(new ObservadorDoPortal(portal, v));
        v.tornarVisivel(true);
        
    }
}
