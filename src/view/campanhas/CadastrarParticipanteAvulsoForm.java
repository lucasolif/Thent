
package view.campanhas;

import dao.CampanhaDao;
import dao.IgrejaDao;
import dao.PessoaDao;
import dao.SubContaResultadoDao;
import Ferramentas.PaletaCores;
import Ferramentas.Utilitarios;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Campanha;
import interfaces.ConsultaCampanhas;
import interfaces.ConsultaPessoas;
import model.ContasReceberCampanha;
import model.Igreja;
import model.ParticipanteCampanha;
import model.Pessoa;
import model.SubContaResultado;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultasCampanhas;
import view.carregamentoConsultas.TelaConsultasPessoas;

public class CadastrarParticipanteAvulsoForm extends javax.swing.JInternalFrame implements ConsultaCampanhas,ConsultaPessoas{
    
    private final CampanhaDao campanhaDao = new CampanhaDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private final PaletaCores cores = new PaletaCores();
    private final SubContaResultadoDao contaResultadoDao = new SubContaResultadoDao();
    private final PessoaDao pessoaDao = new PessoaDao();
    private final Campanha campanha = new Campanha();
    private List<Campanha> listaCampanha = null;
    private final Utilitarios conversor = new Utilitarios();
    private Pessoa pessoaSelec = null;
    private List<Pessoa> listaPessoa = null;
    private ParticipanteCampanha participanteSelec = null;
    private Campanha campanhaSelec = null;
    private List<ParticipanteCampanha> listaParticipante = null;
    

    public CadastrarParticipanteAvulsoForm(UsuarioLogado usuarioLogado) {
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

        codCampanha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nomeCampanha = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dataInicioPagamento = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        dataFimCampanha = new javax.swing.JFormattedTextField();
        valoPagtoMensal = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        cbGerarContasReceber = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        nomeParticipante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        codParticipante = new javax.swing.JTextField();
        contaResultado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        duracaoCampanha = new javax.swing.JTextField();
        igreja = new javax.swing.JTextField();
        qtdParcela = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);
        setTitle("Adicionar Participantes Avulso");

        codCampanha.setEditable(false);
        codCampanha.setBackground(new java.awt.Color(204, 204, 204));
        codCampanha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codCampanha.setFocusable(false);

        jLabel1.setText("Campanha*");

        nomeCampanha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeCampanhaKeyPressed(evt);
            }
        });

        jLabel2.setText("Duração");

        jLabel6.setText("Data 1° Pagto");

        try {
            dataInicioPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataInicioPagamento.setFocusable(false);

        jLabel7.setText("Final Campanha");

        dataFimCampanha.setEditable(false);
        try {
            dataFimCampanha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        dataFimCampanha.setFocusable(false);
        dataFimCampanha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        valoPagtoMensal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        valoPagtoMensal.setSelectionColor(new java.awt.Color(255, 0, 0));

        jLabel3.setText("Valor Mensal*");

        cbGerarContasReceber.setText("Contas Receber");

        jLabel4.setText("Qtd Parc");

        nomeParticipante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeParticipanteKeyPressed(evt);
            }
        });

        jLabel8.setText("Participante*");

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel9.setText("Gerar");

        jLabel10.setText("Igreja");

        codParticipante.setEditable(false);
        codParticipante.setBackground(new java.awt.Color(204, 204, 204));
        codParticipante.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codParticipante.setFocusable(false);

        jLabel5.setText("Conta Resultado");

        duracaoCampanha.setEditable(false);
        duracaoCampanha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        duracaoCampanha.setFocusable(false);

        igreja.setEditable(false);
        igreja.setBackground(new java.awt.Color(255, 255, 255));
        igreja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        igreja.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(codCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nomeCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(duracaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(dataFimCampanha)))
                        .addComponent(jLabel8)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(dataInicioPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(valoPagtoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)))
                                .addComponent(contaResultado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(igreja)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(cbGerarContasReceber))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(qtdParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabel10))
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeParticipante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(codCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(duracaoCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dataFimCampanha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicioPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbGerarContasReceber)
                            .addComponent(qtdParcela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(valoPagtoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contaResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(igreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeCampanhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeCampanhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            consultarCampanhas();
            carregarResultadoConsultaCampanha();
        }
    }//GEN-LAST:event_nomeCampanhaKeyPressed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        cadastrarParticipantesGerarContaReceber();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void nomeParticipanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeParticipanteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
            consultarParticipante();
            carregarResultadoConsultaParticipante();
        }
    }//GEN-LAST:event_nomeParticipanteKeyPressed
  
    private void formInicial(){
        this.dataInicioPagamento.setText(this.conversor.dataAtualString());
        this.codCampanha.setText("");
        this.nomeCampanha.setText("");
        this.nomeCampanha.requestFocusInWindow();
        this.dataFimCampanha.setText("");
        this.duracaoCampanha.setText("");
        this.valoPagtoMensal.setText("");
        this.nomeParticipante.setText("");
        this.qtdParcela.setValue(1);
        this.igreja.setText("");
        this.cbGerarContasReceber.setSelected(false);
        carregarSubContaResultado();
    }
    
    private void carregarSubContaResultado(){
        List<SubContaResultado> listaSubContResult = this.contaResultadoDao.consultarSubContaResultado();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.contaResultado.getModel();
        modelo.removeAllElements();
        for(SubContaResultado subCont : listaSubContResult){
            modelo.addElement(subCont);
        }
    }
    
    private void consultarCampanhas(){
        String busca = this.nomeCampanha.getText();
        this.listaCampanha = campanhaDao.consultarCampanhasAtiva(busca); 
    }
    
    private void carregarResultadoConsultaCampanha(){
        TelaConsultasCampanhas resultConsultaCampanhas = new TelaConsultasCampanhas((Frame) SwingUtilities.getWindowAncestor(this), this.listaCampanha);
        resultConsultaCampanhas.setCampanhaSelecionada(this);
        resultConsultaCampanhas.setLocationRelativeTo(this);
        resultConsultaCampanhas.setVisible(true);
    }
    
    private void carregarCampanhaEscolhida(Campanha campanhaEscolhida){
        this.codCampanha.setText(String.valueOf(campanhaEscolhida.getCodigo()));
        this.nomeCampanha.setText(String.valueOf(campanhaEscolhida));
        this.duracaoCampanha.setText(String.valueOf(campanhaEscolhida.getDuracaoMeses()));
        this.dataFimCampanha.setText(conversor.convertendoDataStringSql((Date) campanhaEscolhida.getDataFinal()));
        this.igreja.setText(campanhaEscolhida.getIgreja().getNome());
        
        this.campanhaSelec = campanhaEscolhida;
    }
    
    private void consultarParticipante(){
        String textoBusca = this.nomeParticipante.getText();
        this.listaPessoa = this.pessoaDao.consultarCadastroAtivoPessoa(textoBusca);  
    }
    
    private void carregarResultadoConsultaParticipante(){
        TelaConsultasPessoas resultConsultParticipante = new TelaConsultasPessoas((Frame) SwingUtilities.getWindowAncestor(this), this.listaPessoa);
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
    
    private void cadastrarParticipantesGerarContaReceber(){
        if(this.codCampanha.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Para cadastrar o participante é necessário escolher", "Atenção", JOptionPane.WARNING_MESSAGE);
        }else{
            if(this.campanhaDao.verificarParticipanteCampanha(this.campanhaSelec, this.participanteSelec)){
                JOptionPane.showMessageDialog(null, "Participante já está cadastrado na campanha escolhida", "Atenção", JOptionPane.WARNING_MESSAGE);
            }else{
                Integer codCampanha = Integer.valueOf(this.codCampanha.getText());            
                if(this.cbGerarContasReceber.isSelected()){
                    List<ContasReceberCampanha> listaContasReceber = gerarContasReceberCampanha();
                    this.participanteSelec.setListaCrCampanha(listaContasReceber);

                    this.campanhaDao.adicionarParticipantesAvulso(this.participanteSelec, codCampanha, true);
                    this.campanhaDao.gerarContasReceberAvulsaCampanha(this.participanteSelec, codCampanha);
                }else{               
                    this.campanhaDao.adicionarParticipantesAvulso(this.participanteSelec, codCampanha,false);
                } 
            }
        }
    }
     
    private List<ContasReceberCampanha> gerarContasReceberCampanha(){
   
        List<ContasReceberCampanha> listaCrCampanhas = new ArrayList<>();
        
        if(!this.codParticipante.getText().isEmpty()){
            
            final Integer qtdParcelas =  (Integer)this.qtdParcela.getValue();
            final SubContaResultado contaResultado = (SubContaResultado) this.contaResultado.getSelectedItem();
            final Igreja igreja = (Igreja) this.campanhaSelec.getIgreja();
            final double valorParcela = Double.parseDouble(this.valoPagtoMensal.getText().replace(",", "."));
            final String dataInicio = this.dataInicioPagamento.getText();
            final Integer statusPagamento = 0;
            final String descricaoStatus = "Aberto";

            for(int j = 1; j <= qtdParcelas; j++ ){
                String dataVencimento = this.conversor.somarDatas(dataInicio, j);

                ContasReceberCampanha crCampanha = new ContasReceberCampanha();
                crCampanha.setContaResultado(contaResultado);
                crCampanha.setDataVencimento(conversor.convertendoStringDateSql(dataVencimento));
                crCampanha.setParticipante(this.participanteSelec);
                crCampanha.setParcela(j);
                crCampanha.setValorParcela(valorParcela);
                crCampanha.setValorPendente(valorParcela);
                crCampanha.setStatusPagamento(statusPagamento);
                crCampanha.setDescricaoStatus(descricaoStatus);
                crCampanha.setIgreja(igreja);

                listaCrCampanhas.add(crCampanha);
            }          
        }          
        return listaCrCampanhas;
    }
    
    @Override
    public void pessoaSelecionada(Pessoa pessoaSelecionada) {
        carregarParticipanteEscolhido(pessoaSelecionada);
    }
    
    @Override
    public void campanhaSelecionada(Campanha campanhaSelecionada) {
        carregarCampanhaEscolhida(campanhaSelecionada);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbGerarContasReceber;
    private javax.swing.JTextField codCampanha;
    private javax.swing.JTextField codParticipante;
    private javax.swing.JComboBox<String> contaResultado;
    private javax.swing.JFormattedTextField dataFimCampanha;
    private javax.swing.JFormattedTextField dataInicioPagamento;
    private javax.swing.JTextField duracaoCampanha;
    private javax.swing.JTextField igreja;
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
    private javax.swing.JTextField nomeCampanha;
    private javax.swing.JTextField nomeParticipante;
    private javax.swing.JSpinner qtdParcela;
    private javax.swing.JFormattedTextField valoPagtoMensal;
    // End of variables declaration//GEN-END:variables


}
