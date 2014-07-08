package testes.smurf;



import java.util.List;

import modelo.jogo.Baralho;
import modelo.jogo.partida.ControladorDePartida;
import modelo.jogo.partida.InformacaoDoTurno;
import modelo.jogo.Carta;
import modelo.jogo.CartaEfeito;
import modelo.jogo.Jogada;
import modelo.jogo.Jogador;
import modelo.jogo.Portal;
import modelo.persistencia.Fabrica;
import modelo.persistencia.FabricaFerramentasPersistencia;
import modelo.persistencia.MapeadorEntidadesDoJogo;
import modelo.persistencia.RepositorioDeJogoDB;
import modelo.util.Mensagem;
import modelo.util.Observado;
import modelo.util.Observador;
import modelo.jogo.partida.Partida;



public class TesteEstadoPartida {

    public static void main(String[] args) {
        Partida p=new Partida(2, new ControladorDePartida() {

            @Override
            public void notificarFimDeJogo() {
                System.out.println("fim do jogo por favor");
            }
        });
        
        Jogador j=new Jogador("jean", ""),
                r=new Jogador("rodz", "");
        r.setID(10);
        j.setID(20);
        
        p.registrar(new Observador() {

            @Override
            public void notificar(Object fonte, Object msg) {
                System.out.println(msg);
                if(msg instanceof Mensagem){
                	Mensagem m = (Mensagem) msg;
                	if(m.obterAssunto().equals("atualizar_pontuacao")){
                		List<InformacaoDoTurno> t = (List<InformacaoDoTurno>) m.obterConteudo();
                		for (InformacaoDoTurno inf : t) {
                			inf.toString();
						}
                	}
                }
                
                
                
            }
        });
        
      
        
        p.adicionarJogador(j);
        p.adicionarJogador(r);
        
        p.sinalizarReconhecimento(j);
        p.sinalizarReconhecimento(r);
        Baralho bR = new Baralho();
        Baralho bJ = new Baralho();
        
        Carta c = new Carta("a", 1,2,2,2);
        Carta c1 = new Carta("b", 1,1,1,1);
        CartaEfeito c2 = new CartaEfeito("e",3,2,1,1);
        Portal p1 = new Portal(new RepositorioDeJogoDB(new Fabrica("150.162.52.177", "jogoes", "@fuckingpassword@", "engenhariasoftware")));
        
        
        bR.adicionar(c);
        
        bJ.adicionar(c1);
        bJ.adicionar(c2);
        
        
        
        p.jogar(j, new Jogada(bJ,j));
        
        p.jogar(r, new Jogada(bR,r));
       // p.jogar(r, new Jogada(bR,r));
        
        p.jogar(j, new Jogada(bJ,j));
        p.jogar(r, new Jogada(bR,r));
        
        
        
    }
}
