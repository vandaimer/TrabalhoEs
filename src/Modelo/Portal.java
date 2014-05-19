package Modelo;


import java.util.List;

public class Portal implements Observador, Observado {

    private RepositorioDoJogo repositorioJogo;
    private Jogador jogador;

    public Portal(RepositorioDoJogo rep) {
        this.repositorioJogo =rep;
    }

   

    public boolean autenticar(Jogador j) {
        boolean autenticou = this.repositorioJogo.autenticar(j);

        if (autenticou) {
            notificarObservadores("usuario_autenticado");

        } else {
            notificarObservadores("usuario_nao_autenticado");
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
        repositorioJogo.salvar(jogador);
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
