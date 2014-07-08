package controle.gui_jogo;

import javax.swing.JOptionPane;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import modelo.util.Observador;
import visao.GUIJogo;

public class ObservadorDoControleRemoto implements Observador {

    private GUIJogo _gj;
    private ControleRemoto _ctr;

    public ObservadorDoControleRemoto(GUIJogo gj, ControleRemoto ctr) {
        _gj = gj;
        _ctr = ctr;
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
            System.out.println("");
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
