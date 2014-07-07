package modelo.jogo;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import modelo.util.ConectorCliente;
import modelo.jogo.servidor.controleremoto.ControleRemoto;
import modelo.persistencia.ExcecaoDePersistencia;
import modelo.jogo.servidor.ExcececaoConexaoRecusada;
import modelo.util.ObservadoImpl;
import modelo.util.Observador;
import modelo.persistencia.RepositorioDoJogo;
import modelo.jogo.servidor.ServidorDePartida;

public class Portal extends ObservadoImpl {

    private final RepositorioDoJogo repositorioJogo;
    private Jogador jogador;
    private final List<Observador> observadores = new LinkedList();

    public Portal(RepositorioDoJogo rep) {
        this.repositorioJogo = rep;
    }

    public ControleRemoto conectarAoOponente(String ip, int porta) throws ExcececaoConexaoRecusada, IOException {
        ConectorCliente c = new ConectorCliente(ip, porta);
        c.enviar(jogador);
        Serializable rec = c.receber();

        if (rec instanceof ExcececaoConexaoRecusada) {
            throw ((ExcececaoConexaoRecusada) rec);
        }
        
        return new ControleRemoto(jogador, c);
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

    public List<CartaAbstrata> obterAcervo() throws ExcecaoDePersistencia {
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

}
