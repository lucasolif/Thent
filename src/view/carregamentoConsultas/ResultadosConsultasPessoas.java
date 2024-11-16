
package view.carregamentoConsultas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Pessoa;
import view.campanhas.CadastrarCampanhaForm;


public class ResultadosConsultasPessoas extends javax.swing.JDialog {
    
    //Istanciação do Objeto "CadastrarCampanhaForm".
    private CadastrarCampanhaForm cadCampForm = null;
    
    public ResultadosConsultasPessoas(java.awt.Frame parent, List<Pessoa> listaPessoa, CadastrarCampanhaForm cadCampForm) {
        super(parent, true);
        initComponents();
        carregarPessoasCosultadas(listaPessoa);
        this.cadCampForm = cadCampForm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultadoConsulta = new javax.swing.JTable();
        btnEscolher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Resultados Consultas");

        tabelaResultadoConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome/Descrição"
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
        jScrollPane1.setViewportView(tabelaResultadoConsulta);
        if (tabelaResultadoConsulta.getColumnModel().getColumnCount() > 0) {
            tabelaResultadoConsulta.getColumnModel().getColumn(0).setResizable(false);
            tabelaResultadoConsulta.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabelaResultadoConsulta.getColumnModel().getColumn(1).setResizable(false);
            tabelaResultadoConsulta.getColumnModel().getColumn(1).setPreferredWidth(350);
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
        pessoaEscolhida();
    }//GEN-LAST:event_btnEscolherActionPerformed
    
    //Adiciona na tabela do Dialogm as pessoas que foram consulta no "CadastrarCampanhaForm", para serem escolhidas
    private void carregarPessoasCosultadas(List<Pessoa> listaPessoa){         
        for(Pessoa pessoa : listaPessoa){        
            DefaultTableModel model = (DefaultTableModel) this.tabelaResultadoConsulta.getModel();    
            model.addRow(new Object[]{pessoa.getCodigo(),pessoa});
        }
    }
    
    //Escolhe a pessoa, chama o método do "CadastrarCampanhaForm", e envia a pessoa selecionada
    private void pessoaEscolhida(){
        int linhaSelec = this.tabelaResultadoConsulta.getSelectedRow();
        if(linhaSelec >= 0){
            dispose();
            Pessoa pessoa = (Pessoa)this.tabelaResultadoConsulta.getModel().getValueAt(linhaSelec, 1); 
            this.cadCampForm.adicionarParticipanteEscolhido(pessoa);
        }else{
            JOptionPane.showMessageDialog(null, "Não foi selecionado nenhum participante", "Atenção", JOptionPane.WARNING_MESSAGE);
 
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscolher;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabelaResultadoConsulta;
    // End of variables declaration//GEN-END:variables
}
