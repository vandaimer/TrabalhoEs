package Visao.janelas;

import Controle.Configurador;
import Modelo.Carta;
import Visao.GUIEditorDejogador;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;

public class FormEditorJogador extends javax.swing.JFrame implements GUIEditorDejogador {
    
    public FormEditorJogador() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPJogador = new PainelCarta();
        jPAcervo = new PainelCarta();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLJogador = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLAcervo = new javax.swing.JList();
        jBAdicionar = new javax.swing.JButton();
        jBRemover = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTMsg = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPJogadorLayout = new javax.swing.GroupLayout(jPJogador);
        jPJogador.setLayout(jPJogadorLayout);
        jPJogadorLayout.setHorizontalGroup(
            jPJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPJogadorLayout.setVerticalGroup(
            jPJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPAcervoLayout = new javax.swing.GroupLayout(jPAcervo);
        jPAcervo.setLayout(jPAcervoLayout);
        jPAcervoLayout.setHorizontalGroup(
            jPAcervoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPAcervoLayout.setVerticalGroup(
            jPAcervoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 205, Short.MAX_VALUE)
        );

        jLJogador.setToolTipText("");
        jScrollPane1.setViewportView(jLJogador);

        jLAcervo.setToolTipText("");
        jScrollPane2.setViewportView(jLAcervo);

        jBAdicionar.setText("<< adicionar");

        jBRemover.setText("remover >>");

        jBSalvar.setText("salvar");

        jLabel1.setText("Mensagem:");

        jLabel2.setText("Cartas do jogador:");

        jLabel3.setText("Cartas do acervo:");

        jTMsg.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSalvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPAcervo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jTMsg))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPAcervo, jPJogador, jScrollPane1, jScrollPane2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPAcervo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(312, Short.MAX_VALUE)
                        .addComponent(jBAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBRemover)
                        .addGap(52, 52, 52)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPAcervo, jPJogador});

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
    private javax.swing.JButton jBAdicionar;
    private javax.swing.JButton jBRemover;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JList jLAcervo;
    private javax.swing.JList jLJogador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPAcervo;
    private javax.swing.JPanel jPJogador;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTMsg;
    // End of variables declaration//GEN-END:variables

    @Override
    public void adicionarUmaCarta(ActionListener a) {
        jBAdicionar.addActionListener(a);
    }
    
    @Override
    public void removerUmaCarta(ActionListener a) {
        jBRemover.addActionListener(a);
    }
    
    @Override
    public void listarCartasDoJogador(List<Carta> j) {
        DefaultListModel<Carta> model = new DefaultListModel<>();
        
        for (Carta carta : j) {
            model.addElement(carta);
        }
        
        jLJogador.setModel(model);
        
    }
    
    @Override
    public void listarCartasDoAcervo(List<Carta> j) {
        DefaultListModel<Carta> model = new DefaultListModel<>();
        
        for (Carta carta : j) {
            model.addElement(carta);
        }
        
        jLAcervo.setModel(model);
        
    }
    
    @Override
    public void quandoSelecionarUmaCartaDoAcervo(ListSelectionListener ls) {
        jLAcervo.addListSelectionListener(ls);
    }
    
    @Override
    public void quandoSelecionarUmaCartaDoJogador(ListSelectionListener ls) {
        jLJogador.addListSelectionListener(ls);
    }
    
    @Override
    public Carta obterCartaSelecionadaDoAcervo() {
        return (Carta) jLAcervo.getSelectedValue();
        
    }
    
    @Override
    public Carta obterCartaSelecionadaDoJogador() {
        return (Carta) jLJogador.getSelectedValue();
    }
    
    @Override
    public void mostrarCartaDoAcervo(Carta c) {
        ((PainelCarta) jPAcervo).mostrarCarta(c);
    }
    
    @Override
    public void mostrarCartaDoJogador(Carta c) {
        ((PainelCarta) jPJogador).mostrarCarta(c);
    }
    
    @Override
    public void salvarAlteracoes(ActionListener a) {
        jBSalvar.addActionListener(a);
    }
    
    @Override
    public void tornarVisivel(boolean b) {
        setVisible(b);
    }
    
    @Override
    public void aplicarConfiguracao(Configurador<GUIEditorDejogador> conf) {
        conf.configurar(this);
    }

    @Override
    public void exibirMensagem(String msg) {
    jTMsg.setText(msg);
    }
}
