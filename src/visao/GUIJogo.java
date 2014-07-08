package visao;

import controle.Configuravel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public interface GUIJogo extends Configuravel<GUIJogo> {

    public void quandorMontarJogada(ActionListener c);

    public void quandorVisualizarPontuacao(ActionListener c);

    public void habilitarMontarJogada(boolean b);
    public void tornarVisivel(boolean b);

    public void habilitarVisualizarPontuacao(boolean b);

    public void atualizarTelaDoJogo(BufferedImage i);
}
