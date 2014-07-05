package modelo;



public class Partida implements Observado{
    
    private EstadoDaPartida _estado;
    
    
    public Partida() {
        _estado = null;//insere estado inicial

    }
    
    public void iniciar(){}
    
    public void adicionarJogador(Jogador j){}
    
    
    void fixarEstado(EstadoDaPartida e) {
        _estado = e;
    }
    
    public synchronized void jogar(Jogador jgd, Jogada j) {
        _estado.jogar(this, jgd, j);
    }
    
    public synchronized void comprar(Jogador jgd, Baralho b) {
        _estado.comprar(this, jgd, b);
    }

    @Override
    public void registrar(Observador o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Observador o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notificarObservadores(Object msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
