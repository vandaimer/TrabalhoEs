package modelo.persistencia;

import modelo.Carta;
import modelo.Jogador;

import java.sql.Connection;
import java.util.List;

public interface MapeadorEntidadesDoJogo
{
    public List<Carta> obterCartasDoAcervo( Connection conexao );
    public boolean autenticarJogador( Connection conexao, Jogador jogador );
    public boolean salvarJogador( Connection conexao,Jogador jogador );
    public Jogador pesquisarPorChave( Connection conexao,String id );//ta pelo "nome" para não quebrar a versão RepositorioMemoria, depois só mudar
}