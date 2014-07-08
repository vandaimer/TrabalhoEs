package testes.smurf;




import modelo.jogo.Baralho;
import modelo.jogo.partida.ControladorDePartida;
import modelo.jogo.Carta;
import modelo.jogo.CartaEfeito;
import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.jogo.ValidacaoMao;
import modelo.util.Observado;
import modelo.util.Observador;
import modelo.jogo.partida.Partida;



public class TesteValidacao {

    public static void main(String[] args) {

        
        Baralho b = new Baralho();
        Carta c = new Carta("a", 1);
        Carta c1 = new Carta("b", 1);
        Carta c2 = new Carta("c", 1);
        CartaEfeito c3 = new CartaEfeito("d", 4, 1, 1, 1);
        CartaEfeito c4 = new CartaEfeito("e", 5, 1, 1, 1);
        b.adicionar(c);
        b.adicionar(c3);
        b.adicionar(c4);
        
        //b.adicionar(c1);
        //b.adicionar(c2);

        
        ValidacaoMao v = new ValidacaoMao();
        v.validar(b);
        
        
        
    }
}