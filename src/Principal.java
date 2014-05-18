
import Modelo.Portal;
import Modelo.Jogador;

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
    
    public static void main(String[] args) {
        fixarTemaJava();
        
        Portal p = new Portal();
        p.criarJogador(new Jogador("LUIZ", "12345"));
        p.autenticar(new Jogador("OUTRO USUARIO", "SENHA DELE"));
    }
}
