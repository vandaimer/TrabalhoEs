package controle.gui_jogo;

import controle.configuradores_gui.ConfiguradorMontarJogada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import visao.GUIPortal;
import visao.janelas.FormEditorJogador;

public class MontarJogada implements ActionListener {
    
    private ControleRemoto ctr;
    private GUIPortal gp;

    public MontarJogada(ControleRemoto ctr, GUIPortal gp) {
        this.ctr = ctr;
        this.gp = gp;
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        FormEditorJogador f = new FormEditorJogador("Baralho Jogada", "Baralho do Jogador", "Enviar Jogada");
        f.aplicarConfiguracao(new ConfiguradorMontarJogada(ctr.baralhoDoJogador(), ctr));
        gp.incluir(f);
    }
    
}
