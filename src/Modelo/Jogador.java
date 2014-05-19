package Modelo;

import java.util.List;
import java.util.Objects;

public class Jogador
{
    private Baralho baralho= new Baralho();
    private String nome;
    private String senha;

    public Jogador( String nome, String senha )
    {
        this.nome = nome;
        this.senha = senha;
    }
    
     public Jogador(Jogador j)
    {
        this.nome = j.nome;
        this.senha = j.senha;
        this.baralho=new Baralho(j.baralho);
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
        return baralho.validar();
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
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.baralho);
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Jogador other = (Jogador) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        
        return true;
    }

    

    
}