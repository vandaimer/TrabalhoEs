package testes.jean;

import modelo.ConectorCliente;
import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;

public class Teste implements Runnable {

    private ConectorCliente cli;

    public Teste(ConectorCliente cli) {
        this.cli = cli;
    }

    public static void main(String[] args) throws IOException {
        ServerSocket sv = new ServerSocket(1234);

        while (true) {

            System.out.println("Aguardando conexao");
            ConectorCliente cli = new ConectorCliente(sv.accept());
            new Thread(new Teste(cli)).start();

        }

    }

    @Override
    public void run() {
        cli.enviar("conexao_aceita");

        while (true) {
            Serializable receber = cli.receber();
            
            if (receber==null) {
                break;
            }
            
            System.out.println(receber);

            
        }

        System.out.println("fim conexao");

    }
}
