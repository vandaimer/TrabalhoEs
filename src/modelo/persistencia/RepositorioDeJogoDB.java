package modelo.persistencia;

import modelo.persistencia.RepositorioDoJogo;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogador;
import modelo.jogo.Carta;
import modelo.persistencia.FabricaFerramentasPersistencia;
import modelo.persistencia.MapeadorEntidadesDoJogo;

import java.util.List;

public class RepositorioDeJogoDB implements RepositorioDoJogo
{
    private FabricaFerramentasPersistencia fabrica;
    private MapeadorEntidadesDoJogo mapeador;

    public RepositorioDeJogoDB( FabricaFerramentasPersistencia fabrica )
    {
        this.fabrica = fabrica;
        this.mapeador = fabrica.obterMapeador();
    }

    @Override
    public List<CartaAbstrata> obterCartasDoAcervo() throws ExcecaoDePersistencia
    {
        return  this.mapeador.obterCartasDoAcervo( this.fabrica.obterConexao() );
    }

    @Override
    public List<CartaAbstrata> filtrarAcervo(int filtro) throws ExcecaoDePersistencia {
        return this.mapeador.filtrarAcervo( this.fabrica.obterConexao(), filtro );
    }

    @Override
    public boolean autenticar(Jogador j) throws ExcecaoDePersistencia
    {
        return this.mapeador.autenticarJogador( fabrica.obterConexao(), j );
    }

    @Override
    public boolean salvar(Jogador j) throws ExcecaoDePersistencia
    {
        return this.mapeador.salvarJogador( this.fabrica.obterConexao(), j );
    }

    @Override
    public Jogador pesquisarPorChave(String id) throws ExcecaoDePersistencia
    {
        /*
            Ainda usa string, pois acho que nem todos usam o banco, ai iria quebrar o repositorioMemoria,
            E arruma o Memoria,não vale o trabalho, pois não ira mais ser usado
         */
        return this.mapeador.pesquisarPorChave( this.fabrica.obterConexao(),id );
    }
}
