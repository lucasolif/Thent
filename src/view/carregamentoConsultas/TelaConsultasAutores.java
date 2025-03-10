
package view.carregamentoConsultas;

import interfaces.ConsultaAutores;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Autor;


public class TelaConsultasAutores extends javax.swing.JDialog {
    
    private ConsultaAutores consultaAutores;
    
    public TelaConsultasAutores(java.awt.Frame owner, List<Autor> listaAutores) {
        super(owner, true);
        initComponents();
        carregarAutoresCosultados(listaAutores);
        escolherUsandoClickEnter();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem Autores Consultado");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "C�digo", "Nome Autore(s)"
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
        jScrollPane1.setViewportView(tabela);
        if (tabela.getColumnModel().getColumnCount() > 0) {
            tabela.getColumnModel().getColumn(0).setResizable(false);
            tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
            tabela.getColumnModel().getColumn(1).setResizable(false);
            tabela.getColumnModel().getColumn(1).setPreferredWidth(350);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
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
                .addGap(0, 30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        autorEscolhido();
    }//GEN-LAST:event_btnSelecionarActionPerformed

    //Adiciona na tabela do Dialogm as pessoas que foram consulta no "CadastrarCampanhaForm", para serem escolhidas
    private void carregarAutoresCosultados(List<Autor> listaAutores){         
        for(Autor autor : listaAutores){        
            DefaultTableModel model = (DefaultTableModel) this.tabela.getModel();    
            model.addRow(new Object[]{autor.getCodigo(),autor});
        }
    }
    
    //Escolhe a pessoa, chama o m�todo do "CadastrarCampanhaForm", e envia a pessoa selecionada
    private void autorEscolhido(){
        int linhaSelec = this.tabela.getSelectedRow();
        if(linhaSelec >= 0){
            Autor autor = (Autor)this.tabela.getModel().getValueAt(linhaSelec, 1); 
            this.consultaAutores.autorSelecionado(autor);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "N�o foi selecionado nenhum autor", "Aten��o", JOptionPane.WARNING_MESSAGE);     
        }
    }
    
    public void setAutorSelecionado(ConsultaAutores consultarAutores) {
        this.consultaAutores = consultarAutores;
    }
    
    private void escolherUsandoClickEnter(){
        
        //Escolher quando apertar na tecla Enter
        tabela.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    autorEscolhido();
                }
            }
        });
        
        //Escolher quando clicar duas vezes no mouse
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Verifica se foi um duplo clique (clickCount == 2)
                if (e.getClickCount() == 2) {
                    autorEscolhido();
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelecionar;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
