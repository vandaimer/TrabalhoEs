package visao.janelas;

import visao.GUIPortal;
import controle.Configurador;
import java.awt.Desktop;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class FormPortal extends javax.swing.JFrame implements GUIPortal {

    public FormPortal() {
        initComponents();
        Dimension sz = getToolkit().getScreenSize();
        sz.setSize(sz.width, sz.height-100);
        
        
        
        setPreferredSize(sz);
        jDesktopPane1.setPreferredSize(sz);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMAutenticar = new javax.swing.JMenuItem();
        jMNovoJogador = new javax.swing.JMenuItem();
        jMAcervo = new javax.swing.JMenuItem();
        jMCriarPartida = new javax.swing.JMenuItem();
        jMConectarAoOponente = new javax.swing.JMenuItem();
        jMEditarBaralho = new javax.swing.JMenuItem();
        jMSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 863, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 617, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMAutenticar.setText("Autenticar");
        jMenu1.add(jMAutenticar);

        jMNovoJogador.setText("Novo Jogador");
        jMenu1.add(jMNovoJogador);

        jMAcervo.setText("Acervo De Cartas");
        jMenu1.add(jMAcervo);

        jMCriarPartida.setText("Criar Partida");
        jMenu1.add(jMCriarPartida);

        jMConectarAoOponente.setText("Conectar ao Oponente");
        jMenu1.add(jMConectarAoOponente);

        jMEditarBaralho.setText("Editar Baralho");
        jMenu1.add(jMEditarBaralho);

        jMSair.setText("Sair");
        jMenu1.add(jMSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jMAcervo;
    private javax.swing.JMenuItem jMAutenticar;
    private javax.swing.JMenuItem jMConectarAoOponente;
    private javax.swing.JMenuItem jMCriarPartida;
    private javax.swing.JMenuItem jMEditarBaralho;
    private javax.swing.JMenuItem jMNovoJogador;
    private javax.swing.JMenuItem jMSair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void autenticarJogador(ActionListener a) {
        jMAutenticar.addActionListener(a);
    }

    @Override
    public void editarBaralho(ActionListener a) {
        jMEditarBaralho.addActionListener(a);
    }

    @Override
    public void visualizarAcervo(ActionListener a) {
        jMAcervo.addActionListener(a);
    }

    @Override
    public void aplicarConfiguracao(Configurador<GUIPortal> conf) {
        conf.configurar(this);
    }

    @Override
    public void novoJogador(ActionListener a) {
        jMNovoJogador.addActionListener(a);
    }

    @Override
    public void habilitarAutenticarJogador(boolean b) {
        jMAutenticar.setEnabled(b);
    }

    @Override
    public void habilitarNovoJogador(boolean b) {
        jMNovoJogador.setEnabled(b);
    }

    @Override
    public void habilitarEditarBaralho(boolean b) {
        jMEditarBaralho.setEnabled(b);
    }

    @Override
    public void habilitarVisualizarAcervo(boolean b) {
        jMAcervo.setEnabled(b);
    }

    @Override
    public void tornarVisivel(boolean v) {
        setVisible(v);
    }

    @Override
    public void sair(ActionListener a) {
        jMSair.addActionListener(a);
    }

    @Override
    public void conectarAoOponente(ActionListener a) {
        jMConectarAoOponente.addActionListener(a);
    }

    @Override
    public void criarPartida(ActionListener a) {
        jMCriarPartida.addActionListener(a);
    }

    @Override
    public void habilitarConectarAoOponente(boolean b) {
        jMConectarAoOponente.setEnabled(b);
    }

    @Override
    public void habilitarCriarPartida(boolean b) {
        jMCriarPartida.setEnabled(b);
    }

    @Override
    public void mostrarMensagem(String m) {
        JOptionPane.showMessageDialog(this, m);

    }

    @Override
    public String mostrarJanelaDeEntradaSimples(String msg) {
        return JOptionPane.showInputDialog(this, msg);
    }

    @Override
    public void incluir(JInternalFrame j) {
        jDesktopPane1.add(j);
    }
}
