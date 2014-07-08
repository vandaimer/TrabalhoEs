package controle.gui_jogo;

import controle.configuradores_gui.ConfiguradorMontarJogada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import visao.janelas.FormEditorJogador;

public class MontarJogada implements ActionListener {
    
    private ControleRemoto ctr;
    
    public MontarJogada(ControleRemoto ctr) {
        this.ctr = ctr;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        FormEditorJogador f = new FormEditorJogador("Baralho Jogada", "Baralho do jogador", "Enviar jogada");
        f.aplicarConfiguracao(new ConfiguradorMontarJogada(ctr.baralhoDoJogador(), ctr));
    }
    
}
