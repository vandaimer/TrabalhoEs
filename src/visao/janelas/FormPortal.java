
package visao.janelas;

import visao.GUIPortal;
import controle.Configurador;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public class FormPortal extends javax.swing.JFrame implements GUIPortal {
    
    public FormPortal() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBAutenticar = new javax.swing.JButton();
        jBNovoJogador = new javax.swing.JButton();
        jBAcervoDeCartas = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();
        jBEditarBaralho = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBAutenticar.setText("Autenticar");

        jBNovoJogador.setText("Novo Jogador");

        jBAcervoDeCartas.setText("Acervo De Cartas");

        jBSair.setText("Sair");

        jBEditarBaralho.setText("Editar Baralho");
        jBEditarBaralho.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAutenticar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBNovoJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBAcervoDeCartas, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                    .addComponent(jBSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBEditarBaralho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAutenticar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBNovoJogador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBAcervoDeCartas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jBEditarBaralho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBSair)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(408, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAcervoDeCartas;
    private javax.swing.JButton jBAutenticar;
    private javax.swing.JButton jBEditarBaralho;
    private javax.swing.JButton jBNovoJogador;
    private javax.swing.JButton jBSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void autenticarJogador(ActionListener a) {
        jBAutenticar.addActionListener(a);
    }
    
    @Override
    public void editarBaralho(ActionListener a) {
        jBEditarBaralho.addActionListener(a);
    }
    
   

    
    @Override
    public void visualizarAcervo(ActionListener a) {
        jBAcervoDeCartas.addActionListener(a);
    }
    
    @Override
    public void aplicarConfiguracao(Configurador<GUIPortal> conf) {
        conf.configurar(this);
    }

    @Override
    public void novoJogador(ActionListener a)
    {
    	jBNovoJogador.addActionListener(a);
    }

    @Override
    public void habilitarAutenticarJogador(boolean b) {
    jBAutenticar.setEnabled(b);
    }

    @Override
    public void habilitarNovoJogador(boolean b) {
    jBNovoJogador.setEnabled(b);
    }

    @Override
    public void habilitarEditarBaralho(boolean b) {
    jBEditarBaralho.setEnabled(b);
    }

    @Override
    public void habilitarVisualizarAcervo(boolean b) {
    jBAcervoDeCartas.setEnabled(b);
    }

    @Override
    public void tornarVisivel(boolean v) {
        setVisible(v);
    }

    @Override
    public void sair(ActionListener a)
    {
    	jBSair.addActionListener(a);
    }
}
