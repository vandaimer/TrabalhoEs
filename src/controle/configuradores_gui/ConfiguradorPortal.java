package controle.configuradores_gui;

import controle.Configurador;
import controle.gui_portal.AutenticarJogador;
import controle.gui_portal.ConectarAoOponente;
import controle.gui_portal.CriarPartida;
import controle.gui_portal.EditarBaralho;
import controle.gui_portal.NovoJogador;
import controle.gui_portal.ObservadorDoPortal;
import controle.gui_portal.Sair;
import controle.gui_portal.VisualizarAcervo;
import modelo.jogo.Portal;
import visao.GUIPortal;

public class ConfiguradorPortal implements Configurador<GUIPortal> {

    private Portal portal;

    public ConfiguradorPortal(Portal portal) {
        this.portal = portal;
    }

    @Override
    public void configurar(GUIPortal v) {

        v.autenticarJogador(new AutenticarJogador(portal,v));
        v.conectarAoOponente(new ConectarAoOponente(v, portal));
        v.criarPartida(new CriarPartida(portal, v));
        v.visualizarAcervo(new VisualizarAcervo(portal,v));
        v.novoJogador(new NovoJogador(portal,v));
        v.editarBaralho(new EditarBaralho(portal,v));
        v.sair(new Sair());
        portal.registrar(new ObservadorDoPortal(portal, v));

        v.habilitarAutenticarJogador(true);
        v.habilitarEditarBaralho(false);
        v.habilitarNovoJogador(true);
        v.habilitarVisualizarAcervo(true);
        v.habilitarCriarPartida(false);
        v.habilitarConectarAoOponente(false);

        v.tornarVisivel(true);

    }
}
