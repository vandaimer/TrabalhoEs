package modelo.jogo;

import java.io.Serializable;
import java.util.Objects;


public  class Carta implements Serializable{
	private String nome;
	private int id;
	private int inteligencia;
	private int forca;
	private int agilidade;

	public Carta(String nome, int id, int inteligencia, int forca, int agilidade) {
		this.nome = nome;
		this.id = id;
		this.inteligencia = inteligencia;
		this.forca = forca;
		this.agilidade = agilidade;
	}
	
	public Carta(String nome, int id) {
		this.nome = nome;
		this.id = id;
	}

	public Carta(Carta c) {
		nome = c.getNome();
		id = c.getId();
		inteligencia = c.getInteligencia();
		forca = c.getForca();
		agilidade = c.getAgilidade();
	}

	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(int agilidade) {
		this.agilidade = agilidade;
	}
	
	public void aumentaForca(int forca){
		this.forca += forca;
	}
	
	public void aumentaInteligencia(int inteligencia){
		this.inteligencia += inteligencia;
	}
	
	public void aumentaAgilidade(int agilidade){
		this.agilidade += agilidade;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 73 * hash + Objects.hashCode(this.nome);
		hash = 73 * hash + Objects.hashCode(this.id); // ???
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

		return true;
	}
	
	

	@Override
	public String toString() {
		String retorno = "Nome: " + getNome() + "\n      Força: " + getForca()
				+ "\n      Inteligencia: " + getInteligencia()
				+ "\n      Agilidade: " + getAgilidade() + "\n";
		return retorno;
	}

}