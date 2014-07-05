package controle.gui_dados_do_jogador;

import modelo.Jogador;
import modelo.Portal;
import visao.GUIDadosDoJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class QuandoConfirmarDadosNovoJogador
{

    private Portal portal;
    private GUIDadosDoJogador aut;

    public QuandoConfirmarDadosNovoJogador(Portal portal, GUIDadosDoJogador aut) {
        this.portal = portal;
        this.aut = aut;
    }


    public void executarCadastro() throws Exception
    {
        String nmUsuario = aut.obterNomeDeUsuario();
        String senha = aut.obterSenha();

        if (nmUsuario.isEmpty() || senha.isEmpty()) {
            aut.mostrarMensagem("Verifique se o nome de usario e senha foram preenchidos corretamente.");
            return;
        }

        Jogador j = new Jogador(nmUsuario, senha);

        boolean cadastrou = portal.criarJogador(j);

        if (cadastrou) {
            aut.habilitarConfirmarDados(false);
            aut.mostrarMensagem("Jogador cadastrado com sucesso.");
        } else {
            aut.habilitarConfirmarDados(true);
            aut.mostrarMensagem("Jogador nao conseguiu cadastrar.");
        }

    }
}
