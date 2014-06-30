package Modelo.Persistencia;

import java.sql.ResultSet;
import java.util.HashMap;

public class CartaDao extends Dao
{
    public CartaDao( ConexaoBanco c, String tabela )
    {
        super(c, tabela);
    }

    public ResultSet listAll() throws Exception
    {
        select("");
        return this.getResultSet();
    }

    public ResultSet getCartaByID( int carta ) throws Exception
    {
        HashMap<String,Object> where = new HashMap<>();
        Integer id = carta;
        where.put( "ID", id );
        select( where );
        return this.getResultSet();
    }
}