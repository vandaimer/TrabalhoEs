package main;


import controle.configuradores_gui.ConfiguradorPortal;
import modelo.persistencia.ConexaoBanco;
import modelo.Portal;
import modelo.RepositorioDeJogoDB;
import visao.janelas.FormPortal;
import modelo.RepositorDeJogoEmMemoria;

import java.sql.Connection;
import java.sql.DriverManager;

public class Principal {

    public static void fixarTemaJava()
    {
     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
        
        }
    }
    
    public static void iniciarFormularioDoPortal() throws Exception
    {
        FormPortal fportal=new FormPortal();
        /*
          Em memoria
         */
        ConfiguradorPortal confp=new ConfiguradorPortal(new Portal(new RepositorDeJogoEmMemoria()));

        /*
          Em banco de dados
         */
        //ConfiguradorPortal confp=new ConfiguradorPortal(new Portal(new RepositorioDeJogoDB()));
        fportal.aplicarConfiguracao(confp);
        
    }
    
    public static void main(String[] args) throws Exception
    {
        fixarTemaJava();
        iniciarFormularioDoPortal();
    }
}
