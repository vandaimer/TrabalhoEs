package modelo.jogo.servidor.controleremoto;



import java.io.Serializable;
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
