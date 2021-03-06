package controle.gui_portal;

import modelo.util.Observado;
import modelo.util.Observador;
import modelo.jogo.Portal;
import visao.GUIPortal;

public class ObservadorDoPortal implements Observador {

    private Portal portal;
    private GUIPortal guiportal;

    public ObservadorDoPortal(Portal portal, GUIPortal guiportal) {
        this.portal = portal;
        this.guiportal = guiportal;
    }

    @Override
    public void notificar(Object fonte, Object msg) {

        if (portal.equals(fonte)) {

            if ("usuario_autenticado".equals(msg)) {

                guiportal.habilitarAutenticarJogador(false);
                guiportal.habilitarNovoJogador(false);
                guiportal.habilitarEditarBaralho(true);
                guiportal.habilitarVisualizarAcervo(true);
                guiportal.habilitarCriarPartida(true);
                guiportal.habilitarConectarAoOponente(true);
            }

            if ("usuario_nao_autenticado".equals(msg)) {
                guiportal.habilitarAutenticarJogador(true);
                guiportal.habilitarEditarBaralho(false);
                guiportal.habilitarNovoJogador(true);
                guiportal.habilitarVisualizarAcervo(true);
                guiportal.habilitarCriarPartida(false);
                guiportal.habilitarConectarAoOponente(false);

            }
        }

    }

}
