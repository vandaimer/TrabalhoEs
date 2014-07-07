/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.jean;

import java.util.LinkedList;
import modelo.Jogador;

/**
 *
 * @author jean
 */
public class TesteLista {

    public static void main(String[] args) {
        Jogador j = new Jogador("rodz", "mel");

        LinkedList<Jogador> js = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            js.add(j);
        }

        for (Jogador _j : js) {
            System.out.println(_j);
        }

    }

}
