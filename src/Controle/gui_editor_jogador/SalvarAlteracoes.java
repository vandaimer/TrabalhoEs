package Controle.gui_editor_jogador;

import Modelo.ErroDeValidacao;
import Modelo.Jogador;
import Modelo.Portal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class SalvarAlteracoes implements ActionListener {
    
    private Portal portal;
    private Jogador jgd;
    
    public SalvarAlteracoes(Portal portal, Jogador jgd) {
        this.portal = portal;
        this.jgd = jgd;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        List<ErroDeValidacao> erros = new LinkedList();
        ErroDeValidacao validarBaralho = jgd.validarBaralho();
        erros.add(validarBaralho);
        
        StringBuilder sb = new StringBuilder();
        
        if (erros.isEmpty()) {
            
            boolean salvou = portal.salvarJogador(jgd);
            
            if (salvou) {
                
                sb.append("Alteracoes salvas com sucesso");
                sb.append('\n');
            } else {
                
                sb.append("Falha ao salvar");
                sb.append('\n');
            }
            
        } else {
            
            sb.append("Lista de Erros: ");
            sb.append('\n');
            
            for (ErroDeValidacao erro : erros) {
                sb.append(erro);
                sb.append('\n');
            }
            
            sb.append("As alteracoes nao foram realizadas, tente novamente.");
            sb.append('\n');
            
        }
        
        JOptionPane.showMessageDialog(null, sb);
    }
    
}
