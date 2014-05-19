package main;


import Controle.configuradores_gui.ConfiguradorPortal;
import Modelo.Portal;
import Visao.janelas.FormPortal;
import Modelo.RepositorDeJogoEmMemoria;

public class Principal {

    public static void fixarTemaJava(){
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
    
    public static void iniciarFormularioDoPortal(){
        FormPortal fportal=new FormPortal();
        ConfiguradorPortal confp=new ConfiguradorPortal(new Portal(new RepositorDeJogoEmMemoria()));
        fportal.aplicarConfiguracao(confp);
        
    }
    public static void main(String[] args) {
        fixarTemaJava();
        iniciarFormularioDoPortal();
    }
}
