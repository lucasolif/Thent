
package view.carregamentoConsultas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import interfaces.ConsultaPessoas;
import model.Pessoa;

public class ResultadosConsultasPessoas extends javax.swing.JDialog {
    
    //Istanciação do Objeto "CadastrarCampanhaForm".
    private ConsultaPessoas consultaPessoas;
    
    public ResultadosConsultasPessoas(java.awt.Frame owner, List<Pessoa> listaPessoa) {
        super(owner, true);
        initComponents();
        carregarPessoasCosultadas(listaPessoa);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEscolher = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultadoConsulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem Pessoas Consultadas");

        btnEscolher.setBackground(new java.awt.Color(0, 153, 255));
        btnEscolher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEscolher.setText("Escolher");
        btnEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherActionPerformed(evt);
            }
        });

        jScrollPane1.setToolTipText("Pessoas/Membros");

        tabelaResultadoConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF/CNPJ", "Campo/Igreja"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tabelaResultadoConsulta.getColumnModel().getColumn(1).setPreferredWidth(400);
            tabelaResultadoConsulta.getColumnModel().getColumn(2).setResizable(false);
            tabelaResultadoConsulta.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabelaResultadoConsulta.getColumnModel().getColumn(3).setResizable(false);
            tabelaResultadoConsulta.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(687, Short.MAX_VALUE)
                .addComponent(btnEscolher)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(btnEscolher)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
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
            model.addRow(new Object[]{pessoa.getCodigo(),pessoa, pessoa.getCpfCnpj(), pessoa.getIgreja()});
        }
    }
    
    //Escolhe a pessoa, chama o método do "CadastrarCampanhaForm", e envia a pessoa selecionada
    private void pessoaEscolhida(){
        int linhaSelec = this.tabelaResultadoConsulta.getSelectedRow();
        if(linhaSelec >= 0){
            Pessoa pessoa = (Pessoa)this.tabelaResultadoConsulta.getModel().getValueAt(linhaSelec, 1); 
            this.consultaPessoas.pessoaSelecionada(pessoa);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Não foi selecionado nenhum participante", "Atenção", JOptionPane.WARNING_MESSAGE);     
        }
    }
    
    public void setPessoaSelecionada(ConsultaPessoas consultaPessoas) {
        this.consultaPessoas = consultaPessoas;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscolher;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaResultadoConsulta;
    // End of variables declaration//GEN-END:variables
}
