import java.util.List;

public class RepositorDeJogoEmMemoria implements RepositorioDoJogo
{
    private List<Carta> listaDeCartaACervo;
    private List<Jogador> listaJogador;

    @java.lang.Override
    public List<Carta> obterCartasDoAcervo()
    {
        return null;
    }

    @java.lang.Override
    public boolean autenticar( Jogador j )
    {
        return false;
    }

    @java.lang.Override
    public void salvar(Jogador j)
    {

    }
}