package controle.gui_dados_do_jogador;

import modelo.jogo.Jogador;
import modelo.jogo.Portal;
import visao.GUIDadosDoJogador;






public abstract class QuandoConfirmarDadosDeAutenticacao
{

    private Portal portal;
    private GUIDadosDoJogador aut;

    public QuandoConfirmarDadosDeAutenticacao(Portal portal, GUIDadosDoJogador aut) {
        this.portal = portal;
        this.aut = aut;
    }

    protected void executarAutenticacao() throws Exception {
        String nmUsuario = aut.obterNomeDeUsuario();
        String senha = aut.obterSenha();

        if( nmUsuario.isEmpty() || senha.isEmpty() ) {
            aut.mostrarMensagem("Verifique se o nome de usuario e senha foram preenchidos corretamente.");
            return;
        }

        Jogador j = new Jogador(nmUsuario, senha);
        boolean autenticou = portal.autenticar(j);

        if (autenticou) {
            aut.habilitarConfirmarDados(false);
            aut.mostrarMensagem("Jogador autenticado com sucesso.");
        } else {
            aut.habilitarConfirmarDados(true);
            aut.mostrarMensagem("Jogador nao conseguiu se getJogador.");
        }

    }
}
