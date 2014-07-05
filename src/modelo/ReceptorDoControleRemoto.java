
package modelo;


public class ReceptorDoControleRemoto implements Observador{
private Jogador jgd;
private Conector con;

    public ReceptorDoControleRemoto(Jogador jgd, Conector con) {
        this.jgd = jgd;
        this.con = con;
    }

    
    @Override
    public void notificar(Observado fonte, Object msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
