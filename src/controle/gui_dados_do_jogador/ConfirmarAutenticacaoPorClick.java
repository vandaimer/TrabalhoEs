package controle.gui_dados_do_jogador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.jogo.Portal;
import visao.GUIDadosDoJogador;

public class ConfirmarAutenticacaoPorClick extends QuandoConfirmarDadosDeAutenticacao implements ActionListener
{
	public ConfirmarAutenticacaoPorClick(Portal portal, GUIDadosDoJogador aut)
	{
		super(portal, aut);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
        try {
            executarAutenticacao();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}