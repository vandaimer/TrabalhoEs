package modelo;

public class SinalizarReconhecimento implements MetodoRemotoPartida {
    
    private Jogador _j;
    
    public SinalizarReconhecimento(Jogador j) {
        _j = j;
    }
    
    @Override
    public void aceitar(Partida p) {
        p.sinalizarReconhecimento(_j);
        
    }
    
}
