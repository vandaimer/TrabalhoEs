package controle.configuradores_gui;

import controle.Configurador;
import controle.gui_jogo.MontarJogada;
import controle.gui_jogo.ObservadorDoControleRemoto;
import controle.gui_jogo.VisualizarPontuacao;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import visao.GUIJogo;
import visao.GUIPortal;

public class ConfiguradorGuiJogo implements Configurador<GUIJogo> {

    private ControleRemoto ctr;
    private GUIPortal gp;

    public ConfiguradorGuiJogo(ControleRemoto ctr, GUIPortal gp) {
        this.ctr = ctr;
        this.gp = gp;
    }
    
    

    @Override
    public void configurar(GUIJogo t) {
        t.quandorMontarJogada(new MontarJogada(ctr,gp));
        t.quandorVisualizarPontuacao(new VisualizarPontuacao(ctr));
        ctr.registrar(new ObservadorDoControleRemoto(t, ctr, gp));
        t.tornarVisivel(true);
        ctr.iniciar();
    }

}
