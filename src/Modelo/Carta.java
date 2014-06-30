package Modelo;

import java.util.Objects;

public class Carta
{
    private String nome;
    private int id;

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

    private int ataque;
    private int defesa;
    private int efeito;
    private int inteligencia;
    private int forca;
    private int agilidade;

    private TipoCarta tipo;
    
    public Carta( String nome, int id )
    {
    	this.nome = nome;
        this.id = id;
    }
    
   public Carta(Carta c)
   {
    	nome = c.getNome();
        id =   c.getId();
        tipo=  c.getTipo();
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
 
    public int getId()
    {
        return this.id;
    }

    public String getNome()
    {
        return this.nome;
    }

    public TipoCarta getTipo()
    {
        return this.tipo;
    }

    @Override
    public String toString()
    {
    	String retorno = "Nome: " + this.nome +
                         "\n      Ataque: " + this.ataque +
                         "\n      Defesa: " + this.defesa +
                         "\n      Efeito: " + this.efeito +
                         "\n      Inteligencia: " + this.inteligencia +
                         "\n      Agilidade: " + this.agilidade +
                         "\n";
        return retorno;
    }
    
}