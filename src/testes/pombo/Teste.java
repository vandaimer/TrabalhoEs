package testes.pombo;


import Modelo.Baralho;
import Modelo.Carta;


public class Teste {
    public static void main(String[] args) {
    	
    	Baralho b = new Baralho();
    	
    	Carta c1 = new Carta("as de espada");
    	//Carta c1 = new Carta("3 de paus");
    	Carta c2 = new Carta("rei de ouro");
    	Carta c3 = new Carta("valete de copas");
    	
    	
    	b.adicionar(c1);
    	b.adicionar(c2);
    	b.adicionar(c1);
    	b.adicionar(c3);
    	b.adicionar(c1);
    	
    	System.out.println(b.verificaRepeticao());
    	
    }
}
