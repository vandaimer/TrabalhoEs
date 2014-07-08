package controle.configuradores_gui;

import controle.Configurador;
import controle.gui_editor_jogador.AdicionarUmaCarta;
import controle.gui_editor_jogador.QuandoSelecionarUmaCartaDoAcervo;
import controle.gui_editor_jogador.QuandoSelecionarUmaDoJogador;
import controle.gui_editor_jogador.RemoverUmaCarta;
import controle.gui_jogo.EnviarJogada;
import java.util.List;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogador;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import visao.GUIEditorDejogador;

public class ConfiguradorMontarJogada implements Configurador<GUIEditorDejogador> {
    
    private List<CartaAbstrata> cartasDoJogador;
    private ControleRemoto ctr;

    public ConfiguradorMontarJogada(List<CartaAbstrata> cartasDoJogador, ControleRemoto ctr) {
        this.cartasDoJogador = cartasDoJogador;
        this.ctr = ctr;
    }

    @Override
    public void configurar(GUIEditorDejogador t) {
        Jogador _jd=new Jogador();
        t.listarCartasDoAcervo(cartasDoJogador);
        t.adicionarUmaCarta(new AdicionarUmaCarta(t, _jd));
        t.removerUmaCarta(new RemoverUmaCarta(t, _jd));
        t.salvarAlteracoes(new EnviarJogada(ctr, _jd,t));
        t.quandoSelecionarUmaCartaDoAcervo(new QuandoSelecionarUmaCartaDoAcervo(t));
        t.quandoSelecionarUmaCartaDoJogador(new QuandoSelecionarUmaDoJogador(t));
        t.tornarVisivel(true);

    }

}
