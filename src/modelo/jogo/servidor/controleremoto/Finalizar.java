
package modelo.jogo.servidor.controleremoto;

import modelo.metodoremoto.MetodoRemotoControleRemoto;


public class Finalizar implements MetodoRemotoControleRemoto{

    @Override
    public void aceitar(ControleRemoto c) {
        c.finalizar();
    }

    
}
