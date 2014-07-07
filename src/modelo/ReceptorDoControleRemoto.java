package modelo;

import java.io.Serializable;

public class ReceptorDoControleRemoto implements Observador {
    
    private Jogador _jgd;
    private Conector _con;
    private Thread tLeitura;
    private Partida _p;
    
    public ReceptorDoControleRemoto(Partida p, Jogador jgd, Conector con) {
        _jgd = jgd;
        _con = con;
        _p = p;
        tLeitura = new Thread(new Leitor(p, con));
        
    }
    
    public void iniciar() {
        tLeitura.start();
        
    }
    
    public void finalizar() {
        tLeitura.interrupt();
    }
    
    @Override
    public void notificar(Observado fonte, Object msg) {
        
        if(msg instanceof Mensagem){
        Mensagem m=(Mensagem)msg;
        _con.enviar(m);
        }
        
        
    
}
}

class Leitor implements Runnable {
    
    private Partida p;
    private Conector con;
    
    public Leitor(Partida p, Conector con) {
        this.p = p;
        this.con = con;
    }
    
    @Override
    public void run() {
        
        while (true) {
            Serializable leitura = con.receber();
          
            if (leitura instanceof MetodoRemotoPartida) {
                MetodoRemotoPartida m = (MetodoRemotoPartida) leitura;
                m.aceitar(p);
            }
        }
    }
    
}
