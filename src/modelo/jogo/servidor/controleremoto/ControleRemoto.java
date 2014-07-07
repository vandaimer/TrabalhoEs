package modelo.jogo.servidor.controleremoto;


import modelo.metodoremoto.MetodoRemotoControleRemoto;
import modelo.metodoremoto.SinalizarReconhecimento;
import modelo.jogo.Jogada;
import modelo.metodoremoto.Jogar;
import modelo.jogo.Baralho;
import modelo.jogo.Jogador;
import modelo.jogo.Carta;
import java.util.List;
import modelo.util.Conector;
import modelo.util.ObservadoImpl;
import modelo.util.Observador;
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

    void finalizar(){
    tel.desligar();
    }

    @Override
    public void notificar(Object fonte, Object msg) {

        if (msg instanceof MetodoRemotoControleRemoto) {
           MetodoRemotoControleRemoto m=(MetodoRemotoControleRemoto)msg;
           m.aceitar(this);

        }

    }

}
