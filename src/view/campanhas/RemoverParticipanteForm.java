
package view.campanhas;

import dao.CampanhaDao;
import dao.PessoaDao;
import interfaces.ConsultaPessoas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Campanha;
import model.ParticipanteCampanha;
import model.Pessoa;
import model.Usuario;
import view.carregamentoConsultas.TelaConsultasPessoas;


public class RemoverParticipanteForm extends javax.swing.JInternalFrame implements ConsultaPessoas{

    private final CampanhaDao campanhaDao = new CampanhaDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private List<Pessoa> listaParticipantes = null;
    private ParticipanteCampanha participanteSelec = null;
    private Pessoa pessoaSelec = null;

    public RemoverParticipanteForm(Usuario usuarioLogado) {
        initComponents();
        formInicial();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        codParticipante = new javax.swing.JTextField();
        nomeParticipante = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        campanha = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Inativar Participantes");

        jLabel1.setText("Participante");

        codParticipante.setEditable(false);
        codParticipante.setBackground(new java.awt.Color(204, 204, 204));
        codParticipante.setFocusable(false);

        nomeParticipante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeParticipanteKeyPressed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Campanha");

        btnRemover.setBackground(new java.awt.Color(255, 0, 0));
        btnRemover.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campanha, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemover))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarParticipante();
        carregarResultadoConsultaParticipante();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void nomeParticipanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeParticipanteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
             consultarParticipante();
             carregarResultadoConsultaParticipante();
         }
        if(evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            this.codParticipante.setText("");
        } 
    }//GEN-LAST:event_nomeParticipanteKeyPressed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        removerParticipante();
        formInicial();
    }//GEN-LAST:event_btnRemoverActionPerformed
    
    private void formInicial(){
        this.codParticipante.setText("");
        this.nomeParticipante.setText("");
        carregarCampanhas();
    }
    
    private void carregarCampanhas(){
        List<Campanha> listaCampanha = this.campanhaDao.consultarTodasCampanhasAtiva();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.campanha.getModel();
        modelo.removeAllElements();
        for(Campanha campanha : listaCampanha){
            modelo.addElement(campanha);
        }
    }
    
    private void consultarParticipante(){
        String textoBusca = this.nomeParticipante.getText();
        this.listaParticipantes = this.pessoaDao.consultarCadastroAtivoPessoa(textoBusca);  
    }
    
    private void carregarResultadoConsultaParticipante(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaParticipantes);
        resultConsultParticipante.setPessoaSelecionada(this);
        resultConsultParticipante.setLocationRelativeTo(this);
        resultConsultParticipante.setVisible(true);
    }
    
    private void carregarParticipanteEscolhido(Pessoa pessoa){
        this.codParticipante.setText(String.valueOf(pessoa.getCodigo()));
        this.nomeParticipante.setText(pessoa.getNome());
        
        ParticipanteCampanha participante = new ParticipanteCampanha();
        participante.setCodigo(pessoa.getCodigo());
        participante.setNome(pessoa.getNome());
        participante.setCpfCnpj(pessoa.getCpfCnpj());
        participante.setEndereco(pessoa.getEndereco());
        
        this.participanteSelec = participante;
    }
    
    private void removerParticipante(){
        
        Campanha campanha = (Campanha) this.campanha.getSelectedItem();
        boolean verifcarParticipante = this.campanhaDao.verificarParticipanteCampanha(campanha, this.participanteSelec);
        
        if(verifcarParticipante){          
            int confirm = JOptionPane.showConfirmDialog(null,"Inativar o participante da campanha?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION){
                this.campanhaDao.inativarParticipante(campanha, this.participanteSelec);
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }     
        }else{
            JOptionPane.showMessageDialog(null, "Participante não encontrado na campanha", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarParticipanteEscolhido(pessoaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox<String> campanha;
    private javax.swing.JTextField codParticipante;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nomeParticipante;
    // End of variables declaration//GEN-END:variables
}
