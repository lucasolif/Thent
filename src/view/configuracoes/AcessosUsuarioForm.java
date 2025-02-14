
package view.configuracoes;

import java.awt.Dimension;


public class AcessosUsuarioForm extends javax.swing.JInternalFrame {


    public AcessosUsuarioForm() {
        initComponents();
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        acessoMenus1 = new javax.swing.JTabbedPane();
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
        jSeparator7 = new javax.swing.JSeparator();
        cbx59 = new javax.swing.JCheckBox();
        cbx60 = new javax.swing.JCheckBox();
        permissoes = new javax.swing.JPanel();
        cbx61 = new javax.swing.JCheckBox();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Acessos de Usuários");

        acessoMenus1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

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
                .addContainerGap(60, Short.MAX_VALUE))
        );

        acessoMenus1.addTab("Acesso Menus", acessosMenus);

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

        jSeparator7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alterar Senha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

        cbx59.setText("Menu Alterar Senha");

        cbx60.setText("Alterar Senha");

        javax.swing.GroupLayout acessosMenu1Layout = new javax.swing.GroupLayout(acessosMenu1);
        acessosMenu1.setLayout(acessosMenu1Layout);
        acessosMenu1Layout.setHorizontalGroup(
            acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator4)
            .addComponent(jSeparator6)
            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
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
                                .addComponent(cbx58))
                            .addGroup(acessosMenu1Layout.createSequentialGroup()
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
                    .addComponent(cbx58))
                .addGap(41, 41, 41)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx59)
                    .addComponent(cbx60))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        acessoMenus1.addTab("Acesso Menus 1", acessosMenu1);

        cbx61.setText("Acessar os dados de todos os campo/igrejas?");

        javax.swing.GroupLayout permissoesLayout = new javax.swing.GroupLayout(permissoes);
        permissoes.setLayout(permissoesLayout);
        permissoesLayout.setHorizontalGroup(
            permissoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(permissoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbx61)
                .addContainerGap(449, Short.MAX_VALUE))
        );
        permissoesLayout.setVerticalGroup(
            permissoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(permissoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbx61)
                .addContainerGap(371, Short.MAX_VALUE))
        );

        acessoMenus1.addTab("Permissões", permissoes);

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(acessoMenus1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(acessoMenus1)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane acessoMenus1;
    private javax.swing.JPanel acessosMenu1;
    private javax.swing.JPanel acessosMenus;
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
    private javax.swing.JCheckBox cbx61;
    private javax.swing.JCheckBox cbx7;
    private javax.swing.JCheckBox cbx8;
    private javax.swing.JCheckBox cbx9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel permissoes;
    // End of variables declaration//GEN-END:variables
}
