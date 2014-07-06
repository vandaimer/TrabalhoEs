package main;


import controle.configuradores_gui.ConfiguradorPortal;
import modelo.Portal;
import modelo.RepositorioDeJogoDB;
import modelo.persistencia.Fabrica;
import modelo.persistencia.FabricaFerramentasPersistencia;
import visao.janelas.FormPortal;

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
        //ConfiguradorPortal confp=new ConfiguradorPortal(new Portal(new RepositorDeJogoEmMemoria()));

        /*
          Em banco de dados
         */
        FabricaFerramentasPersistencia fabrica = new Fabrica( "localhost","root","admin","EngenhariaSoftware");
        ConfiguradorPortal confp=new ConfiguradorPortal(new Portal(new RepositorioDeJogoDB( fabrica )));
        fportal.aplicarConfiguracao(confp);
        
    }
    
    public static void main(String[] args) throws Exception
    {
        fixarTemaJava();
        iniciarFormularioDoPortal();
    }
}
