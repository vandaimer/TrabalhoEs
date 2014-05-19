package Controle.gui_dados_do_jogador;

import Modelo.Jogador;
import Modelo.Portal;
import Visao.GUIDadosDoJogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuandoConfirmarDadosNovoJogador implements ActionListener {

    private Portal portal;
    private GUIDadosDoJogador aut;

    public QuandoConfirmarDadosNovoJogador(Portal portal, GUIDadosDoJogador aut) {
        this.portal = portal;
        this.aut = aut;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String nmUsuario = aut.obterNomeDeUsuario();
        String senha = aut.obterSenha();

        if (nmUsuario == null || senha == null) {
            aut.mostrarMensagem("Verifique se o nome de usario e senha foram preenchidos corretamente.");
            return;
        }

        Jogador j = new Jogador(nmUsuario, senha);
        boolean autenticou = true;
//boolean autenticou = portal.criarJogador(j);

        if (autenticou) {
            aut.habilitarConfirmarDados(false);
            aut.mostrarMensagem("Jogador cadastrado com sucesso.");
        } else {
            aut.habilitarConfirmarDados(true);
            aut.mostrarMensagem("Jogador nao conseguiu cadastrar.");
        }

    }
}
