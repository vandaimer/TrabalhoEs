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
        baralho = new Baralho();

        /*
          foda-se sem criptografia kk
         */

        this.senha = senha;
    }

    public void adicionarCarta( Carta c)
    {
        baralho.adicionar(c);
    }

    public void adicionarCarta( List<Carta> c )
    {
    	baralho.montarBaralho(c);
    }

    public ErroDeValidacao validarBaralho()
    {
        return null;
    }

    public List<Carta> obterCartasAtuais()
    {
    	
        return baralho.listarCartas();
    }

    public void remover( Carta c )
    {
    	baralho.remover(c);
    }

    public void editarBaralho( Carta c, int opcao )
    {    	
    	if(opcao == 0){
    		baralho.adicionar(c);
    	}else{
    		baralho.remover(c);
    	}
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