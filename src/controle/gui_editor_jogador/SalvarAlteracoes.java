package controle.gui_editor_jogador;

import modelo.Jogador;
import modelo.Portal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ExcecaoDePersistencia;
import modelo.ExcecaoQuebraDeRegrasDoBaralho;

public class SalvarAlteracoes implements ActionListener {

    private Portal portal;
    private Jogador jgd;

    public SalvarAlteracoes(Portal portal, Jogador jgd) {
        this.portal = portal;
        this.jgd = jgd;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder();

        try {

            jgd.validarBaralho();
            if (portal.salvarJogador(jgd)) {

                sb.append("Alteracoes salvas com sucesso");
                sb.append('\n');

            }

        } catch (ExcecaoQuebraDeRegrasDoBaralho | ExcecaoDePersistencia ex) {
            sb.append(ex);
        }
        
        JOptionPane.showMessageDialog(null, sb);

    }

}
