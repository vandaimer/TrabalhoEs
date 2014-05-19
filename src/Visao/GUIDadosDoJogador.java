

package Visao;

import Controle.Configuravel;
import java.awt.event.ActionListener;

public interface GUIDadosDoJogador extends Configuravel<GUIDadosDoJogador>{
    
    public String obterNomeDeUsuario();
    public String obterSenha();
    public void mostrarMensagem(String m);
    public void fechar();
    public void habilitarConfirmarDados(boolean h);
    public void quandoConfirmarDados(ActionListener a);
    public void quandoCancelar(ActionListener a);
    
}