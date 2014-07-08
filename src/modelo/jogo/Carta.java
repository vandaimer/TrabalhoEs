package modelo.jogo;

public class Carta extends CartaAbstrata {

    public Carta() {
        tipo = "Monstro";
    }

    public Carta(String nome, int id, int inteligencia, int forca, int agilidade) {
        super(nome, id, inteligencia, forca, agilidade, "Monstro");

    }

    public Carta(String nome, int id) {
        super(nome, id);
    }

    public Carta(CartaAbstrata c) {
        super(c);
    }

    @Override
    public CartaAbstrata clonar() {
        return new Carta(nome, id, inteligencia, forca, agilidade);
    }

}
