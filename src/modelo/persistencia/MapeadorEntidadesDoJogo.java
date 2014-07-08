package modelo.persistencia;



import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogador;

import java.sql.Connection;
import java.util.List;

public interface MapeadorEntidadesDoJogo
{
    public List<CartaAbstrata> obterCartasDoAcervo( Connection conexao );
    public List<CartaAbstrata> filtrarAcervo( Connection conexao, int filtro );
    public boolean autenticarJogador( Connection conexao, Jogador jogador );
    public boolean salvarJogador( Connection conexao,Jogador jogador );
    public Jogador pesquisarPorChave( Connection conexao,String id );//ta pelo "nome" para não quebrar a versão RepositorioMemoria, depois só mudar
}