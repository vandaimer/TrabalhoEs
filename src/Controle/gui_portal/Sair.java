package Controle.gui_portal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Sair implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int opcao = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do programa");

        if (JOptionPane.OK_OPTION == opcao) {
            System.exit(0);
        }

    }

}
