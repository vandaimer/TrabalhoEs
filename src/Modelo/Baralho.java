package Modelo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Baralho {

	private  List<Carta> lista = new LinkedList<>();
	private HashMap<Carta, Integer> mapeamentoQuantidade = new HashMap<>();

    public Baralho() {
    }

    public Baralho(Baralho b) {
       lista=b.listarCartas();
    }

    public void adicionar(Carta c) {
        lista.add(new Carta(c));
        
        if(!mapeamentoQuantidade.containsKey(c)){
        	mapeamentoQuantidade.put(c, 1);
        }else{
        	int qtde = mapeamentoQuantidade.get(c);
        	qtde++;
        	mapeamentoQuantidade.put(c, qtde);
        }
        
        
    }
    
    public void remover(Carta c) {
        lista.remove(c);
        
        mapeamentoQuantidade.remove(c);
    }

    public ErroDeValidacao validar() {
    	
    
        if(quantidadeCartas() < 40){
    	
    	return ErroDeValidacao.NUM_CARTAS_INSUFICIENTE;}
    	
    	if(quantidadeCartas() > 60){
        	
        	return ErroDeValidacao.NUM_CARTAS_EXCEDENTE;}
    	
    	if(verificaRepeticao()){
    		return ErroDeValidacao.CARTAS_REPETIDAS;
    	}
    	    	
        return ErroDeValidacao.NAO_HOUVE_ERRO;

    }
    
    private int quantidadeCartas(){
    	return lista.size();
    }
    
    private boolean verificaRepeticao(){
    	
    	
    	Iterator<Entry<Carta, Integer>> i = mapeamentoQuantidade.entrySet().iterator();
    	boolean existeRepetido = false;
    	
    	while(!existeRepetido && i.hasNext()){
    		existeRepetido = i.next().getValue() > 2;
    	}
    	
    	
    	return existeRepetido;
    }

    //seria esse o método pra obter as cartas?
    public List<Carta> listarCartas() {
        List<Carta> cartas = new LinkedList<>();

        for (Carta c : lista) {

            cartas.add(new Carta(c));

        }
        /*Deve retornar uma copia da lista do baralho*/
        return cartas;
    }

   

    public void montarBaralho(List<Carta> c) {
        for (Carta i : c) {

            lista.add(new Carta(i));

        }
    }
}
