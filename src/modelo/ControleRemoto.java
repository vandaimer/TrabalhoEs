package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class ControleRemoto {

    private Jogador _jgd;
    private Conector con;

    public ControleRemoto(Jogador j, String ip, int porta)
            throws IOException, ExcececaoConexaoRecusada {

        _jgd = j;
        con = new ConectorCliente(ip, porta);

        if (con.estaConectado()) {
            throw new IOException("Falha ao conectar");
        }

        con.enviar(j);
        Serializable resposta = con.receber();

        if (resposta instanceof ExcececaoConexaoRecusada) {
            throw ((ExcececaoConexaoRecusada) resposta);
        }

        if (resposta instanceof Jogador && !((Jogador) resposta).equals(j)) {
            throw new IOException("Falha ao conectar");
        }

    }

    public void jogar(List<Carta> cartas) {

        Baralho b = new Baralho();
        b.montarBaralho(cartas);
        Jogada jgda = new Jogada(b);
        con.enviar(new Jogar(_jgd, jgda));
    }

}
