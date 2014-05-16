import java.util.List;

public class Portal implements Observador,Observado
{
    private RepositorioDoJogo repositorioJogo;
    private Jogador jogador;

    public void autenticar()
    {

    }

    @Override
    public void registrar(Observador o) {

    }

    @Override
    public void remover(Observador o) {

    }

    @Override
    public void notificarObservadores(Object msg) {

    }

    @Override
    public void notificar(Observado fonte, Object msg) {

    }

    public void criarJogador( Jogador j )
    {

    }

    public List<Carta> obterAcervo()
    {
        return null;
    }

    public Jogador obterJogadorLogado()
    {
        return new Jogador();
    }

    public void salvarJogador( Jogador jogador )
    {

    }
}