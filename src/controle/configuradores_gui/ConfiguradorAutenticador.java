
package controle.configuradores_gui;

import modelo.jogo.Portal;
import visao.GUIDadosDoJogador;
import controle.Configurador;
import controle.gui_dados_do_jogador.ConfirmarAutenticacaoPorClick;
import controle.gui_dados_do_jogador.ConfirmarAutenticacaoPorTecla;
import controle.gui_dados_do_jogador.QuandoCancelar;
import controle.gui_dados_do_jogador.QuandoConfirmarDadosDeAutenticacao;

public class ConfiguradorAutenticador implements Configurador<GUIDadosDoJogador> {

    private Portal portal;
    
    public ConfiguradorAutenticador(Portal portal) {
        this.portal = portal;
    }
    
    @Override
    public void configurar(GUIDadosDoJogador t) {
        t.habilitarConfirmarDados(true);
        t.quandoConfirmarDadosClick(new ConfirmarAutenticacaoPorClick(portal, t));
        t.quandoPressionarTeclaConfirmacao( new ConfirmarAutenticacaoPorTecla(portal, t));
        t.quandoCancelar(new QuandoCancelar(t));
        t.tornarVisivel(true);
        
    }
    
}
