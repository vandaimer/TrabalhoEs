package modelo;


public class Jogar implements MetodoRemotoPartida {
    
    private final Jogador j;
    private final Jogada jgd;
    
    public Jogar(Jogador j, Jogada jgd) {
        this.j = j;
        this.jgd = jgd;
    }
    
    @Override
    public void aceitar(Partida p) {
        p.jogar(j, jgd);
    }
    
}
