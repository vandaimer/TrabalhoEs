package Modelo;

import java.util.List;

public class Jogador
{
    private Baralho baralho;
    private String nome;
    private String senha;

    public Jogador( String nome, String senha )
    {
        this.nome = nome;

        /*
          foda-se sem criptografia kk
         */

        this.senha = senha;
    }

    public void adicionarCarta( Carta c)
    {
        
    }

    public void adicionarCarta( List<Carta> c )
    {

    }

    public ErroDeValidacao validarBaralho()
    {
        return null;
    }

    public List<Carta> obterCartasAtuais()
    {
        return null;
    }

    public void remover( Carta c )
    {

    }

    public void editarBaralho( Carta c, byte opcao )
    {

    }

    @Override
    public String toString()
    {
        /*
            retorno string qualquer pra veriricar, validacao lixo
         */
        return this.senha+this.nome;
    }
}