package Modelo.Persistencia;


import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoBanco
{
    private static Connection conexao;
    private String host, login, senha,banco;

    public ConexaoBanco( String host, String login, String senha,String banco )
    {
        this.host = host;
        this.login = login;
        this.senha = senha;
        this.banco = banco;
        this.getConexao("");
    }

    public ConexaoBanco( String banco, String login, String senha )
    {
        this.host = "localhost";
        this.login = login;
        this.senha = senha;
        this.banco = banco;
        this.getConexao("");
    }

    public ConexaoBanco()
    {
        this.host = "localhost";
        this.banco = "EngenhariaSoftware";
        this.login = "root";
        this.senha = "admin";
        this.getConexao("");
    }

    public Connection getConexao( String conector )
    {
        if( conexao != null )
        {
            return conexao;
        }
        this.newConexao( conector );
        return conexao;
    }

    private void newConexao( String conector )
    {
        try
        {
            if( conector.toLowerCase().equals("mysql") )
            {
                conexao = DriverManager.getConnection( "jdbc:mysql://"+this.host+"/"+this.banco, this.login,
                        this.senha );
            }
            else if( conector.toLowerCase().equals( "postgresql" ) || conector.isEmpty() )
            {
                conexao = DriverManager.getConnection( "jdbc:postgresql://"+this.host+":5432/"+this.banco,
                        this.login, this.senha );
            }
        }
        catch( Exception e )
        {
            System.out.println( e );
        }
    }
}