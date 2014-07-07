
package testes.jean;

import modelo.jogo.Baralho;
import modelo.jogo.partida.ControladorDePartida;
import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.util.Observado;
import modelo.util.Observador;
import modelo.jogo.partida.Partida;



public class TesteEstadosDoJogo {

    public static void main(String[] args) {
        Partida p=new Partida(2, new ControladorDePartida() {

            @Override
            public void notificarFimDeJogo() {
                System.out.println("fim do jogo por favor");
            }
        });
        
        Jogador j=new Jogador("jean", ""),
                r=new Jogador("rodz", "");
        
        p.registrar(new Observador() {

            @Override
            public void notificar(Observado fonte, Object msg) {
                System.out.println(msg);
            }
        });
        
      
        
        p.adicionarJogador(j);
        p.adicionarJogador(r);
        
        p.sinalizarReconhecimento(j);
        p.sinalizarReconhecimento(r);
        
        
        p.jogar(j, new Jogada(new Baralho()));
        p.jogar(r, new Jogada(new Baralho()));
        
        p.jogar(j, new Jogada(new Baralho()));
        p.jogar(r, new Jogada(new Baralho()));
        
        
        
    }
}
