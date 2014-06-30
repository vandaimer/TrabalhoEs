package Modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Jogador {

    private Baralho baralho = new Baralho();
    private String nome;
    private String senha;
    private int id;

    public Jogador(String nome, String senha)
    {
        this.nome = nome;
        this.senha = senha;
    }

    public Jogador(Jogador j)
    {
        this.nome = j.nome;
        this.senha = j.senha;
        this.baralho = new Baralho(j.baralho);
    }

    public void adicionarCarta(Carta c)
    {
        baralho.adicionar(c);
    }

    public void adicionarCarta(List<Carta> c) {
        baralho.montarBaralho(c);
    }

    public List<ErroDeValidacao> validarBaralho() {
//        return baralho.validar(new ValidacaoBaralhoComRegrasDoJogo(40,60,2));
        return baralho.validar(new ValidacaoBaralhoComRegrasDoJogo());
    }

    public List<Carta> obterCartasAtuais()
    {

        return baralho.listarCartas();
    }

    public void remover(Carta c) {
        baralho.remover(c);
    }

    public void editarBaralho(Carta c, int opcao) {
        if (opcao == 0) {
            baralho.adicionar(c);
        } else {
            baralho.remover(c);
        }
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

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"nome\":\"");
        sb.append(nome);
        sb.append("\"}");
        return sb.toString();
    }

    public String getNome()
    {
        return this.nome;
    }
    public String getSenha()
    {
        return this.senha;
    }

    public int getId()
    {
        return this.id;
    }
    public void setID( int id )
    {
        this.id = id;
    }
}