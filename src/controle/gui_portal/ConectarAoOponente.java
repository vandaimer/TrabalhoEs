package controle.gui_portal;

import controle.configuradores_gui.ConfiguradorGuiJogo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import modelo.jogo.Portal;
import modelo.jogo.servidor.ExcececaoConexaoRecusada;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import visao.GUIPortal;
import visao.janelas.FormDoJogo;

public class ConectarAoOponente implements ActionListener {

    private GUIPortal _gp;
    private Portal _p;

    public ConectarAoOponente(GUIPortal gp, Portal p) {
        _gp = gp;
        _p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String str_endereco = _gp.mostrarJanelaDeEntradaSimples("Para conectar a um oponente, digite ip:porta, exemplo: 127.0.0.1:1234 ou localhost:1234");

            if (str_endereco == null) {

                _gp.mostrarMensagem("formato de endereco invalido.");

            }

            String[] split = str_endereco.split(":");
            if (split == null || split.length != 2) {

                _gp.mostrarMensagem("formato de endereco invalido.");
                return;
            }

            Integer porta = new Integer(split[1]);
            String host = split[0];

            ControleRemoto controle = _p.conectarAoOponente(host, porta);
            FormDoJogo f=new FormDoJogo();

            f.aplicarConfiguracao(new ConfiguradorGuiJogo(controle,_gp));
            _gp.incluir(f);

        } catch (NumberFormatException | IOException | ExcececaoConexaoRecusada ex) {
            _gp.mostrarMensagem(ex.getMessage());
        }
    }

}
