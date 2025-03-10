
package view.carregamentoConsultas;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import interfaces.ConsultaPessoas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Pessoa;

public class TelaConsultasPessoas extends javax.swing.JDialog {
    
    //Istancia��o do Objeto "CadastrarCampanhaForm".
    private ConsultaPessoas consultaPessoas;
    
    public TelaConsultasPessoas(java.awt.Frame owner, List<Pessoa> listaPessoa) {
        super(owner, true);
        initComponents();
        carregarPessoasCosultadas(listaPessoa);
        escolherPessoaUsandoClickEnter();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSelecionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaResultadoConsulta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem Pessoas Consultadas");

        btnSelecionar.setBackground(new java.awt.Color(0, 153, 255));
        btnSelecionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jScrollPane1.setToolTipText("Pessoas/Membros");

        tabelaResultadoConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C�digo", "Nome", "CPF/CNPJ", "Campo/Igreja"
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
                .addContainerGap(675, Short.MAX_VALUE)
                .addComponent(btnSelecionar)
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
                .addComponent(btnSelecionar)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        pessoaEscolhida();
    }//GEN-LAST:event_btnSelecionarActionPerformed
    
    //Adiciona na tabela do Dialogm as pessoas que foram consulta no "CadastrarCampanhaForm", para serem escolhidas
    private void carregarPessoasCosultadas(List<Pessoa> listaPessoa){         
        for(Pessoa pessoa : listaPessoa){        
            DefaultTableModel model = (DefaultTableModel) this.tabelaResultadoConsulta.getModel();    
            model.addRow(new Object[]{pessoa.getCodigo(),pessoa, pessoa.getCpfCnpj(), pessoa.getIgreja()});
        }
    }
    
    //Escolhe a pessoa, chama o m�todo do "CadastrarCampanhaForm", e envia a pessoa selecionada
    private void pessoaEscolhida(){
        int linhaSelec = this.tabelaResultadoConsulta.getSelectedRow();
        if(linhaSelec >= 0){
            Pessoa pessoa = (Pessoa)this.tabelaResultadoConsulta.getModel().getValueAt(linhaSelec, 1); 
            this.consultaPessoas.pessoaSelecionada(pessoa);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "N�o foi selecionado nenhum participante", "Aten��o", JOptionPane.WARNING_MESSAGE);     
        }
    }
    
    public void setPessoaSelecionada(ConsultaPessoas consultaPessoas) {
        this.consultaPessoas = consultaPessoas;
    }
   
    private void escolherPessoaUsandoClickEnter(){
        
        //Escolher quando apertar na tecla Enter
        tabelaResultadoConsulta.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pessoaEscolhida();
                }
            }
        });
        
        //Escolher quando clicar duas vezes no mouse
        tabelaResultadoConsulta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Verifica se foi um duplo clique (clickCount == 2)
                if (e.getClickCount() == 2) {
                    pessoaEscolhida();
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaResultadoConsulta;
    // End of variables declaration//GEN-END:variables
}
