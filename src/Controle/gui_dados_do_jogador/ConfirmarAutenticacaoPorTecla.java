package Controle.gui_dados_do_jogador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Modelo.Portal;
import Visao.GUIDadosDoJogador;

public class ConfirmarAutenticacaoPorTecla extends QuandoConfirmarDadosDeAutenticacao implements KeyListener
{

	public ConfirmarAutenticacaoPorTecla(Portal portal, GUIDadosDoJogador aut)
	{
		super(portal, aut);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		
		if( e.getKeyCode() == KeyEvent.VK_ENTER ) 
	    {
	    	executarAutenticacao();
	    	
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

}
