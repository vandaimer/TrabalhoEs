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

public class CriarPartida implements ActionListener {

    private Portal _p;
    private GUIPortal _gp;

    public CriarPartida(Portal p, GUIPortal gp) {
        _p = p;
        _gp = gp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            String str_porta = _gp.mostrarJanelaDeEntradaSimples("Para criar uma partida digite abaixo o numero da porta:");

            if (str_porta == null) {
                return;
            }

            Integer porta = new Integer(str_porta);
            ControleRemoto controle = _p.criarPartida(porta);
            FormDoJogo f = new FormDoJogo();
            f.aplicarConfiguracao(new ConfiguradorGuiJogo(controle,_gp));
            _gp.incluir(f);
        } catch (NumberFormatException | IOException | ExcececaoConexaoRecusada ex) {
            _gp.mostrarMensagem(ex.getMessage());
        }

    }

}
