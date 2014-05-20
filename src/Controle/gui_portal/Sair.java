package Controle.gui_portal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Sair implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do programa","Game",JOptionPane.YES_NO_OPTION);

        if (JOptionPane.OK_OPTION == opcao) {
            System.exit(0);
        }

    }

}