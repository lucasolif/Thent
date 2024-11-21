
package view.carregamentoConsultas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Campanha;
import interfaces.ConsultaCampanhas;


public class ResultadosConsultasCampanhas extends javax.swing.JDialog {
    
    private ConsultaCampanhas consultaCampanhas;
    
    public ResultadosConsultasCampanhas(java.awt.Frame owner, List<Campanha> listaCampanha) {
        super(owner, true);
        initComponents();
        carregarCampanhasCosultadas(listaCampanha);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaConsultasCampanhas = new javax.swing.JTable();
        btnEscolher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem Campanhas Consultada");

        tabelaConsultasCampanhas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Campanha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaConsultasCampanhas);
        if (tabelaConsultasCampanhas.getColumnModel().getColumnCount() > 0) {
            tabelaConsultasCampanhas.getColumnModel().getColumn(0).setResizable(false);
            tabelaConsultasCampanhas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaConsultasCampanhas.getColumnModel().getColumn(1).setResizable(false);
            tabelaConsultasCampanhas.getColumnModel().getColumn(1).setPreferredWidth(350);
        }

        btnEscolher.setBackground(new java.awt.Color(0, 153, 255));
        btnEscolher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEscolher.setText("Escolher");
        btnEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEscolher)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEscolher)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherActionPerformed
        campanhaEscolhida();
    }//GEN-LAST:event_btnEscolherActionPerformed

    //Adiciona na tabela do Dialogm as pessoas que foram consulta no "CadastrarCampanhaForm", para serem escolhidas
    private void carregarCampanhasCosultadas(List<Campanha> listaCampanha){         
        for(Campanha camp : listaCampanha){        
            DefaultTableModel model = (DefaultTableModel) this.tabelaConsultasCampanhas.getModel();    
            model.addRow(new Object[]{camp.getCodigo(),camp});
        }
    }
    
    //Escolhe a pessoa, chama o método do "CadastrarCampanhaForm", e envia a pessoa selecionada
    private void campanhaEscolhida(){
        int linhaSelec = this.tabelaConsultasCampanhas.getSelectedRow();
        if(linhaSelec >= 0){
            Campanha campanha = (Campanha)this.tabelaConsultasCampanhas.getModel().getValueAt(linhaSelec, 1); 
            this.consultaCampanhas.campanhaSelecionada(campanha);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Não foi selecionado nenhuma campanha", "Atenção", JOptionPane.WARNING_MESSAGE);     
        }
    }
    
    public void setCampanhaSelecionada(ConsultaCampanhas consultaCampanhas) {
        this.consultaCampanhas = consultaCampanhas;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscolher;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabelaConsultasCampanhas;
    // End of variables declaration//GEN-END:variables
}
