package modelo;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class ControleRemoto extends ObservadoImpl {

    private Jogador _jgd;
    private Conector con;
    private Thread tNotificao;

    public ControleRemoto(Jogador j, String ip, int porta)
            throws IOException, ExcececaoConexaoRecusada {

        _jgd = j;
        con = new ConectorCliente(ip, porta);

        if (!con.estaConectado()) {
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

        System.out.println(resposta);

        tNotificao = new Thread(new LeitorDeNotificacao(con, this));
        tNotificao.start();

    }

    public void jogar(List<Carta> cartas) {

        Baralho b = new Baralho();
        b.montarBaralho(cartas);
        Jogada jgda = new Jogada(b);
        con.enviar(new Jogar(_jgd, jgda));
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        tNotificao.interrupt();
    }

    class LeitorDeNotificacao implements Runnable {

        private Conector _con;
        private ControleRemoto _ctr;

        public LeitorDeNotificacao(Conector con, ControleRemoto ctr) {
            _con = con;
            _ctr = ctr;
        }

        @Override
        public void run() {

            while (true) {

                Serializable leitura = _con.receber();

                if (leitura instanceof Mensagem) {
                    Mensagem msg = (Mensagem) leitura;

                    if ("jogada_realizada".equals(msg.obterAssunto())) {
                        Serializable conteudo = msg.obterConteudo();

                        if (_jgd.equals(conteudo)) {
                            //faca algo
                        }

                    }

                }

            }

        }

    }

}
