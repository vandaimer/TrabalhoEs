

package visao;

import controle.Configuravel;

import java.util.List;


import modelo.jogo.CartaAbstrata;

import javax.swing.event.ListSelectionListener;


public interface GUIVisualizadorDeCartas extends Configuravel<GUIVisualizadorDeCartas>{
    
public void mostrar(CartaAbstrata c);
public void listarCartas(List<CartaAbstrata> l);
public void selecionarUmaCarta(ListSelectionListener a);
public CartaAbstrata obterCartaSelecionada();
public void tornarVisivel(boolean b);
}