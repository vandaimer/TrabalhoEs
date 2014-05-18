package Modelo;

import java.util.ArrayList;
import java.util.List;

public class RepositorDeJogoEmMemoria implements RepositorioDoJogo
{
    private List<Carta> listaDeCartaACervo;
    private List<Jogador> listaJogador;

    public RepositorDeJogoEmMemoria()
    {
        this.listaDeCartaACervo = new ArrayList<Carta>();
        this.listaJogador = new ArrayList<Jogador>();
    }

    @java.lang.Override
    public List<Carta> obterCartasDoAcervo()
    {
        return null;
    }

    @java.lang.Override
    public boolean autenticar( Jogador j )
    {
        for( Jogador item : this.listaJogador )
        {
            if( item.toString().equals(j.toString()) )
            {
                return true;
            }
        }
        return false;
    }

    @java.lang.Override
    public void salvar(Jogador j)
    {
        this.listaJogador.add(j);
    }
}