import Modelo.Portal;
import Modelo.Jogador;

public class Principal
{
    public static void main(String[] args)
    {
        Portal p = new Portal();
        p.criarJogador( new Jogador("LUIZ","12345") );
        p.setJogador( new Jogador("OUTRO USUARIO","SENHA DELE") );
        p.autenticar();
    }
}