package Controle.gui_portal;

import Modelo.Observado;
import Modelo.Observador;
import Modelo.Portal;
import Visao.GUIPortal;

public class ObservadorDoPortal implements Observador {

    private Portal portal;
    private GUIPortal guiportal;

    public ObservadorDoPortal(Portal portal, GUIPortal guiportal) {
        this.portal = portal;
        this.guiportal = guiportal;
    }

    @Override
    public void notificar(Observado fonte, Object msg) {

        if (portal.equals(fonte)) {

            if ("usuario_autenticado".equals(msg)) {

                guiportal.habilitarAutenticarJogador(false);
                guiportal.habilitarNovoJogador(false);
                guiportal.habilitarEditarBaralho(true);
                guiportal.habilitarVisualizarAcervo(true);
            }

            if ("usuario_nao_autenticado".equals(msg)) {
                guiportal.habilitarAutenticarJogador(true);
                guiportal.habilitarEditarBaralho(false);
                guiportal.habilitarNovoJogador(true);
                guiportal.habilitarVisualizarAcervo(true);

            }
        }

    }

}
