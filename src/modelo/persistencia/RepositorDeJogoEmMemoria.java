package modelo.persistencia;

import modelo.persistencia.RepositorioDoJogo;
import modelo.jogo.Carta;
import modelo.jogo.Jogador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorDeJogoEmMemoria implements RepositorioDoJogo {

    private final List<Carta> listaDeCartaACervo;
    private final Map<String, Jogador> listaJogador = new HashMap<>();

    public RepositorDeJogoEmMemoria() {
        listaDeCartaACervo = new ArrayList(60);
        for (int i = 1; i < 61; i++) {
            listaDeCartaACervo.add(new Carta("carta numero: " + i,i));
        }
    }

    @java.lang.Override
    public List<Carta> obterCartasDoAcervo() {
        List<Carta> retorno = new ArrayList(60);
        for (Carta c : listaDeCartaACervo) {
            retorno.add(new Carta(c));
        }
        return retorno;
    }
    @java.lang.Override
    public boolean autenticar(Jogador j) {
        if (j == null) {
            return false;
        }
        Jogador encontrado = listaJogador.get(j.toString());
        return j.equals(encontrado);
    }

    @java.lang.Override
    public boolean salvar(Jogador j) {
        if (j == null) {
            throw new IllegalArgumentException("O argumento jogador nao pode ser nulo");

        }

        listaJogador.put(j.toString(), new Jogador(j));
        return true;
    }

    @Override
    public Jogador pesquisarPorChave(String id) {
        return new Jogador(listaJogador.get(id));
    }
}
