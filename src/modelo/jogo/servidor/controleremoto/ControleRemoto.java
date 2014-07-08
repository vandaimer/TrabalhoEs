package modelo.jogo.servidor.controleremoto;

import modelo.metodoremoto.MetodoRemotoControleRemoto;
import modelo.metodoremoto.SinalizarReconhecimento;
import modelo.metodoremoto.Jogar;
import modelo.jogo.CartaAbstrata;
import modelo.jogo.Jogador;
import modelo.jogo.Carta;
import modelo.jogo.partida.InformacaoDoTurno;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import modelo.util.Conector;
import modelo.util.ObservadoImpl;
import modelo.util.Observador;
import modelo.jogo.servidor.Telefone;

public class ControleRemoto extends ObservadoImpl implements Observador {

    private Jogador _jgd;
    private Telefone tel;
    private List<InformacaoDoTurno> infoTurno;

    public ControleRemoto(Jogador _jgd, Conector con) {
        this._jgd = _jgd;
        tel = new Telefone(con);

    }
    //poderia gerar a excecao de validacao de mao?
    public void jogar(List<CartaAbstrata> cartas) {
        tel.falar(new Jogar(cartas));
    }

    public List<CartaAbstrata> baralhoDoJogador() {
        return _jgd.obterCartasAtuais();
    }

    public void iniciar() {
        tel.ligar();
        tel.registrar(this);
        SinalizarReconhecimento sr = new SinalizarReconhecimento();
        tel.falar(sr);
    }

    void finalizar() {
        tel.desligar();
    }

    public void atualizarPontuacao(Serializable pontuacao) {
        infoTurno = (List<InformacaoDoTurno>) pontuacao;
    }
    
    public List<InformacaoDoTurno> getListaInformacaoTurno(){
    	return infoTurno;
    }
    

    @Override
    public void notificar(Object fonte, Object msg) {

        if (msg instanceof MetodoRemotoControleRemoto) {
            MetodoRemotoControleRemoto m = (MetodoRemotoControleRemoto) msg;
            m.aceitar(this);

        }

    }

}
