

package Visao;

import Controle.Configuravel;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface GUIDadosDoJogador extends Configuravel<GUIDadosDoJogador>{
    
    public String obterNomeDeUsuario();
    public String obterSenha();
    public void mostrarMensagem(String m);
    public void fechar();
    public void habilitarConfirmarDados(boolean h);
    public void quandoPressionarTeclaConfirmacao(KeyListener a);
    public void quandoConfirmarDadosClick(ActionListener a);
    public void quandoConfirmarDadosTecla(KeyListener a);


    public void quandoCancelar(ActionListener a);
    public void tornarVisivel(boolean t);
}

