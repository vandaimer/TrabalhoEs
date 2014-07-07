package controle.gui_dados_do_jogador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.jogo.Portal;
import visao.GUIDadosDoJogador;

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
            try {
                executarAutenticacao();
            } catch (Exception e1) {
                e1.printStackTrace();
            }

        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
		
	}

}
