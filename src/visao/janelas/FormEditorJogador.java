package visao.janelas;

import controle.Configurador;
import modelo.jogo.CartaAbstrata;
import visao.GUIEditorDejogador;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.event.ListSelectionListener;
import visao.VCarta;

public class FormEditorJogador extends JInternalFrame implements GUIEditorDejogador {

    public FormEditorJogador() {
          setMaximizable(true);
        setClosable(true);
        initComponents();
    }

    public FormEditorJogador(String rotuloCartasEsquerda, String rotuloCartasDireita, String rotuloBtSalvar) {
        initComponents();
        jLEsquerda.setText(rotuloCartasEsquerda);
        jLDireita.setText(rotuloCartasDireita);
        jBSalvar.setText(rotuloBtSalvar);
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
        jLEsquerda = new javax.swing.JLabel();
        jLDireita = new javax.swing.JLabel();
        jTMsg = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jPJogadorLayout = new javax.swing.GroupLayout(jPJogador);
        jPJogador.setLayout(jPJogadorLayout);
        jPJogadorLayout.setHorizontalGroup(
            jPJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        jPJogadorLayout.setVerticalGroup(
            jPJogadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPAcervoLayout = new javax.swing.GroupLayout(jPAcervo);
        jPAcervo.setLayout(jPAcervoLayout);
        jPAcervoLayout.setHorizontalGroup(
            jPAcervoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );
        jPAcervoLayout.setVerticalGroup(
            jPAcervoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLJogador.setToolTipText("");
        jScrollPane1.setViewportView(jLJogador);

        jLAcervo.setToolTipText("");
        jScrollPane2.setViewportView(jLAcervo);

        jBAdicionar.setText("<< adicionar");

        jBRemover.setText("remover >>");

        jBSalvar.setText("salvar");

        jLabel1.setText("Mensagem:");

        jLEsquerda.setText("Cartas do jogador:");

        jLDireita.setText("Cartas do acervo:");

        jTMsg.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jPJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLEsquerda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPAcervo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(jLDireita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(13, 13, 13))
                    .addComponent(jTMsg)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBSalvar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(808, 808, 808)))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPAcervo, jPJogador});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane1, jScrollPane2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLEsquerda)
                            .addComponent(jLDireita))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPAcervo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jBAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBRemover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 221, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jBSalvar)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBAdicionar, jBRemover});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdicionar;
    private javax.swing.JButton jBRemover;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JList jLAcervo;
    private javax.swing.JLabel jLDireita;
    private javax.swing.JLabel jLEsquerda;
    private javax.swing.JList jLJogador;
    private javax.swing.JLabel jLabel1;
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
    public void listarCartasDoJogador(List<CartaAbstrata> j) {
        DefaultListModel<VCarta> model = new DefaultListModel<>();

        for (CartaAbstrata carta : j) {
            model.addElement(new VCarta(carta));
        }

        
        try {
            
        jLJogador.setModel(model);    
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        

    }

    @Override
    public void listarCartasDoAcervo(List<CartaAbstrata> j) {
        DefaultListModel<VCarta> model = new DefaultListModel<>();

        for (CartaAbstrata carta : j) {
            model.addElement(new VCarta(carta));
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
    public CartaAbstrata obterCartaSelecionadaDoAcervo() {
        VCarta selecionada = (VCarta) jLAcervo.getSelectedValue();
        return selecionada.obterCarta();

    }

    @Override
    public CartaAbstrata obterCartaSelecionadaDoJogador() {
        VCarta selecionada = (VCarta) jLJogador.getSelectedValue();
        return selecionada.obterCarta();
    }

    @Override
    public void mostrarCartaDoAcervo(CartaAbstrata c) {
        ((PainelCarta) jPAcervo).mostrarCarta(c);
    }

    @Override
    public void mostrarCartaDoJogador(CartaAbstrata c) {
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

    @Override
    public void fechar() {
        dispose();
    }

}
