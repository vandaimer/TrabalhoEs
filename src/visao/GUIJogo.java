package visao;

import controle.Configuravel;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.jogo.partida.InformacaoDoTurno;

public interface GUIJogo extends Configuravel<GUIJogo> {

    public void quandorMontarJogada(ActionListener c);

    public void quandorVisualizarPontuacao(ActionListener c);

    public void habilitarMontarJogada(boolean b);

    public void tornarVisivel(boolean b);

    public void habilitarVisualizarPontuacao(boolean b);

    public void fechar();

    public void mostrasMensagem(String m);
    public void atualizarPlacar(List<InformacaoDoTurno> info);
}
