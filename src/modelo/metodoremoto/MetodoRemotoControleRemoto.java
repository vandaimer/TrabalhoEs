/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.metodoremoto;

import java.io.Serializable;
import java.util.Map;

import modelo.jogo.Jogador;
import modelo.jogo.servidor.controleremoto.ControleRemoto;

/**
 *
 * @author jean
 */
public interface MetodoRemotoControleRemoto extends Serializable{
  public void aceitar(ControleRemoto c);
  
}
