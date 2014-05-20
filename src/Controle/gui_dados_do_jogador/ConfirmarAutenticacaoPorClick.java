package Controle.gui_dados_do_jogador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Portal;
import Visao.GUIDadosDoJogador;

public class ConfirmarAutenticacaoPorClick extends QuandoConfirmarDadosDeAutenticacao implements ActionListener
{
	public ConfirmarAutenticacaoPorClick(Portal portal, GUIDadosDoJogador aut)
	{
		super(portal, aut);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		executarAutenticacao();
	}
}