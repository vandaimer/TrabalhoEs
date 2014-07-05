package controle.gui_dados_do_jogador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Portal;
import visao.GUIDadosDoJogador;

public class ConfirmaDadosNovoJogoTecla extends QuandoConfirmarDadosNovoJogador implements KeyListener
{

	public ConfirmaDadosNovoJogoTecla(Portal portal, GUIDadosDoJogador aut)
	{
		super(portal, aut);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if( e.getKeyCode() == KeyEvent.VK_ENTER ) 
	    {
            try
            {
                executarCadastro();
            }catch (Exception err )
            {
                err.printStackTrace();
            }
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
