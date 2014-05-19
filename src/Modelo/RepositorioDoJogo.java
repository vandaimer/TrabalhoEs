package Modelo;

import java.util.List;

public interface RepositorioDoJogo
{
    public List<Carta> obterCartasDoAcervo();
    public boolean autenticar( Jogador j );
    public boolean salvar( Jogador j );
    public Jogador pesquisarPorChave(String id);
}