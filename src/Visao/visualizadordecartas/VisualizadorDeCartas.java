

package Visao.visualizadordecartas;

import Controle.Configuravel;
import java.awt.event.ActionListener;
import java.util.List;
import Modelo.Carta;


public interface VisualizadorDeCartas extends Configuravel<VisualizadorDeCartas>{
    
public void mostrar(Carta c);
public void listarCartas(List<Carta> l);
public void selecionarUmaCarta(ActionListener a);
public Carta obterCartaSelecionada();

}