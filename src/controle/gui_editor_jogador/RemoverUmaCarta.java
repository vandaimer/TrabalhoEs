package controle.gui_editor_jogador;

import modelo.jogo.Carta;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogador;
import visao.GUIEditorDejogador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoverUmaCarta implements ActionListener {
    
    private GUIEditorDejogador edj;
    private Jogador jogador;
    
    public RemoverUmaCarta(GUIEditorDejogador edj, Jogador jogador) {
        this.edj = edj;
        this.jogador = jogador;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        CartaAbstrata c = edj.obterCartaSelecionadaDoJogador();
        
        if (c == null) {
            return;
        }
        
        jogador.remover(c);
        edj.listarCartasDoJogador(jogador.obterCartasAtuais());
        edj.exibirMensagem(c.getNome() + " removida do baralho.");
        
    }
    
}
