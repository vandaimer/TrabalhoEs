package modelo;

public interface EstadoDaPartida {

    public void jogar(Partida p, Jogador jgd, Jogada j);
    public void comprar(Partida p, Jogador jgd, Baralho b);

}
