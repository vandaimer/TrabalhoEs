package visao.janelas;

import modelo.Carta;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

class PainelCarta extends JPanel {

    public void mostrarCarta(Carta c) {
        if (c == null) {
            return;
        }

        limpar();
        Graphics2D g2 = (Graphics2D) getGraphics();
        g2.setColor(Color.BLACK);
        g2.drawString(c.toString(), 10, 10);
    }

    public void limpar() {
        Graphics2D g2 = (Graphics2D) getGraphics();
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, getWidth(), getHeight());

    }

}
