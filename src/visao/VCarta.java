package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import modelo.jogo.Carta;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.CartaEfeito;

public class VCarta {

    private static BufferedImage fundo;
    private CartaAbstrata c;

    public VCarta(CartaAbstrata c) {
        this.c = c;

        if (fundo == null) {
            try {
                URL resource = getClass().getResource("/imagens/carta.png");
                BufferedImage img = ImageIO.read(resource);
                fundo = img;

            } catch (IOException e) {

            }
        }

    }

    public CartaAbstrata obterCarta() {
        return c;
    }

    private void desenharImagem(BufferedImage img) {
        Graphics2D g2d = (Graphics2D) img.createGraphics();
        g2d.setColor(Color.black);

        g2d.setFont(new Font("arial", Font.BOLD, 14));
        g2d.drawString(c.getNome(), 30, 35);

        g2d.setFont(new Font("arial", Font.BOLD, 10));

        String tipo="";

        if (c instanceof Carta) {
            tipo = "Monstro";
        }

        if (c instanceof CartaEfeito) {
            tipo = "Efeito";
        }

        int yi = 318;
        g2d.drawString("Tipo: " + tipo, 30, yi);
        g2d.drawString("Força: " + c.getForca(), 30, yi + 15);
        g2d.drawString("Inteligencia: " + c.getInteligencia(), 30, yi + 30);
        g2d.drawString("Agilidade: " + c.getAgilidade(), 30, yi + 45);

    }

    private BufferedImage copiarImagem() {
        BufferedImage copia = new BufferedImage(fundo.getWidth(), fundo.getHeight(), BufferedImage.OPAQUE);
        Graphics2D g2d = (Graphics2D) copia.getGraphics();
        g2d.drawImage(fundo, 0, 0, null);
        return copia;

    }

    public BufferedImage obterImagem() {
        BufferedImage copia = copiarImagem();
        desenharImagem(copia);
        return copia;
    }

    @Override
    public String toString() {
        return c.getNome();
    }

}
