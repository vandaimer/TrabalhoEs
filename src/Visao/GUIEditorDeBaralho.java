
package Visao;

import Controle.Configuravel;
import Modelo.Carta;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionListener;


public interface GUIEditorDeBaralho extends Configuravel<GUIEditorDeBaralho>{
 
    public void adicionarUmaCarta(ActionListener a);
    public void removerUmaCarta(ActionListener a);
    public void listarCartasDoJogador(List<Carta> j);
    public void listarCartasDoAcervo(List<Carta> j);
    public void quandoSelecionarUmaCartaDoAcervo(ListSelectionListener ls);
    public void quandoSelecionarUmaCartaDoJogador(ListSelectionListener ls);
    public Carta obterCartaSelecionadaNoAcervo();
    public Carta obterCartaSelecionadaDoJogador();
    public void mostrarCartaDoAcervo(Carta c);
    public void mostrarCartaDoJogador(Carta c);
    public void salvarAlteracoes(ActionListener a);
    public void tornarVisivel(boolean b);
}
