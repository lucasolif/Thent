
package view.cadastros;

import dao.IgrejaDao;
import interfaces.ConsultaIgrejas;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Endereco;
import model.Igreja;
import view.carregamentoConsultas.TelaConsultaIgreja;


public class IgrejaForm extends javax.swing.JInternalFrame implements ConsultaIgrejas{

    private final IgrejaDao igrejaDao = new IgrejaDao();
    private Igreja igrejaSelec = null;
    private List<Igreja> listaIgreja = null;
    
    public IgrejaForm() {
        initComponents();
        formInicial();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        campoBusca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        campoComplemento = new javax.swing.JTextField();
        codIgreja = new javax.swing.JTextField();
        campoEndereco = new javax.swing.JTextField();
        nomeIgreja = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        campoEstado = new javax.swing.JComboBox<>();
        campoBairro = new javax.swing.JTextField();
        campoCidade = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        campoCep = new javax.swing.JFormattedTextField();
        campoNum = new javax.swing.JTextField();
        cbAtivo = new javax.swing.JCheckBox();

        setClosable(true);
        setIconifiable(true);
        setTitle("Campo/Igreja");
        setPreferredSize(new java.awt.Dimension(506, 315));

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        btnExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
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

        campoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBuscaKeyPressed(evt);
            }
        });

        jLabel3.setText("Buscar");

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        codIgreja.setEditable(false);
        codIgreja.setBackground(new java.awt.Color(204, 204, 204));
        codIgreja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codIgreja.setFocusable(false);

        jLabel1.setText("Codigo");

        jLabel12.setText("Logradouro*");

        jLabel14.setText("Número*");

        jLabel15.setText("CEP*");

        jLabel16.setText("Bairro*");

        jLabel17.setText("Cidade*");

        jLabel2.setText("Nome da Igreja*");

        jLabel18.setText("Estado*");

        campoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SP", "SC", "SE", "TO", "DF" }));
        campoEstado.setSelectedIndex(14);

        jLabel19.setText("Complemento");

        try {
            campoCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbAtivo.setText("Ativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(codIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nomeIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbAtivo)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnLimpar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExcluir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnSalvar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(campoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel15))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnBuscar))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addGap(6, 6, 6)
                            .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(campoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        formInicial();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarCadastroAlteracao();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluirIgreja();  
        formInicial();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarIgreja();
        carregarResultadoConsultaIgreja();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void campoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarIgreja();
            carregarResultadoConsultaIgreja();
        }
    }//GEN-LAST:event_campoBuscaKeyPressed

    private void formInicial(){
        this.codIgreja.setText("");
        this.nomeIgreja.setText("");
        this.nomeIgreja.requestFocusInWindow();
        this.campoEstado.setName("Estado");
        this.campoCep.setText("");
        this.campoCidade.setText("");
        this.campoComplemento.setText("");
        this.campoEndereco.setText("");
        this.campoBairro.setText("");
        this.campoNum.setText("");
        this.cbAtivo.setSelected(true);
        this.cbAtivo.setEnabled(false);
        this.igrejaSelec = null;
    }
    
    private void consultarIgreja(){      
        String textoBusca = campoBusca.getText(); // Texto digitado na busca       
        listaIgreja = igrejaDao.consultarIgreja(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void carregarResultadoConsultaIgreja(){
        TelaConsultaIgreja resultConsultaContaCaixa = new TelaConsultaIgreja((Frame) SwingUtilities.getWindowAncestor(this), this.listaIgreja);
        resultConsultaContaCaixa.setIgrejaSelecionada(this);
        resultConsultaContaCaixa.setLocationRelativeTo(this);
        resultConsultaContaCaixa.setVisible(true);
    }
    
    private void carregarIgrejaEscolhida(Igreja igreja){
        this.codIgreja.setText(String.valueOf(igreja.getCodigo()));
        this.nomeIgreja.setText(igreja.getNome());
        this.campoBairro.setText(igreja.getEndereco().getBairro());
        this.campoCep.setText(igreja.getEndereco().getCep());
        this.campoCidade.setText(igreja.getEndereco().getCidade());
        this.campoComplemento.setText(igreja.getEndereco().getComplemento());
        this.campoEndereco.setText(igreja.getEndereco().getLogradouro());
        this.campoEstado.setSelectedItem(igreja.getEndereco().getEstado());
        this.campoNum.setText(String.valueOf(igreja.getEndereco().getNumero()));
        if(igreja.getStatus() == 1){
            this.cbAtivo.setSelected(true);
        }else{
            this.cbAtivo.setSelected(false);
        }
        
        this.igrejaSelec = igreja;
        this.cbAtivo.setEnabled(true);
    }
    
    private void salvarCadastroAlteracao(){
        
        String nomeIgre = this.nomeIgreja.getText();
        String estado = this.campoEstado.getSelectedItem().toString();
        String cidade = this.campoCidade.getText();
        String cep = this.campoCep.getText();
        String complemento = this.campoComplemento.getText();
        String logradouro = this.campoEndereco.getText();
        String bairro = this.campoBairro.getText();
        int numCasa = Integer.parseInt(this.campoNum.getText());
        
        if(this.igrejaSelec == null || this.campoBairro == null || this.campoCidade == null){
            if(nomeIgre.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma igreja, informe a descrição", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                Endereco endereco = new Endereco(logradouro, numCasa, cep, bairro, cidade, estado, complemento);
                Igreja igreja = new Igreja();
                igreja.setNome(nomeIgre);
                igreja.setStatus(1);
                igreja.setEndereco(endereco);

                this.igrejaDao.cadastrarIgreja(igreja);
            }
        }else{
            Endereco endereco = new Endereco(logradouro, numCasa, cep, bairro, cidade, estado, complemento);
            Integer codIgrej = Integer.valueOf(this.codIgreja.getText());
            Igreja igreja = new Igreja();
            igreja.setNome(nomeIgre);
            igreja.setCodigo(codIgrej);
            igreja.setEndereco(endereco);
            if(this.cbAtivo.isSelected()){
                igreja.setStatus(1);
            }else{
                igreja.setStatus(0);
            }
            this.igrejaDao.alterarIgreja(igreja);
        }
        formInicial();
    }
    
    private void excluirIgreja(){
        if(this.codIgreja.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione uma igreja a ser excluída", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            int confirm = JOptionPane.showConfirmDialog(null,"Excluir a igreja "+this.igrejaSelec.getNome().toUpperCase()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);

            if(confirm == JOptionPane.YES_OPTION){
                this.igrejaDao.removerIgreja(this.igrejaSelec);
            }else if(confirm == JOptionPane.NO_OPTION){
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
            }  
        }
    }

    @Override
    public void igrejaSelecionada(Igreja igrejaSelecionada) {
        carregarIgrejaEscolhida(igrejaSelecionada);    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JFormattedTextField campoCep;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoComplemento;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JComboBox<String> campoEstado;
    private javax.swing.JTextField campoNum;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JTextField codIgreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeIgreja;
    // End of variables declaration//GEN-END:variables
}
