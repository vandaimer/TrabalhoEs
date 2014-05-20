package Controle.gui_dados_do_jogador;

import Modelo.Jogador;
import Modelo.Portal;
import Visao.GUIDadosDoJogador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class QuandoConfirmarDadosDeAutenticacao
{

    private Portal portal;
    private GUIDadosDoJogador aut;

    public QuandoConfirmarDadosDeAutenticacao(Portal portal, GUIDadosDoJogador aut) {
        this.portal = portal;
        this.aut = aut;
    }

    protected void executarAutenticacao()
    {
        String nmUsuario = aut.obterNomeDeUsuario();
        String senha = aut.obterSenha();

        if (nmUsuario == null || senha == null) {
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
            aut.mostrarMensagem("Jogador nao conseguiu se autenticar.");
        }

    }
}
