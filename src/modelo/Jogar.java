package modelo;

import java.io.Serializable;

public class Jogar implements Serializable {
    
    private final Jogador j;
    private final Jogada jgd;
    
    public Jogar(Jogador j, Jogada jgd) {
        this.j = j;
        this.jgd = jgd;
    }
    
    public void aceitar(Partida p) {
        p.jogar(j, jgd);
    }
    
}
