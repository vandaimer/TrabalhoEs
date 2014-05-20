
package Controle.configuradores_gui;

import Controle.Configurador;
import Controle.gui_editor_jogador.AdicionarUmaCarta;
import Controle.gui_editor_jogador.QuandoSelecionarUmaCartaDoAcervo;
import Controle.gui_editor_jogador.QuandoSelecionarUmaDoJogador;
import Controle.gui_editor_jogador.RemoverUmaCarta;
import Controle.gui_editor_jogador.SalvarAlteracoes;
import Modelo.Jogador;
import Modelo.Portal;
import Visao.GUIEditorDejogador;


public class ConfiguradorEditorDeJogador implements Configurador<GUIEditorDejogador>{
private Portal portal;

    public ConfiguradorEditorDeJogador(Portal portal) {
        this.portal = portal;
    }
    

    @Override
    public void configurar(GUIEditorDejogador t) {
        Jogador jgd=portal.obterJogadorLogado();
        
        t.listarCartasDoAcervo(portal.obterAcervo());
        t.listarCartasDoJogador(jgd.obterCartasAtuais());
        t.adicionarUmaCarta(new AdicionarUmaCarta(t, jgd));
        t.removerUmaCarta(new RemoverUmaCarta(t, jgd));
        t.salvarAlteracoes(new SalvarAlteracoes(portal, jgd));
        t.quandoSelecionarUmaCartaDoAcervo(new QuandoSelecionarUmaCartaDoAcervo(t));
        t.quandoSelecionarUmaCartaDoJogador(new QuandoSelecionarUmaDoJogador(t));
        t.tornarVisivel(true);
    }
    
}
