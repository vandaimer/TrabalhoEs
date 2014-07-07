
package visao;

import controle.Configuravel;
import modelo.jogo.CartaAbstrata;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionListener;


public interface GUIEditorDejogador extends Configuravel<GUIEditorDejogador>{
 
    public void adicionarUmaCarta(ActionListener a);
    public void removerUmaCarta(ActionListener a);
    public void listarCartasDoJogador(List<CartaAbstrata> j);
    public void listarCartasDoAcervo(List<CartaAbstrata> j);
    public void quandoSelecionarUmaCartaDoAcervo(ListSelectionListener ls);
    public void quandoSelecionarUmaCartaDoJogador(ListSelectionListener ls);
    public CartaAbstrata obterCartaSelecionadaDoAcervo();
    public CartaAbstrata obterCartaSelecionadaDoJogador();
    public void mostrarCartaDoAcervo(CartaAbstrata c);
    public void mostrarCartaDoJogador(CartaAbstrata c);
    public void salvarAlteracoes(ActionListener a);
    public void exibirMensagem(String msg);
    public void tornarVisivel(boolean b);
}
