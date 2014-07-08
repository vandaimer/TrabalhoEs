package controle.gui_jogo;

import controle.configuradores_gui.ConfiguradorVisualizadorDeCartas;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import modelo.jogo.Jogada;
import modelo.jogo.partida.InformacaoDoTurno;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import modelo.util.Observador;
import visao.GUIJogo;
import visao.GUIPortal;
import visao.janelas.FormVisualizadorDeCartas;

public class ObservadorDoControleRemoto implements Observador {

    private GUIJogo _gj;
    private ControleRemoto _ctr;
    private GUIPortal gui;

    public ObservadorDoControleRemoto(GUIJogo _gj, ControleRemoto _ctr, GUIPortal gui) {
        this._gj = _gj;
        this._ctr = _ctr;
        this.gui = gui;
    }
    

    

    @Override
    public void notificar(Object fonte, Object msg) {

        if ("iniciar_turno".equals(msg)) {
            _gj.habilitarMontarJogada(true);
            return;
        }

        if ("jogada_realizada".equals(msg)) {
            _gj.habilitarMontarJogada(false);

            return;
        }

        if ("atualizar_pontuacao".equals(msg)) {

            List<InformacaoDoTurno> info = _ctr.getListaInformacaoTurno();
            _gj.atualizarPlacar(info);
       

            return;
        }

        if ("fim_do_jogo".equals(msg)) {
            _ctr.remover(this);
            _gj.mostrasMensagem("Fim do jogo seu brucutu");
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                _gj.mostrasMensagem(e.getMessage());
            }

            _gj.fechar();

            return;
        }

    }

}
