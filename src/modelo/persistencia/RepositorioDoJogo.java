package modelo.persistencia;

import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogador;
import modelo.jogo.Carta;

import java.util.List;

public interface RepositorioDoJogo
{
    public List<CartaAbstrata> obterCartasDoAcervo() throws ExcecaoDePersistencia;
    public List<CartaAbstrata> filtrarAcervo( int filtro) throws ExcecaoDePersistencia;
    public boolean autenticar(Jogador j)  throws ExcecaoDePersistencia;
    public boolean salvar(Jogador j)  throws ExcecaoDePersistencia;
    public Jogador pesquisarPorChave(String id)  throws ExcecaoDePersistencia;
}