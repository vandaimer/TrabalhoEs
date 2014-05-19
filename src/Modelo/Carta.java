package Modelo;

import java.util.Objects;

public class Carta
{
    private String nome;
    private TipoCarta tipo;
    
    public Carta(String n){
    	nome = n;
    	
    }
    
   public Carta(Carta c){
    	nome = c.nome;
        tipo=c.tipo;
    	
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.tipo);
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
        final Carta other = (Carta) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }
 
   
   
    @Override
    public String toString(){
    	return this.nome;
    }
    
}