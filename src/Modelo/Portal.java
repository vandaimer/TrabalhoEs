package Modelo;

import Modelo.*;

import java.util.List;

public class Portal implements Observador, Observado {

    private RepositorioDoJogo repositorioJogo;
    private Jogador jogador;

    public Portal() {
        this.repositorioJogo = new RepositorDeJogoEmMemoria();
    }

    public void setJogador(Jogador j) {
        this.jogador = j;
    }

    public boolean autenticar(Jogador j) {
        boolean autenticou = repositorioJogo.autenticar(j);

        if (autenticou) {
            /*
             Mudar Interface grafica dizendo q nao pode logar
             */
            System.out.println("AUTENTICOU");
        } else {
            /*
             Mudar Interface grafica AUTENTICOU
             */
            System.out.println("NAO AUTENTICOU");

        }
        return autenticou;
    }

    public void criarJogador(Jogador j) {
        this.repositorioJogo.salvar(j);
    }

    public List<Carta> obterAcervo() {
        return this.repositorioJogo.obterCartasDoAcervo();
    }

    public Jogador obterJogadorLogado() {
        return this.jogador;
    }

    public void salvarJogador(Jogador jogador) {

    }

    @Override
    public void registrar(Observador o) {

    }

    @Override
    public void remover(Observador o) {

    }

    @Override
    public void notificarObservadores(Object msg) {

    }

    @Override
    public void notificar(Observado fonte, Object msg) {

    }
}
