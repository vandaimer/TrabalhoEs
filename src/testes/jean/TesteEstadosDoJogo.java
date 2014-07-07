
package testes.jean;

import modelo.Baralho;
import modelo.ControladorDePartida;
import modelo.Jogada;
import modelo.Jogador;
import modelo.Observado;
import modelo.Observador;
import modelo.Partida;



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
