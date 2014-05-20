
package Controle.configuradores_gui;

import Controle.Configurador;
import Controle.gui_dados_do_jogador.ConfirmaDadosNovoJogoTecla;
import Controle.gui_dados_do_jogador.ConfirmaDadosNovoJogorClick;
import Controle.gui_dados_do_jogador.ConfirmarAutenticacaoPorClick;
import Controle.gui_dados_do_jogador.ConfirmarAutenticacaoPorTecla;
import Controle.gui_dados_do_jogador.QuandoCancelar;
import Controle.gui_dados_do_jogador.QuandoConfirmarDadosNovoJogador;
import Modelo.Portal;
import Visao.GUIDadosDoJogador;

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
