package Controle.configuradores_gui;

import Controle.Configurador;
import Controle.gui_portal.AutenticarJogador;
import Controle.gui_portal.EditarBaralho;
import Controle.gui_portal.NovoJogador;
import Controle.gui_portal.ObservadorDoPortal;
import Controle.gui_portal.Sair;
import Controle.gui_portal.VisualizarAcervo;
import Modelo.Portal;
import Visao.GUIPortal;

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
