
package controle.configuradores_gui;

import controle.Configurador;
import controle.gui_dados_do_jogador.ConfirmaDadosNovoJogoTecla;
import controle.gui_dados_do_jogador.ConfirmaDadosNovoJogorClick;
import controle.gui_dados_do_jogador.ConfirmarAutenticacaoPorClick;
import controle.gui_dados_do_jogador.ConfirmarAutenticacaoPorTecla;
import controle.gui_dados_do_jogador.QuandoCancelar;
import controle.gui_dados_do_jogador.QuandoConfirmarDadosNovoJogador;
import modelo.Portal;
import visao.GUIDadosDoJogador;

public class ConfiguradorNovoJogador implements Configurador<GUIDadosDoJogador> {

    private Portal portal;
    
    public ConfiguradorNovoJogador(Portal portal) {
        this.portal = portal;
    }
    
    @Override
    public void configurar(GUIDadosDoJogador t) {
        t.habilitarConfirmarDados(true);
        t.quandoCancelar(new QuandoCancelar(t));
        t.quandoConfirmarDadosClick(new ConfirmaDadosNovoJogorClick(portal, t));
        t.quandoConfirmarDadosTecla(new ConfirmaDadosNovoJogoTecla(portal, t));
        t.tornarVisivel(true);
    }
    
}
