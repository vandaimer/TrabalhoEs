/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.jean;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import visao.janelas.FormDoJogo;

public class TesteImagem {

    public TesteImagem() throws IOException {

        FormDoJogo fj = new FormDoJogo();
        fj.setVisible(true);
//        URL resource = getClass().getResource("/imagens/carta.png");
//
//        BufferedImage img = ImageIO.read(resource);
//        Graphics2D g2d = (Graphics2D) img.createGraphics();
//        g2d.setColor(Color.black);
//        int yi = 325;
//        g2d.setFont(new Font("arial", Font.BOLD, 12));
//        g2d.drawString("Força: 100\ndskjfs\nsk", 30, yi);
////        g2d.drawString("Inteligencia: 100", 30, yi + 15);
////        g2d.drawString("Agilidade: 100", 30, yi + 30);
        
        

    }

    public static void main(String[] args) throws IOException {
        TesteImagem ti = new TesteImagem();
    }
}


