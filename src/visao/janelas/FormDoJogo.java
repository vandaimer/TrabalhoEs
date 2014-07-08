package visao.janelas;

import controle.Configurador;
import controle.configuradores_gui.ConfiguradorVisualizadorDeCartas;
import controle.gui_visualizador_de_cartas.SelecionarUmaCarta;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.jogo.Jogada;
import modelo.jogo.partida.InformacaoDoTurno;
import visao.GUIJogo;

public class FormDoJogo extends JInternalFrame implements GUIJogo {

    public FormDoJogo() {
        setClosable(true);
        initComponents();

        class Acao implements ListSelectionListener {

            private PlacarAtual p;

            public Acao(PlacarAtual p) {
                this.p = p;
            }

            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {

                    p.mostrar(p.obterCartaSelecionada());

                } catch (Exception ex) {

                }

            }

        }

        placarP1.selecionarUmaCarta(new Acao(placarP1));
        placarP2.selecionarUmaCarta(new Acao(placarP2));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        placarP1 = new visao.janelas.PlacarAtual();
        placarP2 = new visao.janelas.PlacarAtual();
        jLP1 = new javax.swing.JLabel();
        jLP2 = new javax.swing.JLabel();
        jBMontar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLP1.setText(" ");

        jLP2.setText(" ");

        jBMontar.setText("Montar Jogada");
        jBMontar.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador", "Turno", "Pontuacao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(placarP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLP2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBMontar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLP1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(placarP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLP2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(placarP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBMontar)
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JButton jBMontar;
    private javax.swing.JLabel jLP1;
    private javax.swing.JLabel jLP2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private visao.janelas.PlacarAtual placarP1;
    private visao.janelas.PlacarAtual placarP2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void habilitarMontarJogada(boolean b) {
        jBMontar.setEnabled(b);
    }

    @Override
    public void habilitarVisualizarPontuacao(boolean b) {

    }

    @Override
    public void aplicarConfiguracao(Configurador<GUIJogo> conf) {
        conf.configurar(this);
    }

    @Override
    public void quandorMontarJogada(ActionListener c) {
        jBMontar.addActionListener(c);
    }

    @Override
    public void quandorVisualizarPontuacao(ActionListener c) {

    }

    @Override
    public void tornarVisivel(boolean b) {
        setVisible(b);
    }

    @Override
    public void fechar() {
        dispose();
    }

    @Override
    public void mostrasMensagem(String m) {
        JOptionPane.showMessageDialog(this, m);
    }

    @Override
    public void atualizarPlacar(List<InformacaoDoTurno> info) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (info != null && info.size() == 2) {

            InformacaoDoTurno it;

            it = info.get(0);

            jLP1.setText(it.obterJogada().getJogador().getNome() + " turno: " + it.obterTurno());
            placarP1.listarCartas(it.obterJogada().getBaralhoJogada().listarCartas());
            model.addRow(new Object[]{it.obterJogada().getJogador().getNome(), it.obterTurno(), it.obterPontuacao()});

            it = info.get(1);
            model.addRow(new Object[]{it.obterJogada().getJogador().getNome(), it.obterTurno(), it.obterPontuacao()});
            jLP2.setText(it.obterJogada().getJogador().getNome() + " turno: " + it.obterTurno());
            placarP2.listarCartas(it.obterJogada().getBaralhoJogada().listarCartas());

        }

    }

}
