package modelo.jogo;

import java.io.Serializable;
import java.util.Objects;

public class Carta implements Comparable<Carta>, Serializable {

    private String nome;
    private int id;
    private int ataque;
    private int defesa;
    private int efeito;
    private int inteligencia;
    private int forca;
    private int agilidade;

    public Carta(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Carta(Carta c) {
        nome = c.getNome();
        id = c.getId();

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setEfeito(int efeito) {
        this.efeito = efeito;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + this.id;
        hash = 67 * hash + this.ataque;
        hash = 67 * hash + this.defesa;
        hash = 67 * hash + this.efeito;
        hash = 67 * hash + this.inteligencia;
        hash = 67 * hash + this.forca;
        hash = 67 * hash + this.agilidade;
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
        if (this.id != other.id) {
            return false;
        }
        if (this.ataque != other.ataque) {
            return false;
        }
        if (this.defesa != other.defesa) {
            return false;
        }
        if (this.efeito != other.efeito) {
            return false;
        }
        if (this.inteligencia != other.inteligencia) {
            return false;
        }
        if (this.forca != other.forca) {
            return false;
        }
        if (this.agilidade != other.agilidade) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    

    @Override
    public String toString() {
        String retorno = "Nome: " + this.nome
                + "\n      Ataque: " + this.ataque
                + "\n      Defesa: " + this.defesa
                + "\n      Efeito: " + this.efeito
                + "\n      Inteligencia: " + this.inteligencia
                + "\n      Agilidade: " + this.agilidade
                + "\n";
        return retorno;
    }

	@Override
	public int compareTo(Carta o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
