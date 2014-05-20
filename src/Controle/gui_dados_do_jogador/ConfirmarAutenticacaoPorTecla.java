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
		System.out.println("BUCETA1");
		if( e.getKeyCode() == KeyEvent.VK_ENTER ) 
	    {
	    	executarAutenticacao();
	    	System.out.println("BUCETA2");
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("BUCETA3");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("BUCETA4");
		
	}

}
