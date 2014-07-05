package modelo.persistencia;

        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.HashMap;
        import java.util.Set;

public abstract class Dao
{
    private	ResultSet resultSet = null;
    protected PreparedStatement psmt = null;
    protected Connection connection	= null;
    protected ConexaoBanco conexao	= null;

    protected String tabela = null;

    public Dao( ConexaoBanco c, String tabela )
    {
        this.conexao = c;
        this.tabela = tabela;
        this.connection = c.getConexao(null);
    }

    protected void query( String sql ) throws Exception
    {
        this.psmt = this.connection.prepareStatement( sql );
    }

    final protected void executar() throws Exception
    {
         this.resultSet = this.psmt.executeQuery();
    }

    final protected ResultSet getResultSet()
    {
        return this.resultSet;
    }

    protected void insert( HashMap<String, Object> dados ) throws Exception
    {
        String SQL = "INSERT INTO "+this.tabela+" (";
        Set<String> campos = dados.keySet();

        for( String campo : campos )
        {
            SQL += campo + ",";
        }
        SQL = SQL.substring(0, SQL.length()-1) + ")";
        SQL += " VALUES (";

        for( int i = 0; i < dados.size(); i++ )
        {
            SQL += "?,";
        }
        SQL = SQL.substring(0, SQL.length()-1) + ")";

        this.query( SQL );

        int contador = 1;
        for( String campo : campos )
        {
            this.psmt.setObject( contador, dados.get( campo ) );
            contador++;
        }
        this.psmt.execute();
    }

    protected void update( HashMap<String, String> dados, HashMap<String, String> where ) throws Exception
    {
        String SQL = "UPDATE "+this.tabela+" SET ";
        Set<String> campos = dados.keySet();

        for( String campo : campos )
        {
            SQL += campo + "=?,";
        }
        SQL = SQL.substring(0, SQL.length()-1);

        SQL += " WHERE ";
        Set<String> condicoes = where.keySet();

        for (String condicao : condicoes)
        {
            SQL += condicao += "=? AND ";
        }
        SQL = SQL.substring(0, SQL.length()-5);

        this.query( SQL );

        int contador = 1;
        for( String campo : campos )
        {
            this.psmt.setObject( contador, dados.get( campo ) );
            contador++;
        }

        for (String condicao : condicoes)
        {
            this.psmt.setObject( contador, where.get( condicao ) );
            contador++;
        }
        this.psmt.execute();
    }

    protected void select( HashMap<String, Object> where ) throws Exception
    {
        String SQL = "SELECT * FROM "+this.tabela+" WHERE ";

        Set<String> condicoes = where.keySet();
        for (String condicao : condicoes)
        {
            SQL += condicao + "=? AND ";
        }
        SQL = SQL.substring(0, SQL.length()-5 );

        this.query( SQL );

        int contador = 1;
        for (String condicao : condicoes)
        {
            this.psmt.setObject( contador, where.get( condicao ) );
            contador++;
        }
        this.executar();
    }

    protected void select( String s ) throws Exception
    {
        String SQL = "";
        if( s.equals("") )
        {
            SQL = "SELECT * FROM "+this.tabela;
        }
        else
        {
            SQL = "SELECT "+s+" FROM "+this.tabela;
        }

        this.query( SQL );
        this.executar();
    }

    protected void delete( HashMap<String, Object> where ) throws Exception
    {
        String SQL = "DELETE FROM "+this.tabela+" WHERE ";
        Set<String> condicoes = where.keySet();

        for (String condicao : condicoes)
        {
            SQL += condicao += "=? AND ";
        }
        SQL = SQL.substring(0, SQL.length()-5);

        this.query( SQL );

        int contador = 1;
        for (String condicao : condicoes)
        {
            this.psmt.setObject( contador, where.get( condicao ) );
            contador++;
        }
        this.psmt.execute();
    }
}