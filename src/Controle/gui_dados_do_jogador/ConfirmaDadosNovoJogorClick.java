package Controle.gui_dados_do_jogador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Portal;
import Visao.GUIDadosDoJogador;

public class ConfirmaDadosNovoJogorClick extends QuandoConfirmarDadosNovoJogador implements ActionListener
{

	public ConfirmaDadosNovoJogorClick(Portal portal, GUIDadosDoJogador aut) {
		super(portal, aut);
	}

	@Override
	public void actionPerformed( ActionEvent a )
	{
        try
        {
            this.executarCadastro();
        }catch ( Exception e )
        {
            e.printStackTrace();
        }
    }

}
