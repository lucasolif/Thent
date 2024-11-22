
package view.carregamentoConsultas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Livro;
import interfaces.ConsultaLivros;

public class TelaConsultasLivros extends javax.swing.JDialog {
    
    private ConsultaLivros consultaLivros;

    public TelaConsultasLivros(java.awt.Frame onwer, List<Livro> listaLivros) {
        super(onwer, true);
        initComponents();
        carregarLivrosCosultados(listaLivros);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultasLivro = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem Livros Consultado");

        tabelaConsultasLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Livro", "Autor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaConsultasLivro);
        if (tabelaConsultasLivro.getColumnModel().getColumnCount() > 0) {
            tabelaConsultasLivro.getColumnModel().getColumn(0).setResizable(false);
            tabelaConsultasLivro.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaConsultasLivro.getColumnModel().getColumn(1).setResizable(false);
            tabelaConsultasLivro.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaConsultasLivro.getColumnModel().getColumn(2).setResizable(false);
            tabelaConsultasLivro.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        btnSelecionar.setBackground(new java.awt.Color(0, 153, 255));
        btnSelecionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSelecionar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSelecionar)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        livroEscolhido();
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void carregarLivrosCosultados(List<Livro> listaLivros){         
        for(Livro lv : listaLivros){        
            DefaultTableModel model = (DefaultTableModel) this.tabelaConsultasLivro.getModel();    
            model.addRow(new Object[]{lv.getCodLivro(),lv, lv.getAutor()});
        }
    }
    
    private void livroEscolhido(){
        int linhaSelec = this.tabelaConsultasLivro.getSelectedRow();
        if(linhaSelec >= 0){
            Livro livro = (Livro)this.tabelaConsultasLivro.getModel().getValueAt(linhaSelec, 1); 
            this.consultaLivros.livroSelecionado(livro);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Não foi selecionado nenhum livro", "Atenção", JOptionPane.WARNING_MESSAGE);     
        }
    }
    
    public void setLivroSelecionada(ConsultaLivros consultaLivros) {
        this.consultaLivros = consultaLivros;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabelaConsultasLivro;
    // End of variables declaration//GEN-END:variables
}
