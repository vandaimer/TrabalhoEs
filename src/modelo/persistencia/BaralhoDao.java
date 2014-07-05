package modelo.persistencia;

import java.sql.ResultSet;
import java.util.HashMap;

public class BaralhoDao extends Dao
{
    public BaralhoDao(ConexaoBanco c, String tabela)
    {
        super(c, tabela);
    }

    public ResultSet getCartaByJogador( int jogador ) throws Exception
    {
        HashMap<String,Object> where = new HashMap<>();
        Integer id = jogador;
        where.put( "id_jogador", id );
        select(where);
        return this.getResultSet();
    }

    public ResultSet getCartaByCarta( int carta ) throws Exception
    {
        HashMap<String,Object> where = new HashMap<>();
        Integer idCarta = carta;
        where.put( "ID_CARTA", idCarta );
        select(where);
        return this.getResultSet();
    }

    public void deletarBaralhorJogador( int jogador ) throws Exception
    {
        HashMap<String,Object> where = new HashMap<>();
        Integer id = jogador;
        where.put( "id_jogador", id );
        delete( where );
    }

    public void adicionarCartaBaralho( int jogador, int carta ) throws Exception
    {
        HashMap<String,Object> dados = new HashMap<>();
        Integer idJogador = jogador;
        Integer idCarta = carta;
        dados.put( "id_jogador", jogador );
        dados.put( "id_carta", carta );
        insert( dados );
    }
}