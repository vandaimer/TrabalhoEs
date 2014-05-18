import Controle.Portal;
import Modelo.Jogador;
import com.sun.swing.internal.plaf.synth.resources.synth_sv;

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