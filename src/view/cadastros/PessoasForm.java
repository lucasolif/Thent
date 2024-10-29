
package view.cadastros;

import dao.IgrejaDao;
import dao.PessoaDao;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Endereco;
import model.Igreja;
import model.Pessoa;


public class PessoasForm extends javax.swing.JInternalFrame {
    
    private final PessoaDao pessoaDao = new PessoaDao();
    private final IgrejaDao igrejaDao = new IgrejaDao();
    private Pessoa pessoaSelecionada;
    private List<Pessoa> listaPessoa;

    public PessoasForm() {
        initComponents();
        carregarIgrejas();
        cbAtivo.setEnabled(false);
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPessoas = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        iconExcluir = new javax.swing.JButton();
        iconAlterar = new javax.swing.JButton();
        iconLimpar = new javax.swing.JButton();
        dadosPessoais = new javax.swing.JPanel();
        campoCpfCnpj = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoCelular = new javax.swing.JFormattedTextField();
        campoDataNascimento = new javax.swing.JFormattedTextField();
        orientacaoSexual = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        campoCodPessoa = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        campoRg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        campoIgreja = new javax.swing.JComboBox<>();
        cbAtivo = new javax.swing.JCheckBox();
        endereco = new javax.swing.JPanel();
        campoBairro = new javax.swing.JTextField();
        campoNum = new javax.swing.JTextField();
        campoCidade = new javax.swing.JTextField();
        campoComplemento = new javax.swing.JTextField();
        campoEndereco = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        campoEstado = new javax.swing.JComboBox<>();
        campoCep = new javax.swing.JFormattedTextField();
        btnBuscar = new javax.swing.JButton();
        campoBusca = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro de Pessoas");
        setPreferredSize(new java.awt.Dimension(1030, 670));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes/Fornecedores", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jScrollPane1.setToolTipText("Pessoas/Membros");

        tabelaPessoas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tabelaPessoas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaPessoas);
        if (tabelaPessoas.getColumnModel().getColumnCount() > 0) {
            tabelaPessoas.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabelaPessoas.getColumnModel().getColumn(1).setPreferredWidth(400);
            tabelaPessoas.getColumnModel().getColumn(2).setPreferredWidth(100);
            tabelaPessoas.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        btnSalvar.setBackground(new java.awt.Color(0, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        iconExcluir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lixeira-16.png"))); // NOI18N
        iconExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconExcluirActionPerformed(evt);
            }
        });

        iconAlterar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-editar-16.png"))); // NOI18N
        iconAlterar.setToolTipText("");
        iconAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconAlterarActionPerformed(evt);
            }
        });

        iconLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        iconLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-atualizar-16.png"))); // NOI18N
        iconLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iconLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconLimparActionPerformed(evt);
            }
        });

        dadosPessoais.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel1.setText("CPF/CNPJ*");

        jLabel5.setText("Nome Completo*");

        jLabel4.setText("Celular *");

        jLabel7.setText("Data Nasc");

        jLabel11.setText("E-mail");

        jLabel6.setText("RG");

        try {
            campoCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            campoDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        orientacaoSexual.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        jLabel20.setText("Sexo*");

        campoCodPessoa.setEditable(false);
        campoCodPessoa.setBackground(new java.awt.Color(204, 204, 204));
        campoCodPessoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel22.setText("Código");

        campoRg.setVerifyInputWhenFocusTarget(false);

        jLabel8.setText("Campo/Igreja*");

        cbAtivo.setSelected(true);
        cbAtivo.setText("Ativo/Inativo");

        javax.swing.GroupLayout dadosPessoaisLayout = new javax.swing.GroupLayout(dadosPessoais);
        dadosPessoais.setLayout(dadosPessoaisLayout);
        dadosPessoaisLayout.setHorizontalGroup(
            dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosPessoaisLayout.createSequentialGroup()
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(campoRg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(orientacaoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 45, Short.MAX_VALUE))
                            .addComponent(campoIgreja, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(dadosPessoaisLayout.createSequentialGroup()
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(campoCodPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(campoCpfCnpj)))
                    .addGroup(dadosPessoaisLayout.createSequentialGroup()
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                                .addComponent(campoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbAtivo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dadosPessoaisLayout.setVerticalGroup(
            dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(28, 28, 28))
                            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                                .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(campoCpfCnpj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoCodPessoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadosPessoaisLayout.createSequentialGroup()
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                                .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(orientacaoSexual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(dadosPessoaisLayout.createSequentialGroup()
                                .addComponent(campoDataNascimento)
                                .addGap(6, 6, 6)))))
                .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAtivo))))
                .addContainerGap())
        );

        endereco.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Endereço", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jLabel12.setText("Logradouro*");

        jLabel14.setText("Número*");

        jLabel15.setText("CEP*");

        jLabel16.setText("Bairro*");

        jLabel17.setText("Cidade*");

        jLabel18.setText("Estado*");

        jLabel19.setText("Complemento");

        campoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF" }));

        try {
            campoCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout enderecoLayout = new javax.swing.GroupLayout(endereco);
        endereco.setLayout(enderecoLayout);
        enderecoLayout.setHorizontalGroup(
            enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19)
                    .addComponent(campoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(enderecoLayout.createSequentialGroup()
                        .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(enderecoLayout.createSequentialGroup()
                        .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoBairro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(enderecoLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(129, 129, 129)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(campoEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        enderecoLayout.setVerticalGroup(
            enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, 0)
                        .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(6, 6, 6)
                        .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(enderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, 0)
                        .addComponent(campoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, 0)
                        .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, enderecoLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(0, 0, 0)
                        .addComponent(campoEstado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(0, 0, 0)
                .addComponent(campoComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnBuscar.setBackground(new java.awt.Color(204, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        campoBusca.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        campoBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoBuscaKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(iconLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iconExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBuscar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iconLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void campoBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoBuscaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarPessoas();
            atualizarTabela();
        }
    }//GEN-LAST:event_campoBuscaKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        consultarPessoas();
        atualizarTabela();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAlteracaoCadastro();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void iconAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconAlterarActionPerformed
        alterarPessoa();
    }//GEN-LAST:event_iconAlterarActionPerformed

    private void iconExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconExcluirActionPerformed
        excluirPessoa();
        consultarPessoas();
        atualizarTabela();
    }//GEN-LAST:event_iconExcluirActionPerformed

    private void iconLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconLimparActionPerformed
        pessoaSelecionada = null;
        limparFormulario();
        limparTabela();
    }//GEN-LAST:event_iconLimparActionPerformed

    private void limparFormulario(){
        campoBusca.setText("");
        campoCodPessoa.setText("");
        campoNome.setText("");
        campoCpfCnpj.setText("");
        campoRg.setText("");
        campoDataNascimento.setText("");
        campoEmail.setText("");
        campoCelular.setText("");
        campoEndereco.setText("");
        campoNum.setText("");
        campoCep.setText("");
        campoBairro.setText("");
        campoCidade.setText("");
        campoEstado.setName("Estado");
        campoComplemento.setText("");
        carregarIgrejas();       
    }
    
    private void consultarPessoas(){
        String textoBusca = campoBusca.getText();
        listaPessoa = pessoaDao.consultar(textoBusca);          
    }
    
    private void atualizarTabela(){
        DefaultTableModel model = (DefaultTableModel) tabelaPessoas.getModel();
        model.setNumRows(0);

        for(Pessoa pessoa : listaPessoa){      
            model.addRow(new Object[]{pessoa.getCodigo(),pessoa.getNome(),pessoa.getCpfCnpj(),pessoa.getIgreja().getNome()});
        }
    }
    
    private void limparTabela(){
        //Primeiro a condição testa se a quantidade de colunas é maior que 0, depois, limpa os dados
        if(tabelaPessoas.getRowCount() > 0){
            DefaultTableModel model = (DefaultTableModel) tabelaPessoas.getModel();
            model.setRowCount(0);
        }
    }

    private void carregarIgrejas(){
   
        List<Igreja> listaIgrejas = igrejaDao.consultarTodasIgrejas();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)campoIgreja.getModel();
        modelo.removeAllElements();
        for(Igreja igreja : listaIgrejas){
            modelo.addElement(igreja);
        }
    }
    
    private void salvarAlteracaoCadastro(){
        
        //Atribuindo os dados inseridos nos formulario a variáveis
        String nome = campoNome.getText();
        String cpfCnpj = campoCpfCnpj.getText();
        String rg = campoRg.getText();
        String dataNascimento = campoDataNascimento.getText();
        String celular = campoCelular.getText();
        String email = campoEmail.getText();
        String sexo = orientacaoSexual.getSelectedItem().toString();
        String rua = campoEndereco.getText();
        int numero = Integer.parseInt(campoNum.getText()) ;
        String cep = campoCep.getText();
        String bairro = campoBairro.getText();
        String cidade = campoCidade.getText();
        String estado = campoEstado.getSelectedItem().toString();
        String complemento = campoComplemento.getText();
        Igreja igreja = (Igreja) this.campoIgreja.getSelectedItem();

        Endereco endereco = new Endereco(rua, numero, cep, bairro, cidade, estado, complemento);
        Pessoa pessoa = new Pessoa(nome, cpfCnpj, dataNascimento, rg, celular, email, sexo, igreja, endereco, 1);

        if(pessoaSelecionada == null){
            if(nome.isEmpty() || cpfCnpj.isEmpty() || dataNascimento.isEmpty() || celular.isEmpty() || sexo.isEmpty() || rua.isEmpty() || cep.isEmpty() || bairro.isEmpty() || cidade.isEmpty() || estado.isEmpty()){
                JOptionPane.showMessageDialog(null, "Para cadastrar uma pessoa, informe os campos necessários", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pessoaDao.adicionar(pessoa); //Chamando método para adicionar o novo cadastro
            limparFormulario();
        }
        else{
            Integer ativo = 0;
            
            if(cbAtivo.isSelected()){
                ativo = 1;
            }
            
            int codPessoa = Integer.parseInt(campoCodPessoa.getText());
            Pessoa pessoaSelecionada = new Pessoa(nome, cpfCnpj, dataNascimento, rg, celular, email, sexo, igreja, endereco, codPessoa, ativo);
            pessoaDao.alterar(pessoaSelecionada); //Chamando o método que altera os dados da conta caixa
            limparFormulario();
        }

        pessoaSelecionada = null;
        limparTabela();
    }
    
    private void excluirPessoa(){
        int numLinhaSelec = tabelaPessoas.getSelectedRow();

        //Verifica se foi selecionado algum cliente da lista
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma pessoa para ser excluído", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //Recebe o a linha que foi selecionada na tabela, ou seja, a conta caixa
        pessoaSelecionada = listaPessoa.get(numLinhaSelec);

        int confirm = JOptionPane.showConfirmDialog(null,"Excluir a pessoa "+pessoaSelecionada.getNome()+" ?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if(confirm == JOptionPane.YES_OPTION){
            pessoaDao.remover(pessoaSelecionada.getCodigo());
        }else if(confirm == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Operação cancelada!");
        }
    }
    
    private void alterarPessoa(){
        
        cbAtivo.setEnabled(true);
        
        //Variável recebe o número da linha selecionado.
        int numLinhaSelec = tabelaPessoas.getSelectedRow();

        //Verificando se foi selecionado alguma conta caixa
        if(numLinhaSelec < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma conta caixa", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Objeto ContaCaixa recebe os dados que estavam na lista, ou seja, que foram selecionados
        pessoaSelecionada = listaPessoa.get(numLinhaSelec);

        campoCodPessoa.setText(Integer.toString(pessoaSelecionada.getCodigo()));
        campoNome.setText(pessoaSelecionada.getNome());
        campoCpfCnpj.setText(pessoaSelecionada.getCpfCnpj());
        campoRg.setText(pessoaSelecionada.getRg());
        campoDataNascimento.setText(pessoaSelecionada.getDataNascimento());
        campoCelular.setText(pessoaSelecionada.getCelular());
        campoEmail.setText(pessoaSelecionada.getEmail());
        orientacaoSexual.setSelectedItem(pessoaSelecionada.getSexo());
        campoEndereco.setText(pessoaSelecionada.getEndereco().getLogradouro());
        campoNum.setText(Integer.toString(pessoaSelecionada.getEndereco().getNumero()));
        campoCep.setText(pessoaSelecionada.getEndereco().getCep());
        campoBairro.setText(pessoaSelecionada.getEndereco().getBairro());
        campoCidade.setText(pessoaSelecionada.getEndereco().getCidade());
        campoEstado.setSelectedItem(pessoaSelecionada.getEndereco().getEstado());
        campoComplemento.setText(pessoaSelecionada.getEndereco().getComplemento());
        campoIgreja.setSelectedItem(pessoaSelecionada.getIgreja());
        
        if(pessoaSelecionada.getAtivo() == 1){
            cbAtivo.setSelected(true);
        }else{
            cbAtivo.setSelected(false);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField campoBairro;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JFormattedTextField campoCelular;
    private javax.swing.JFormattedTextField campoCep;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoCodPessoa;
    private javax.swing.JTextField campoComplemento;
    private javax.swing.JTextField campoCpfCnpj;
    private javax.swing.JFormattedTextField campoDataNascimento;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JComboBox<String> campoEstado;
    private javax.swing.JComboBox<String> campoIgreja;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNum;
    private javax.swing.JTextField campoRg;
    private javax.swing.JCheckBox cbAtivo;
    private javax.swing.JPanel dadosPessoais;
    private javax.swing.JPanel endereco;
    private javax.swing.JButton iconAlterar;
    private javax.swing.JButton iconExcluir;
    private javax.swing.JButton iconLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> orientacaoSexual;
    private javax.swing.JTable tabelaPessoas;
    // End of variables declaration//GEN-END:variables
}
