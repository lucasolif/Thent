
package view.financeiro;

import Services.Utilitarios;
import dao.AplicacaoDao;
import dao.ContaCaixaDao;
import dao.IgrejaDao;
import interfaces.ConsultaAplicacoes;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Aplicacao;
import model.ContaCaixa;
import model.Igreja;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultaAplicacao;
import view.carregamentoConsultas.TelaConsultaContaCaixa;


public class AplicacaoFinanceiraForm extends javax.swing.JInternalFrame implements ConsultaAplicacoes{

    private List<Aplicacao> listaAplicacao = null;
    private Aplicacao aplicacaoSelec = null;
    private UsuarioLogado usuarioLogado = null;
    private final Utilitarios conversor = new Utilitarios();
    private final AplicacaoDao aplicacaoDao = new AplicacaoDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final ContaCaixaDao contaCaixaDao = new ContaCaixaDao();
    
    public AplicacaoFinanceiraForm(UsuarioLogado usuarioLogado) {
        initComponents();
        formInicial();
        this.usuarioLogado = usuarioLogado;
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbGrupoRendimento = new javax.swing.ButtonGroup();
        buscarAplicacao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        codAplicacao = new javax.swing.JTextField();
        descricaoAplicacao = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        contaCaixa = new javax.swing.JComboBox<>();
        igreja = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        rbDiario = new javax.swing.JRadioButton();
        rbMensal = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        valorAplicado = new javax.swing.JFormattedTextField();
        percentualAplicacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dataAplicacao = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnEncerrar = new javax.swing.JButton();
        diaAniversario = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Aplicação Financeira");

        buscarAplicacao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscarAplicacaoKeyPressed(evt);
            }
        });

        jLabel1.setText("Buscar Aplicação");

        btnOk.setBackground(new java.awt.Color(0, 153, 255));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo");

        codAplicacao.setEditable(false);
        codAplicacao.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Descrição*");

        jLabel4.setText("ContaCaixa");

        contaCaixa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        igreja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel5.setText("Igreja");

        rbGrupoRendimento.add(rbDiario);
        rbDiario.setText("Diário");

        rbGrupoRendimento.add(rbMensal);
        rbMensal.setText("Mensal");

        jLabel6.setText("Rendimento");

        jLabel7.setText("Valor Aplicado*");

        valorAplicado.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel8.setText("Perc (%)*");

        try {
            dataAplicacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel9.setText("Data Aplicação*");

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEncerrar.setBackground(new java.awt.Color(255, 0, 0));
        btnEncerrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEncerrar.setText("Encerrar");
        btnEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncerrarActionPerformed(evt);
            }
        });

        diaAniversario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        diaAniversario.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));

        jLabel10.setText("Aniversario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(dataAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(percentualAplicacao, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(valorAplicado, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbMensal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbDiario))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buscarAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEncerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descricaoAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(diaAniversario))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricaoAplicacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diaAniversario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorAplicado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbDiario)
                            .addComponent(rbMensal)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(percentualAplicacao)
                            .addComponent(dataAplicacao))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contaCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnEncerrar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarAlterarAplicacao();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        consultarAplicacao();
        carregarResultadoAplicacao();
        formaConsulta();
    }//GEN-LAST:event_btnOkActionPerformed

    private void buscarAplicacaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarAplicacaoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarAplicacao();
            carregarResultadoAplicacao();
            formaConsulta();
        }
    }//GEN-LAST:event_buscarAplicacaoKeyPressed

    private void btnEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncerrarActionPerformed
        encerrarAplicacao();
        formInicial();
    }//GEN-LAST:event_btnEncerrarActionPerformed

    private void consultarAplicacao(){        
        String textoBusca = this.buscarAplicacao.getText(); // Texto digitado na busca       
        this.listaAplicacao = this.aplicacaoDao.consultarAplicacao(textoBusca); //Lista recebe a busca retornada do banco
    }
    
    private void carregarResultadoAplicacao(){
        TelaConsultaAplicacao resultaConsultaAplicacao = new TelaConsultaAplicacao((Frame) SwingUtilities.getWindowAncestor(this), this.listaAplicacao);
        resultaConsultaAplicacao.setAplicacaoSelecionada(this);
        resultaConsultaAplicacao.setLocationRelativeTo(this);
        resultaConsultaAplicacao.setVisible(true);
    }
    
    private void carregarAplicacaoEscolhida(Aplicacao aplicacao){
        this.codAplicacao.setText(String.valueOf(aplicacao.getCodigo()));
        this.descricaoAplicacao.setText(aplicacao.getDescricao());
        this.dataAplicacao.setText(conversor.convertendoDataStringSql((java.sql.Date) aplicacao.getDataAplicacao()));
        this.percentualAplicacao.setText(String.valueOf(aplicacao.getPercentual()).replace(".", ","));
        this.valorAplicado.setText(String.valueOf(aplicacao.getValorInicial()).replace(".", ","));
        this.igreja.setSelectedItem(aplicacao.getIgreja());
        this.contaCaixa.setSelectedItem(aplicacao.getContaCaixa());
        if(aplicacao.getTipoRendimento().equalsIgnoreCase("mensal")){
            rbMensal.setSelected(true);
        }else{
            rbDiario.setSelected(true);
        }
        this.diaAniversario.setValue(aplicacao.getDiaAniversario());
        
        this.aplicacaoSelec = aplicacao;
    }
    
    private void carregarContaCaixa(){
        List<ContaCaixa> listaContaCaixa = contaCaixaDao.consultarContaCaixa();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)contaCaixa.getModel();
        modelo.removeAllElements();
        for(ContaCaixa cx : listaContaCaixa){
            modelo.addElement(cx);
        }
        
    }
    
    private void carregarIgrejas(){
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)igreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
    }
    
    private void formInicial(){
        this.buscarAplicacao.setText("");
        this.codAplicacao.setText("");
        this.descricaoAplicacao.setText("");
        this.valorAplicado.setText("");
        this.percentualAplicacao.setText("");
        this.rbMensal.setSelected(true);
        this.diaAniversario.setValue(1);
        this.dataAplicacao.setText(conversor.dataAtualString());
        this.rbMensal.setSelected(true);
        this.diaAniversario.setValue(1);
        this.dataAplicacao.setEditable(true);
        this.valorAplicado.setEditable(true);
        this.contaCaixa.setEnabled(true);
        this.igreja.setEnabled(true);
        this.rbDiario.setEnabled(true);
        this.rbMensal.setEnabled(true);
        this.diaAniversario.setEnabled(true);
        carregarContaCaixa();
        carregarIgrejas();
    }
    
    private void formaConsulta(){
        this.dataAplicacao.setEditable(false);
        this.valorAplicado.setEditable(false);
        this.contaCaixa.setEnabled(false);
        this.igreja.setEnabled(false);
        this.rbDiario.setEnabled(false);
        this.rbMensal.setEnabled(false);
    }
    
    private boolean verificarPreenchimentoDados(){
        boolean preenchido = true;
        
        if(this.descricaoAplicacao.getText().isEmpty() || this.dataAplicacao.getText().isEmpty() || this.percentualAplicacao.getText().isEmpty() || this.valorAplicado.getText().isEmpty()){
            //JOptionPane.showMessageDialog(null, "Informe os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
            preenchido = false;
        }      
        return preenchido;
    }
    
    private void cadastrarAlterarAplicacao(){
        
        //Variáveis para receber os dados do fomulário
        String descAplicacao = this.descricaoAplicacao.getText();
        Date dataAplicacao = conversor.convertendoStringDateSql(this.dataAplicacao.getText());
        double percentual = Double.parseDouble(this.percentualAplicacao.getText().replace(",", "."));
        double valorAplicado = Double.parseDouble(this.valorAplicado.getText().replace(",", "."));
        Integer diaAniversario = (Integer )this.diaAniversario.getValue();
        String tipoRendimento = "Mensal";
        if(this.rbDiario.isSelected()){
            tipoRendimento = "Diario";
        }
        ContaCaixa contaCaixa = (ContaCaixa) this.contaCaixa.getSelectedItem();
        Igreja igreja = (Igreja) this.igreja.getSelectedItem();
        
        //Istanciando o objeto e setando os valores
        Aplicacao aplicacao = new Aplicacao();
        aplicacao.setContaCaixa(contaCaixa);
        aplicacao.setDataAplicacao(dataAplicacao);
        aplicacao.setDescricao(descAplicacao);
        aplicacao.setIgreja(igreja);
        aplicacao.setPercentual(percentual);
        aplicacao.setValorInicial(valorAplicado);
        aplicacao.setTipoRendimento(tipoRendimento);
        aplicacao.setDiaAniversario(diaAniversario);
        
        //Verifica se todos os campos foram preenchidos
        if(verificarPreenchimentoDados()){
            //Verifica se é uma alteração ou cadastro
            if(this.aplicacaoSelec == null){
                //Passando o obejto para ser cadastrado
                this.aplicacaoDao.cadastrarAplicacao(aplicacao, this.usuarioLogado);
            }else{
                aplicacao.setCodigo(Integer.valueOf(this.codAplicacao.getText()));
               this.aplicacaoDao.alterarAplicacao(aplicacao);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Informe os campos obrigatórios", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
   
    }
    
    private void encerrarAplicacao(){
        if(!this.codAplicacao.getText().isEmpty()){
            Aplicacao aplicacao = new Aplicacao();
            aplicacao.setCodigo(Integer.valueOf(this.codAplicacao.getText()));
            
            this.aplicacaoDao.encerrarAplicacao(aplicacao);
        }else{
            JOptionPane.showMessageDialog(null, "Informe a aplicação que será encerrada", "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    @Override
    public void aplicacaoSelecionada(Aplicacao aplicacaoSelecionada) {
        carregarAplicacaoEscolhida(aplicacaoSelecionada); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEncerrar;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField buscarAplicacao;
    private javax.swing.JTextField codAplicacao;
    private javax.swing.JComboBox<String> contaCaixa;
    private javax.swing.JFormattedTextField dataAplicacao;
    private javax.swing.JTextField descricaoAplicacao;
    private javax.swing.JSpinner diaAniversario;
    private javax.swing.JComboBox<String> igreja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField percentualAplicacao;
    private javax.swing.JRadioButton rbDiario;
    private javax.swing.ButtonGroup rbGrupoRendimento;
    private javax.swing.JRadioButton rbMensal;
    private javax.swing.JFormattedTextField valorAplicado;
    // End of variables declaration//GEN-END:variables


}
