package modelo.jogo.servidor;

import modelo.metodoremoto.MetodoRemotoReceptor;
import modelo.jogo.Jogador;
import modelo.jogo.partida.Partida;

import java.io.Serializable;
import java.util.List;

import modelo.jogo.Baralho;
import modelo.jogo.Carta;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogada;
import modelo.jogo.servidor.controleremoto.AtualizarPontuacaoControleRemoto;
import modelo.jogo.servidor.controleremoto.Finalizar;
import modelo.jogo.servidor.controleremoto.NotificarObservadores;
import modelo.util.Conector;
import modelo.util.Mensagem;
import modelo.util.Observador;
import testes.jean.Telefone;

public class ReceptorDoControleRemoto implements Observador, Serializable {
    
    private Jogador _jgd;
    private Partida _p;
    private Telefone tel;
    
    public ReceptorDoControleRemoto(Partida p, Jogador jgd, Conector con) {
        _jgd = jgd;
        _p = p;
        tel = new Telefone(con);
        
    }
    
    public void iniciar() {
        tel.registrar(this);
        _p.registrar(this);
        tel.ligar();
        
    }
    
    public void jogar(List<CartaAbstrata> cartas) {
        Baralho b = new Baralho();
        b.montarBaralho(cartas);
        Jogada jgda = new Jogada(b,_jgd);
        _p.jogar(_jgd, jgda);
    }
    
    public void sinalisarReconhecimento() {
        _p.sinalizarReconhecimento(_jgd);
    }    
    
    @Override
    public void notificar(Object fonte, Object msg) {
        
        if (fonte.equals(tel)) {
            
            if (msg instanceof MetodoRemotoReceptor) {
                MetodoRemotoReceptor m = (MetodoRemotoReceptor) msg;
                m.aceitar(this);
            }
            
            return;
        }
        
        if (fonte.equals(_p)) {
            
            Mensagem m = (Mensagem) msg;
            Serializable assunto = m.obterAssunto();
            
            if ("iniciar_turno".equals(assunto)) {
                
                tel.falar(new NotificarObservadores("iniciar_turno"));
                return;
            }
            
            if ("jogada_realizada".equals(assunto) && _jgd.equals(m.obterConteudo())) {
                tel.falar(new NotificarObservadores("jogada_realizada"));
                return;
            }
            
            if ("atualizar_pontuacao".equals(assunto)) {
            	tel.falar(new AtualizarPontuacaoControleRemoto(m.obterConteudo()));
                tel.falar(new NotificarObservadores("atualizar_pontuacao"));
                return;
            }
            
            if ("fim_do_jogo".equals(assunto)) {
                tel.falar(new NotificarObservadores("fim_do_jogo"));
                tel.falar(new Finalizar());
                tel.desligar();
                return;
            }
            
        }
        
    }
}
