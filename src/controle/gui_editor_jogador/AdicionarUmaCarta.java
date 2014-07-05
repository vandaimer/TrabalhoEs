package controle.gui_editor_jogador;

import modelo.Carta;
import modelo.Jogador;
import visao.GUIEditorDejogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdicionarUmaCarta implements ActionListener {

    private GUIEditorDejogador edj;
    private Jogador jogador;

    public AdicionarUmaCarta(GUIEditorDejogador edj, Jogador jogador) {
        this.edj = edj;
        this.jogador = jogador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Carta c = edj.obterCartaSelecionadaDoAcervo();
        if (c == null) {
            return;
        }

        jogador.adicionarCarta(c);
        edj.listarCartasDoJogador(jogador.obterCartasAtuais());
        edj.exibirMensagem(c + " adicionada ao baralho.");

    }

}
