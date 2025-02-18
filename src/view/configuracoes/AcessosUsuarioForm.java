
package view.configuracoes;

import dao.UsuarioDao;
import interfaces.ConsultaUsuarios;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Acessos;
import model.FuncoesUsuario;
import model.Usuario;
import model.UsuarioLogado;
import view.carregamentoConsultas.TelaConsultaUsuarios;


public class AcessosUsuarioForm extends javax.swing.JInternalFrame implements ConsultaUsuarios {

    private final UsuarioDao usuarioDao = new UsuarioDao();
    private List<Usuario> listaUsuario;
    private List<JCheckBox> listaCheckbox = null;
    List<Acessos> listaConsultaAcesso = null;
    

    public AcessosUsuarioForm() {
        initComponents();
        
        nomearCheckBox();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        acessosUsuario = new javax.swing.JTabbedPane();
        acessosMenus = new javax.swing.JPanel();
        cbx7 = new javax.swing.JCheckBox();
        cbx6 = new javax.swing.JCheckBox();
        cbx4 = new javax.swing.JCheckBox();
        cbx3 = new javax.swing.JCheckBox();
        cbx1 = new javax.swing.JCheckBox();
        cbx2 = new javax.swing.JCheckBox();
        cbx9 = new javax.swing.JCheckBox();
        cbx5 = new javax.swing.JCheckBox();
        cbx11 = new javax.swing.JCheckBox();
        cbx10 = new javax.swing.JCheckBox();
        cbx8 = new javax.swing.JCheckBox();
        cbx13 = new javax.swing.JCheckBox();
        cbx20 = new javax.swing.JCheckBox();
        cbx19 = new javax.swing.JCheckBox();
        cbx18 = new javax.swing.JCheckBox();
        cbx17 = new javax.swing.JCheckBox();
        cbx15 = new javax.swing.JCheckBox();
        cbx14 = new javax.swing.JCheckBox();
        cbx12 = new javax.swing.JCheckBox();
        cbx21 = new javax.swing.JCheckBox();
        cbx23 = new javax.swing.JCheckBox();
        cbx16 = new javax.swing.JCheckBox();
        cbx22 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        cbx29 = new javax.swing.JCheckBox();
        cbx28 = new javax.swing.JCheckBox();
        cbx33 = new javax.swing.JCheckBox();
        cbx31 = new javax.swing.JCheckBox();
        cbx27 = new javax.swing.JCheckBox();
        cbx34 = new javax.swing.JCheckBox();
        cbx32 = new javax.swing.JCheckBox();
        cbx26 = new javax.swing.JCheckBox();
        cbx30 = new javax.swing.JCheckBox();
        cbx24 = new javax.swing.JCheckBox();
        cbx25 = new javax.swing.JCheckBox();
        acessosMenu1 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        cbx39 = new javax.swing.JCheckBox();
        cbx38 = new javax.swing.JCheckBox();
        cbx37 = new javax.swing.JCheckBox();
        cbx46 = new javax.swing.JCheckBox();
        cbx47 = new javax.swing.JCheckBox();
        cbx45 = new javax.swing.JCheckBox();
        cbx41 = new javax.swing.JCheckBox();
        cbx36 = new javax.swing.JCheckBox();
        cbx44 = new javax.swing.JCheckBox();
        cbx43 = new javax.swing.JCheckBox();
        cbx42 = new javax.swing.JCheckBox();
        cbx40 = new javax.swing.JCheckBox();
        cbx35 = new javax.swing.JCheckBox();
        jSeparator5 = new javax.swing.JSeparator();
        cbx48 = new javax.swing.JCheckBox();
        cbx54 = new javax.swing.JCheckBox();
        cbx55 = new javax.swing.JCheckBox();
        cbx53 = new javax.swing.JCheckBox();
        cbx52 = new javax.swing.JCheckBox();
        cbx51 = new javax.swing.JCheckBox();
        cbx50 = new javax.swing.JCheckBox();
        cbx49 = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        cbx58 = new javax.swing.JCheckBox();
        cbx56 = new javax.swing.JCheckBox();
        cbx57 = new javax.swing.JCheckBox();
        cbx59 = new javax.swing.JCheckBox();
        cbx60 = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();
        codUsuario = new javax.swing.JTextField();
        nomeUsuario = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Acessos de Usuários");

        acessosUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        cbx7.setText("Cadastro Conta Caixa");

        cbx6.setText("Cadastro Forma Pagto");

        cbx4.setText("Cadastro de Usuário");

        cbx3.setText("Cadastro de Igrejas/Campos");

        cbx1.setText("Menu Cadastros");

        cbx2.setText("Cadastro de Pessoas e Membros");

        cbx9.setText("SubMenu Plano De Contas");

        cbx5.setText("Sub Menu Entidades");

        cbx11.setText("Cadastro Sub Conta de Resultado");

        cbx10.setText("Cadastro Conta de Resultado");

        cbx8.setText("Cadastro Tipo de Oferta");

        cbx13.setText("SubMenu Operação Dizimos/Ofertas");

        cbx20.setText("Alterar Contas a Pagar");

        cbx19.setText("Cancelar Contas a Pagar");

        cbx18.setText("Efetivar/Consutar Contas a Pagar");

        cbx17.setText("Lançar Contas a Pagar");

        cbx15.setText("Consultar Dízimos ou Ofertas");

        cbx14.setText("Registrar Dizimo ou Ofertas");

        cbx12.setText("Menu Financeiro");

        cbx21.setText("SubMenu Operações Caixa");

        cbx23.setText("Movimento Financeiro");

        cbx16.setText("SubMenu Contas a Pagar");

        cbx22.setText("Transferências Bancárias");

        jSeparator1.setToolTipText("");
        jSeparator1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Financeiro", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jSeparator2.setToolTipText("");
        jSeparator2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Cadastros", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        jSeparator3.setToolTipText("");
        jSeparator3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Relatórios", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbx29.setText("Contas a Pagar");

        cbx28.setText("Extrato de Caixa");

        cbx33.setText("SubMenu Relatório Prestação de Contas");

        cbx31.setText("SubMenu Relatório Dízimo/Oferta");

        cbx27.setText("SubMenu Relatório Financeiro");

        cbx34.setText("Prestação de Contas Mensal");

        cbx32.setText("Movimento Dizimo e Oferta");

        cbx26.setText("Menu Relatórios");

        cbx30.setText("Contas a Receber");

        cbx24.setText("Aplicação Financeira");

        cbx25.setText("Retirar Aplicação");

        javax.swing.GroupLayout acessosMenusLayout = new javax.swing.GroupLayout(acessosMenus);
        acessosMenus.setLayout(acessosMenusLayout);
        acessosMenusLayout.setHorizontalGroup(
            acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jSeparator1)
            .addGroup(acessosMenusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx20))
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx21))
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx14))
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx8))
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx10))
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx4))
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx30))
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx34))
                    .addGroup(acessosMenusLayout.createSequentialGroup()
                        .addComponent(cbx25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbx24))
                    .addComponent(cbx33))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        acessosMenusLayout.setVerticalGroup(
            acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acessosMenusLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx1)
                    .addComponent(cbx2)
                    .addComponent(cbx3)
                    .addComponent(cbx4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx11)
                    .addComponent(cbx6)
                    .addComponent(cbx7)
                    .addComponent(cbx8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx9)
                    .addComponent(cbx5)
                    .addComponent(cbx10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx18)
                    .addComponent(cbx14)
                    .addComponent(cbx12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx15)
                    .addComponent(cbx23)
                    .addComponent(cbx22)
                    .addComponent(cbx20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx17)
                    .addComponent(cbx16)
                    .addComponent(cbx19)
                    .addComponent(cbx21))
                .addGap(5, 5, 5)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx25)
                    .addComponent(cbx13)
                    .addComponent(cbx24))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx26)
                    .addComponent(cbx28)
                    .addComponent(cbx27)
                    .addComponent(cbx29)
                    .addComponent(cbx30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx32)
                    .addComponent(cbx31)
                    .addComponent(cbx34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx33)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        acessosUsuario.addTab("Acesso Menus", acessosMenus);

        jSeparator4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Campanhas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbx39.setText("Cadastro de Editora/Publicadoras");

        cbx38.setText("Cadastro de Autores");

        cbx37.setText("Cadastro de Livros");

        cbx46.setText("Empréstimos Livros");

        cbx47.setText("Gerenciar/Consultar Empréstimos");

        cbx45.setText("SubMenu Empréstimos de Livros");

        cbx41.setText("SubMenu Operações Biblioteca");

        cbx36.setText("SubMenu Cadastros Biblioteca");

        cbx44.setText("Saída Avulsa de Livros");

        cbx43.setText("Adiconar Livros Bibliotecas");

        cbx42.setText("Consultar Bibliotecas");

        cbx40.setText("Cadastro de Tipos Bibliotecas");

        cbx35.setText("Menu Biblioteca");

        jSeparator5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Biblioteca", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbx48.setText("Menu Campanha");

        cbx54.setText("Lançar Contas a Receber Campanha");

        cbx55.setText("Consultar Campanha");

        cbx53.setText("Remover Participantes");

        cbx52.setText("Adicionar Participantes");

        cbx51.setText("SubMenu Processos Avulsos");

        cbx50.setText("Gerenciar Contas Receber Campanha");

        cbx49.setText("Criar/Cadastrar Campanhas");

        jSeparator6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu Configurações", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbx58.setText("Acesso de Usuários");

        cbx56.setText("Menu Configuração");

        cbx57.setText("SubMenu Usuários");

        cbx59.setText("Menu Alterar Senha");

        cbx60.setText("Alterar Senha");

        javax.swing.GroupLayout acessosMenu1Layout = new javax.swing.GroupLayout(acessosMenu1);
        acessosMenu1.setLayout(acessosMenu1Layout);
        acessosMenu1Layout.setHorizontalGroup(
            acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4)
            .addComponent(jSeparator6)
            .addGroup(acessosMenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(acessosMenu1Layout.createSequentialGroup()
                        .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(acessosMenu1Layout.createSequentialGroup()
                                .addComponent(cbx41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx39)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx44))
                            .addGroup(acessosMenu1Layout.createSequentialGroup()
                                .addComponent(cbx35)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx38))
                            .addGroup(acessosMenu1Layout.createSequentialGroup()
                                .addComponent(cbx43)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx42)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx47))
                            .addGroup(acessosMenu1Layout.createSequentialGroup()
                                .addComponent(cbx48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx49)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx53))
                            .addGroup(acessosMenu1Layout.createSequentialGroup()
                                .addComponent(cbx54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx55)))
                        .addContainerGap(26, Short.MAX_VALUE))
                    .addGroup(acessosMenu1Layout.createSequentialGroup()
                        .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(acessosMenu1Layout.createSequentialGroup()
                                .addComponent(cbx36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx45))
                            .addGroup(acessosMenu1Layout.createSequentialGroup()
                                .addComponent(cbx56)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx57)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx59)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbx60)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        acessosMenu1Layout.setVerticalGroup(
            acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acessosMenu1Layout.createSequentialGroup()
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx35)
                    .addComponent(cbx37)
                    .addComponent(cbx40)
                    .addComponent(cbx38))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx41)
                    .addComponent(cbx46)
                    .addComponent(cbx39)
                    .addComponent(cbx44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx43)
                    .addComponent(cbx42)
                    .addComponent(cbx47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx36)
                    .addComponent(cbx45))
                .addGap(16, 16, 16)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx48)
                    .addComponent(cbx49)
                    .addComponent(cbx50)
                    .addComponent(cbx53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx54)
                    .addComponent(cbx52)
                    .addComponent(cbx51)
                    .addComponent(cbx55))
                .addGap(26, 26, 26)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx56)
                    .addComponent(cbx57)
                    .addComponent(cbx58)
                    .addComponent(cbx59)
                    .addComponent(cbx60))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        acessosUsuario.addTab("Acesso Menus 1", acessosMenu1);

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        codUsuario.setEditable(false);
        codUsuario.setBackground(new java.awt.Color(204, 204, 204));

        nomeUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nomeUsuarioKeyPressed(evt);
            }
        });

        btnOk.setBackground(new java.awt.Color(0, 153, 255));
        btnOk.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnOk.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(acessosUsuario)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(acessosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(codUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOk))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeUsuarioKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            consultarUsuarios();
            carregarResultadoConsultaUsuarios();
            if(verificarFuncaoUsuario()){
                consultarCarregarAcessosPersonalizado();
            }else{
                JOptionPane.showMessageDialog(null, "Para personalizar o acesso, é preciso definir a função PERSONALIZADO no cadastro do usuário", "Erro", JOptionPane.WARNING_MESSAGE);
                formInicial();
            }
        }
    }//GEN-LAST:event_nomeUsuarioKeyPressed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        salvarAlterarAcessosCadastrados();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void nomearCheckBox(){
        this.cbx1.setName("1");
        this.cbx2.setName("2");
        this.cbx3.setName("3");
        this.cbx4.setName("4");
        this.cbx5.setName("5");
        this.cbx6.setName("6");
        this.cbx7.setName("7");
        this.cbx8.setName("8");
        this.cbx9.setName("9");
        this.cbx10.setName("10");
        this.cbx11.setName("11");
        this.cbx12.setName("12");
        this.cbx13.setName("13");
        this.cbx14.setName("14");
        this.cbx15.setName("15");
        this.cbx16.setName("16");
        this.cbx17.setName("17");
        this.cbx18.setName("18");
        this.cbx19.setName("19");
        this.cbx20.setName("20");
        this.cbx21.setName("21");
        this.cbx22.setName("22");
        this.cbx23.setName("23");
        this.cbx24.setName("24");
        this.cbx25.setName("25");
        this.cbx26.setName("26");
        this.cbx27.setName("27");
        this.cbx28.setName("28");
        this.cbx29.setName("29");
        this.cbx30.setName("30");
        this.cbx31.setName("31");
        this.cbx32.setName("32");
        this.cbx33.setName("33");
        this.cbx34.setName("34");
        this.cbx35.setName("35");
        this.cbx36.setName("36");
        this.cbx37.setName("37");
        this.cbx38.setName("38");
        this.cbx39.setName("39");
        this.cbx40.setName("40");
        this.cbx41.setName("41");
        this.cbx42.setName("42");
        this.cbx43.setName("43");
        this.cbx44.setName("44");
        this.cbx45.setName("45");
        this.cbx46.setName("46");
        this.cbx47.setName("47");
        this.cbx48.setName("48");
        this.cbx49.setName("49");
        this.cbx50.setName("50");
        this.cbx51.setName("51");
        this.cbx52.setName("52");
        this.cbx53.setName("53");
        this.cbx54.setName("54");
        this.cbx55.setName("55");
        this.cbx56.setName("56");
        this.cbx57.setName("57");
        this.cbx58.setName("58");
        this.cbx59.setName("59");
        this.cbx60.setName("60");
    }
    
    private void consultarUsuarios(){
        String textoBusca = this.nomeUsuario.getText();
        this.listaUsuario = this.usuarioDao.consultarUsuario(textoBusca);
    }
    
    private void carregarResultadoConsultaUsuarios(){
        TelaConsultaUsuarios resultConsultaUsuarios = new TelaConsultaUsuarios((Frame) SwingUtilities.getWindowAncestor(this), this.listaUsuario);
        resultConsultaUsuarios.setUsuarioSelecionado(this);
        resultConsultaUsuarios.setLocationRelativeTo(this);
        resultConsultaUsuarios.setVisible(true);
    }
    
    private void carregarUsuarioEscolhido(Usuario usuario){
        this.codUsuario.setText(String.valueOf(usuario.getCodigo()));
        this.nomeUsuario.setText(usuario.getNome());

    }
    
    private void formInicial(){
        this.codUsuario.setText("");
        this.nomeUsuario.setText("");
        
        //Percorre todos os checkbox e desmarca eles
        for (Component comp : this.acessosMenus.getComponents()) {
            // Verificar se o componente é um JCheckBox
            if(comp instanceof JCheckBox checkBox) {
                checkBox.setSelected(false);  // Desmarcar o JCheckBox
            }
        }
        
        //Percorre todos os checkbox e desmarca eles
        for (Component comp : this.acessosMenu1.getComponents()) {
            // Verificar se o componente é um JCheckBox
            if(comp instanceof JCheckBox checkBox) {
                checkBox.setSelected(false);  // Desmarcar o JCheckBox
            }
        }
    }
    
    private void consultarCarregarAcessosPersonalizado(){
        
        Usuario usuario = new Usuario();
        usuario.setCodigo(Integer.valueOf(this.codUsuario.getText()));
        this.listaConsultaAcesso = usuarioDao.consultarAcessosPersonalizados(usuario);
        
        for(Acessos aces : listaConsultaAcesso){
                   
            //Percorre o checkbox primeiro painel
            for (Component comp : this.acessosMenus.getComponents()) {
                // Verificar se o componente é um JCheckBox
                if(comp instanceof JCheckBox checkBox) {
                    if(aces.getMenuId() == Integer.valueOf(checkBox.getName()) && aces.getPodeAcesasr() == 1){
                        checkBox.setSelected(true);  // Desmarcar o JCheckBox
                    }else if(aces.getMenuId() == Integer.valueOf(checkBox.getName()) && aces.getPodeAcesasr() == 0){
                        checkBox.setSelected(false);  // Desmarcar o JCheckBox
                    }
                }
            }

            //Percorre o checkbox do segundo painel
            for (Component comp : this.acessosMenu1.getComponents()) {
                // Verificar se o componente é um JCheckBox
                if(comp instanceof JCheckBox checkBox) {
                    if(aces.getMenuId() == Integer.valueOf(checkBox.getName())  && aces.getPodeAcesasr() == 1){
                        checkBox.setSelected(true);  // Desmarcar o JCheckBox
                    }else if(aces.getMenuId() == Integer.valueOf(checkBox.getName())  && aces.getPodeAcesasr() == 0){
                        checkBox.setSelected(false);  // Desmarcar o JCheckBox
                    }
                }
            }
            
        } 
    }
    
    private boolean verificarFuncaoUsuario(){
        UsuarioLogado usuario = new UsuarioLogado();
        usuario.setCodUsuario(Integer.valueOf(this.codUsuario.getText()));
        boolean userPersonalizado = false;
        
        //Obter a função do usuário
        FuncoesUsuario funcao = usuarioDao.consultarFuncaoUsuario(usuario);
        
        if(funcao.getCodigo() == 1){
            userPersonalizado = true;
        }
        
        return userPersonalizado;
    }
    
    private void salvarAlterarAcessosCadastrados(){
        
        List<Acessos> listaAcessoAtual = this.listaConsultaAcesso; //Acessos que o usuário tem atualmente
        List<Acessos> listaAcessosAlterados = acessosPersonalizado(); //Acesso adicionados ou retirados
        
        //Verifica se a lista de consulta dos acessos personalizados não é vazia
        if(!listaAcessoAtual.isEmpty()){
            //Chamar função que altera o acesso que já existe para o usuário
            usuarioDao.alterarAcessosPersonalizados(listaAcessosAlterados);
        }else{
            //Chama função que cadastrada os acesso que nunca foram utilizados pelo usuário
            usuarioDao.salvarAcessosPersonalizados(listaAcessosAlterados);
        }
    }
    
    private List<Acessos> acessosPersonalizado(){
        
        Usuario usuario = new Usuario();
        List<Acessos> listaAcessosPerson = new ArrayList<>();
        usuario.setCodigo(Integer.valueOf(this.codUsuario.getText()));
        Integer podeAcessar = 0;
        Integer menuId = 0;
        
        //Percorre todos os checkbox e desmarca eles
        for (Component comp : this.acessosMenus.getComponents()) {
            // Verificar se o componente é um JCheckBox
            if(comp instanceof JCheckBox checkBox) {
                if(checkBox.isSelected()){
                    podeAcessar = 1;
                }else{
                    podeAcessar = 0; 
                }
                menuId = Integer.valueOf(checkBox.getName());
                Acessos acessoPerson = new Acessos();
                acessoPerson.setCadastrar(0);
                acessoPerson.setEditar(0);
                acessoPerson.setExcluir(0);
                acessoPerson.setMenuId(menuId);
                acessoPerson.setPodeAcesasr(podeAcessar);
                acessoPerson.setUsuario(usuario);
                
                listaAcessosPerson.add(acessoPerson);
            }
        }
        
        //Zerando as variáveis
        podeAcessar = 0;
        menuId = 0;

        //Percorre todos os checkbox e desmarca eles
        for (Component comp : this.acessosMenu1.getComponents()) {
            // Verificar se o componente é um JCheckBox
            if(comp instanceof JCheckBox checkBox) {
                if(checkBox.isSelected()){
                    podeAcessar = 1;
                }else{
                    podeAcessar = 0; 
                }
                
                menuId = Integer.valueOf(checkBox.getName());
                Acessos acessoPerson = new Acessos();
                acessoPerson.setCadastrar(0);
                acessoPerson.setEditar(0);
                acessoPerson.setExcluir(0);
                acessoPerson.setMenuId(menuId);
                acessoPerson.setPodeAcesasr(podeAcessar);
                acessoPerson.setUsuario(usuario);
                
                listaAcessosPerson.add(acessoPerson);
            }
        }    

        return listaAcessosPerson;
        
    }
   
    
    @Override
    public void usuarioSelecionado(Usuario usuarioEscolhido) {
        carregarUsuarioEscolhido(usuarioEscolhido);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acessosMenu1;
    private javax.swing.JPanel acessosMenus;
    private javax.swing.JTabbedPane acessosUsuario;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox cbx1;
    private javax.swing.JCheckBox cbx10;
    private javax.swing.JCheckBox cbx11;
    private javax.swing.JCheckBox cbx12;
    private javax.swing.JCheckBox cbx13;
    private javax.swing.JCheckBox cbx14;
    private javax.swing.JCheckBox cbx15;
    private javax.swing.JCheckBox cbx16;
    private javax.swing.JCheckBox cbx17;
    private javax.swing.JCheckBox cbx18;
    private javax.swing.JCheckBox cbx19;
    private javax.swing.JCheckBox cbx2;
    private javax.swing.JCheckBox cbx20;
    private javax.swing.JCheckBox cbx21;
    private javax.swing.JCheckBox cbx22;
    private javax.swing.JCheckBox cbx23;
    private javax.swing.JCheckBox cbx24;
    private javax.swing.JCheckBox cbx25;
    private javax.swing.JCheckBox cbx26;
    private javax.swing.JCheckBox cbx27;
    private javax.swing.JCheckBox cbx28;
    private javax.swing.JCheckBox cbx29;
    private javax.swing.JCheckBox cbx3;
    private javax.swing.JCheckBox cbx30;
    private javax.swing.JCheckBox cbx31;
    private javax.swing.JCheckBox cbx32;
    private javax.swing.JCheckBox cbx33;
    private javax.swing.JCheckBox cbx34;
    private javax.swing.JCheckBox cbx35;
    private javax.swing.JCheckBox cbx36;
    private javax.swing.JCheckBox cbx37;
    private javax.swing.JCheckBox cbx38;
    private javax.swing.JCheckBox cbx39;
    private javax.swing.JCheckBox cbx4;
    private javax.swing.JCheckBox cbx40;
    private javax.swing.JCheckBox cbx41;
    private javax.swing.JCheckBox cbx42;
    private javax.swing.JCheckBox cbx43;
    private javax.swing.JCheckBox cbx44;
    private javax.swing.JCheckBox cbx45;
    private javax.swing.JCheckBox cbx46;
    private javax.swing.JCheckBox cbx47;
    private javax.swing.JCheckBox cbx48;
    private javax.swing.JCheckBox cbx49;
    private javax.swing.JCheckBox cbx5;
    private javax.swing.JCheckBox cbx50;
    private javax.swing.JCheckBox cbx51;
    private javax.swing.JCheckBox cbx52;
    private javax.swing.JCheckBox cbx53;
    private javax.swing.JCheckBox cbx54;
    private javax.swing.JCheckBox cbx55;
    private javax.swing.JCheckBox cbx56;
    private javax.swing.JCheckBox cbx57;
    private javax.swing.JCheckBox cbx58;
    private javax.swing.JCheckBox cbx59;
    private javax.swing.JCheckBox cbx6;
    private javax.swing.JCheckBox cbx60;
    private javax.swing.JCheckBox cbx7;
    private javax.swing.JCheckBox cbx8;
    private javax.swing.JCheckBox cbx9;
    private javax.swing.JTextField codUsuario;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField nomeUsuario;
    // End of variables declaration//GEN-END:variables

}
