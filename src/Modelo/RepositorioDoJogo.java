package Modelo;

import java.util.List;

public interface RepositorioDoJogo
{
    public List<Carta> obterCartasDoAcervo();
    public boolean autenticar( Jogador j ) throws Exception;
    public boolean salvar( Jogador j ) throws Exception;
    public Jogador pesquisarPorChave(String id) throws Exception;
}