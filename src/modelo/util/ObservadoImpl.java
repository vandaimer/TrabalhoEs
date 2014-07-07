package modelo.util;

import modelo.util.Observador;
import java.util.LinkedList;

public class ObservadoImpl implements Observado {

    private final Observado fonte;
    private final LinkedList<Observador> observadores = new LinkedList<Observador>();

    public ObservadoImpl() {
       fonte=this;
    }

    public ObservadoImpl(Observado o) {
        fonte = o;
    }

    @Override
    public void registrar(Observador o) {
        observadores.add(o);
    }

    @Override
    public void remover(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores(Object msg) {

        for (Observador obs : observadores) {
            obs.notificar(fonte, msg);
        }
    }

}
