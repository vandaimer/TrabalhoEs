package modelo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Fabrica implements FabricaFerramentasPersistencia
{
    private final String host;
    private final String login;
    private final String senha;
    private final String banco;

    private MapeadorEntidadesDoJogo mapeador;
    private Connection conexao;


    public Fabrica( String host,String login,String senha,String banco )
    {
        this.host = host;
        this.login = login;
        this.senha = senha;
        this.banco = banco;
        this.mapeador = new Mapeador();
    }

    @Override
    public Connection obterConexao()
    {
        try
        {
            if( this.conexao == null )
            {
                return this.conexao = DriverManager.getConnection( "jdbc:mysql://"+this.host+"/"+this.banco, this.login,
                        this.senha );
            }
            return this.conexao;
        }
        catch( Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MapeadorEntidadesDoJogo obterMapeador()
    {
        return this.mapeador;
    }
}
