package controle.configuradores_gui;

import controle.Configurador;
import controle.gui_jogo.MontarJogada;
import controle.gui_jogo.ObservadorDoControleRemoto;
import controle.gui_jogo.VisualizarPontuacao;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import visao.GUIJogo;

public class ConfiguradorGuiJogo implements Configurador<GUIJogo> {

    private ControleRemoto ctr;

    public ConfiguradorGuiJogo(ControleRemoto ctr) {
        this.ctr = ctr;
    }

    @Override
    public void configurar(GUIJogo t) {
        t.quandorMontarJogada(new MontarJogada(ctr));
        t.quandorVisualizarPontuacao(new VisualizarPontuacao(ctr));
        ctr.registrar(new ObservadorDoControleRemoto(t));
        t.tornarVisivel(true);
        ctr.iniciar();
    }

}
