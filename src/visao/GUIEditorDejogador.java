
package visao;

import controle.Configuravel;
import modelo.jogo.Carta;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionListener;


public interface GUIEditorDejogador extends Configuravel<GUIEditorDejogador>{
 
    public void adicionarUmaCarta(ActionListener a);
    public void removerUmaCarta(ActionListener a);
    public void listarCartasDoJogador(List<Carta> j);
    public void listarCartasDoAcervo(List<Carta> j);
    public void quandoSelecionarUmaCartaDoAcervo(ListSelectionListener ls);
    public void quandoSelecionarUmaCartaDoJogador(ListSelectionListener ls);
    public Carta obterCartaSelecionadaDoAcervo();
    public Carta obterCartaSelecionadaDoJogador();
    public void mostrarCartaDoAcervo(Carta c);
    public void mostrarCartaDoJogador(Carta c);
    public void salvarAlteracoes(ActionListener a);
    public void exibirMensagem(String msg);
    public void tornarVisivel(boolean b);
}
