package Modelo;

public class Carta
{
    private String nome;
    private TipoCarta tipo;
    public Carta(String n){
    	nome = n;
    	
    }
    public String toString(){
    	return this.nome;
    }
    
}