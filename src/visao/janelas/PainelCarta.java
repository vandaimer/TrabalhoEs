package visao.janelas;

import modelo.jogo.CartaAbstrata;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import visao.VCarta;

class PainelCarta extends JPanel {

    public void mostrarCarta(CartaAbstrata c) {
        if (c == null) {
            return;
        }

        VCarta vc = new VCarta(c);

        limpar();

        Graphics2D g2 = (Graphics2D) getGraphics();
        g2.drawImage(vc.obterImagem(), 20, 0, null);
    }

    public void limpar() {
        Graphics2D g2 = (Graphics2D) getGraphics();
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, getWidth(), getHeight());

    }

}
