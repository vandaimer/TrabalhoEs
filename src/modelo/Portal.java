package modelo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Portal implements Observado {

    private final RepositorioDoJogo repositorioJogo;
    private Jogador jogador;
    private final List<Observador> observadores = new LinkedList();

    public Portal(RepositorioDoJogo rep) {
        this.repositorioJogo = rep;
    }

    public ControleRemoto conectarAoOponente(String ip, int porta) throws ExcececaoConexaoRecusada, IOException {
        return new ControleRemoto(jogador, ip, porta);
    }

    public ControleRemoto criarPartida(int porta) throws IOException, ExcececaoConexaoRecusada {
        ServidorDePartida servidor = new ServidorDePartida(porta);
        servidor.iniciarServico();
        return conectarAoOponente("localhost", porta);
    }

    public boolean autenticar(Jogador j) throws ExcecaoDePersistencia {
        boolean autenticou = repositorioJogo.autenticar(j);

        if (autenticou) {
            jogador = repositorioJogo.pesquisarPorChave(j.toString());
            notificarObservadores("usuario_autenticado");

        } else {
            notificarObservadores("usuario_nao_autenticado");
        }

        return autenticou;
    }

    public boolean criarJogador(Jogador j) throws ExcecaoDePersistencia {
        boolean autenticou = repositorioJogo.autenticar(j);
        if (autenticou) {
            return false;
        }

 

        

        return repositorioJogo.salvar(j);
    }

    public List<Carta> obterAcervo() throws ExcecaoDePersistencia {
        return this.repositorioJogo.obterCartasDoAcervo();
    }

    public Jogador obterJogadorLogado() {
        return new Jogador(jogador);
    }

    public boolean salvarJogador(Jogador jgd) throws ExcecaoDePersistencia {

        if (jogador == null) {
            return false;
        }

        jgd.setID(jogador.getId());
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
