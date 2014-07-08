package visao.janelas;

import visao.GUIVisualizadorDeCartas;
import controle.Configurador;

import modelo.jogo.CartaAbstrata;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionListener;
import visao.VCarta;

public class FormVisualizadorDeCartas extends javax.swing.JFrame implements GUIVisualizadorDeCartas {

    public FormVisualizadorDeCartas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLCartas = new javax.swing.JList();
        jPApresentacaoCarta = new PainelCarta();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jLCartas);

        javax.swing.GroupLayout jPApresentacaoCartaLayout = new javax.swing.GroupLayout(jPApresentacaoCarta);
        jPApresentacaoCarta.setLayout(jPApresentacaoCartaLayout);
        jPApresentacaoCartaLayout.setHorizontalGroup(
            jPApresentacaoCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPApresentacaoCartaLayout.setVerticalGroup(
            jPApresentacaoCartaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jPApresentacaoCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPApresentacaoCarta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jLCartas;
    private javax.swing.JPanel jPApresentacaoCarta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrar(CartaAbstrata c) {
        ((PainelCarta) jPApresentacaoCarta).mostrarCarta(c);
    }

    @Override
    public void listarCartas(List<CartaAbstrata> l) {
        DefaultListModel<VCarta> model = new DefaultListModel();

        for (CartaAbstrata carta : l) {
            model.addElement(new VCarta(carta));
        }

        jLCartas.setModel(model);
    }

    @Override
    public void selecionarUmaCarta(ListSelectionListener a) {
        jLCartas.addListSelectionListener(a);
    }

    @Override
    public CartaAbstrata obterCartaSelecionada() {
        VCarta selecionada = (VCarta) jLCartas.getSelectedValue();
        return selecionada.obterCarta();
    }

    @Override
    public void aplicarConfiguracao(Configurador<GUIVisualizadorDeCartas> conf) {
        conf.configurar(this);
    }

    @Override
    public void tornarVisivel(boolean b) {
        setVisible(b);
    }
}
