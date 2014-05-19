

package Visao;

import Controle.Configuravel;
import java.util.List;
import Modelo.Carta;
import javax.swing.event.ListSelectionListener;


public interface GUIVisualizadorDeCartas extends Configuravel<GUIVisualizadorDeCartas>{
    
public void mostrar(Carta c);
public void listarCartas(List<Carta> l);
public void selecionarUmaCarta(ListSelectionListener a);
public Carta obterCartaSelecionada();
public void tornarVisivel(boolean b);
}