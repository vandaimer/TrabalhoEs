
package Controle.configuradores_gui;

import Modelo.Portal;
import Visao.GUIDadosDoJogador;
import Controle.Configurador;
import Controle.gui_dados_do_jogador.QuandoCancelar;
import Controle.gui_dados_do_jogador.QuandoConfirmarDadosDeAutenticacao;

public class ConfiguradorAutenticador implements Configurador<GUIDadosDoJogador> {

    private Portal portal;
    
    public ConfiguradorAutenticador(Portal portal) {
        this.portal = portal;
    }
    
    @Override
    public void configurar(GUIDadosDoJogador t) {
        t.habilitarConfirmarDados(true);
        t.quandoConfirmarDados(new QuandoConfirmarDadosDeAutenticacao(portal, t));
        t.quandoCancelar(new QuandoCancelar(t));
        
    }
    
}
