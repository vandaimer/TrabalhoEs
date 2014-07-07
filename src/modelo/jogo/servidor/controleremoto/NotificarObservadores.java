package modelo.jogo.servidor.controleremoto;



import java.io.Serializable;
import java.util.Map;

import modelo.jogo.Jogador;
import modelo.metodoremoto.MetodoRemotoControleRemoto;


public class NotificarObservadores implements MetodoRemotoControleRemoto {

    private Serializable msg;
    
    public NotificarObservadores(Serializable msg) {
    this.msg=msg;    
    }

    
    
    @Override
    public void aceitar(ControleRemoto c) {
        c.notificarObservadores(msg);
    }


 
}
