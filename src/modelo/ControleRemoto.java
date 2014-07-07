package modelo;


import java.io.Serializable;
import java.util.List;
import testes.jean.Telefone;

public class ControleRemoto extends ObservadoImpl implements Observador {

    private Jogador _jgd;
    private Telefone tel;

    
    public ControleRemoto(Jogador _jgd, Conector con) {
        this._jgd = _jgd;
        tel = new Telefone(con);
    }

    public void jogar(List<Carta> cartas) {
        Baralho b = new Baralho();
        b.montarBaralho(cartas);
        Jogada jgda = new Jogada(b);
        tel.falar(new Jogar(_jgd, jgda));
    }

    public void iniciar() {
        tel.ligar();
        tel.registrar(this);
        SinalizarReconhecimento sr = new SinalizarReconhecimento(_jgd);
        tel.falar(sr);
    }

    

    @Override
    public void notificar(Observado fonte, Object leitura) {

        if (leitura instanceof Mensagem) {

            Mensagem msg = (Mensagem) leitura;

            if ("iniciar_turno".equals(msg.obterAssunto())) {

                notificarObservadores("iniciar_turno");
                return;
            }

            if ("jogada_realizada".equals(msg.obterAssunto())) {
                Serializable conteudo = msg.obterConteudo();

                if (_jgd.equals(conteudo)) {
                    notificarObservadores("jogada_realizada");
                }
                return;
            }

            if ("atualizar_pontuacao".equals(msg.obterAssunto())) {

                notificarObservadores("atualizar_pontuacao");
                return;
            }

            if ("fim_do_jogo".equals(msg.obterAssunto())) {
                notificarObservadores("fim_do_jogo");
                tel.desligar();
                return;
            }

        }

    }

}
