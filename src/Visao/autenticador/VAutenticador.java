

package Visao.autenticador;

import Controle.Configuravel;
import java.awt.event.ActionListener;

public interface VAutenticador extends Configuravel<VAutenticador>{
    
    public String obterNomeDeUsuario();
    public String obterSenha();
    public void mostrarMensagem(String m);
    public void fechar();
    public void habilitarAutenticacao(boolean h);
    public void quandoAutenticar(ActionListener a);
    public void quandoCancelar(ActionListener a);
    
}
