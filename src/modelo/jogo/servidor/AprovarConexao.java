

package modelo.jogo.servidor;

import modelo.util.Conector;

class AprovarConexao implements Runnable {

    private final Conector _con;
    private final Servico _s;

    public AprovarConexao(Conector con, Servico s) {
        _con = con;
        _s = s;
    }

    @Override
    public void run() {
        _s.aprovarConexao(_con);
    }

}