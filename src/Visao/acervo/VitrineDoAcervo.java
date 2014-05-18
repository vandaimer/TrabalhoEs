

package Visao.acervo;

import Controle.Configuravel;
import java.awt.event.ActionListener;
import java.util.List;
import Modelo.Carta;


public interface VitrineDoAcervo extends Configuravel<VitrineDoAcervo>{
    
public void mostrar(Carta c);
public void listarCartas(List<Carta> l);
public void selecionarUmaCarta(ActionListener a);
public Carta obterCartaSelecionada();

}