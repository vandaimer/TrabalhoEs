package testes.jean;

import modelo.ConectorCliente;
import modelo.Observado;
import modelo.Observador;

public class TesteTelefone {

    public static void main(String[] args) {
        
        ConectorCliente c = new ConectorCliente("localhost", 1234);
        Telefone t = new Telefone(c);
        t.registrar(new Observador() {

            @Override
            public void notificar(Observado fonte, Object msg) {
                System.out.println("ouvi: "+msg);
            }
        });

        t.ligar();
        
        for (int i = 0; i < 10; i++) {

            t.falar("falei se fode " + i);

        }
        
        //t.desligar();
    }

}
