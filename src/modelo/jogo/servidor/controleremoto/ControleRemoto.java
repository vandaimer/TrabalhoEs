package modelo.jogo.servidor.controleremoto;


import modelo.metodoremoto.MetodoRemotoControleRemoto;
import modelo.metodoremoto.SinalizarReconhecimento;
import modelo.metodoremoto.Jogar;
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
        tel.falar(new Jogar(cartas));
    }

    public void iniciar() {
        tel.ligar();
        tel.registrar(this);
        SinalizarReconhecimento sr = new SinalizarReconhecimento();
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
