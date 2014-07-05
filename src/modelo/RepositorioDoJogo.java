package modelo;

import java.util.List;

public interface RepositorioDoJogo
{
    public List<Carta> obterCartasDoAcervo() throws ExcecaoDePersistencia;
    public boolean autenticar( Jogador j )  throws ExcecaoDePersistencia;
    public boolean salvar( Jogador j )  throws ExcecaoDePersistencia;
    public Jogador pesquisarPorChave(String id)  throws ExcecaoDePersistencia;
}