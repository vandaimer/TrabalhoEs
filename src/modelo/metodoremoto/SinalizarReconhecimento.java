package modelo.metodoremoto;

import modelo.metodoremoto.MetodoRemotoReceptor;
import modelo.jogo.servidor.ReceptorDoControleRemoto;

public class SinalizarReconhecimento implements MetodoRemotoReceptor {
    

    
    @Override
    public void aceitar(ReceptorDoControleRemoto p) {
        p.sinalisarReconhecimento();
        
    }
    
}
