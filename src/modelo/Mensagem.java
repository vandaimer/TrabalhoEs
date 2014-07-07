package modelo;

import java.io.Serializable;

public class Mensagem implements Serializable{
    
    private Serializable assunto;
    private Serializable conteudo;

    public Mensagem(Serializable assunto, Serializable conteudo) {
        this.assunto = assunto;
        this.conteudo = conteudo;
    }

    public Serializable obterAssunto() {
        return assunto;
    }

    public Serializable obterConteudo() {
        return conteudo;
    }

    @Override
    public String toString() {
    return "assunto: "+assunto+"| conteudo: "+conteudo;
    }

    
    
 
    
    
}
