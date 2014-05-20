package Modelo;

import java.util.LinkedList;
import java.util.List;

public class Portal implements  Observado {
    
    private final RepositorioDoJogo repositorioJogo;
    private Jogador jogador;  
    private final List<Observador> observadores = new LinkedList();
    
    public Portal(RepositorioDoJogo rep) {
        this.repositorioJogo = rep;
    }
    
    public boolean autenticar(Jogador j) {
        boolean autenticou = repositorioJogo.autenticar(j);
        
        if (autenticou) {
        	jogador=repositorioJogo.pesquisarPorChave(j.toString());
            notificarObservadores("usuario_autenticado");
            
        } else {
            notificarObservadores("usuario_nao_autenticado");
        }
        
        return autenticou;
    }

    public boolean criarJogador(Jogador j) {
        boolean autenticou = repositorioJogo.autenticar(j);
        
        if (autenticou) {
            return false;
        }
        
        return repositorioJogo.salvar(j);
    }
    
    public List<Carta> obterAcervo() {
        return this.repositorioJogo.obterCartasDoAcervo();
    }
    
    public Jogador obterJogadorLogado() {
        return new Jogador(jogador);
    }

    public boolean salvarJogador(Jogador jgd) {
        
        if (jogador == null) {
            return false;
        }
        
        boolean salvou = repositorioJogo.salvar(jgd);
        
        if (salvou) {
            jogador = jgd;
        }
        
        return salvou;
    }
    
    @Override
    public void registrar(Observador o) {
        observadores.add(o);
    }
    
    @Override
    public void remover(Observador o) {
        observadores.remove(o);
    }
    
    @Override
    public void notificarObservadores(Object msg) {
        for (Observador obs : observadores) {
            obs.notificar(this, msg);
        }
    }
    
  
}
