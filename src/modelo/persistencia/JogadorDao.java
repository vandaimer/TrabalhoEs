package modelo.persistencia;

import java.sql.ResultSet;
import java.util.HashMap;

public class JogadorDao extends Dao
{
    public JogadorDao(ConexaoBanco c, String tabela)
    {
        super(c, tabela);
    }

    public ResultSet getJogador(String nome, String senha) throws Exception
    {
        HashMap<String,Object> where = new HashMap<>();
        where.put( "NOME", nome );
        where.put( "SENHA", senha );
        select(where);
        return this.getResultSet();
    }
}