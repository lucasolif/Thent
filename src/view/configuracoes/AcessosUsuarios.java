
package view.configuracoes;

import interfaces.ConsultaUsuarios;
import model.Usuario;


public class AcessosUsuarios extends javax.swing.JDialog {
    
    private ConsultaUsuarios consultaUsuarios;
    private Usuario usuarioSelec = null;

    public AcessosUsuarios(java.awt.Frame onwer, Usuario usuario) {
        super(onwer, true);
        initComponents();
        carregarUsuarioConsultadas(usuario);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastroUsuarios = new javax.swing.JTabbedPane();
        acessosCadastro = new javax.swing.JPanel();
        formCadastroPessoaMembros = new javax.swing.JCheckBox();
        formCadastroIgrejaCampos = new javax.swing.JCheckBox();
        formCadastroUsuario = new javax.swing.JCheckBox();
        formCadastroFormaPagto = new javax.swing.JCheckBox();
        formCadastroContaCaixa = new javax.swing.JCheckBox();
        formCadastroTipoOferta = new javax.swing.JCheckBox();
        formCadastroContaResultado = new javax.swing.JCheckBox();
        formCadastroSubContaResultado = new javax.swing.JCheckBox();
        subMenuEntidades = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        subMenuPlanoContas = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        menuCadastro = new javax.swing.JCheckBox();
        jSeparator11 = new javax.swing.JSeparator();
        acessosFinanceiro = new javax.swing.JPanel();
        subMenuOperacaoDizimoOferta = new javax.swing.JCheckBox();
        subMenuContasPagar = new javax.swing.JCheckBox();
        subMenuOperacaoCaixa = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        formRegistrarDizimoOferta = new javax.swing.JCheckBox();
        formConsultarDizimosOfertas = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        formLancarContasPagar = new javax.swing.JCheckBox();
        formEfetivarConsultarContasPagar = new javax.swing.JCheckBox();
        formCancelarContasPagar = new javax.swing.JCheckBox();
        formAlterarContasPagar = new javax.swing.JCheckBox();
        jSeparator5 = new javax.swing.JSeparator();
        formTransferenciaBancaria = new javax.swing.JCheckBox();
        formMovimentoFinanceiro = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        menuFinanceiro = new javax.swing.JCheckBox();
        jSeparator12 = new javax.swing.JSeparator();
        acessosRelatorios = new javax.swing.JPanel();
        acessosBiblioteca = new javax.swing.JPanel();
        SubMenuCadastro = new javax.swing.JCheckBox();
        subMenuBiblioteca = new javax.swing.JCheckBox();
        subMenuEmprestimosLivros = new javax.swing.JCheckBox();
        jSeparator7 = new javax.swing.JSeparator();
        formCadastroLivros = new javax.swing.JCheckBox();
        formCadastroAutores = new javax.swing.JCheckBox();
        formCadastroEditora = new javax.swing.JCheckBox();
        formCadastroBiblioteca = new javax.swing.JCheckBox();
        jSeparator8 = new javax.swing.JSeparator();
        formConsultaBiblioteca = new javax.swing.JCheckBox();
        formAdicionarLivroBiblioteca = new javax.swing.JCheckBox();
        formSaidaAvulsaLivros = new javax.swing.JCheckBox();
        jSeparator9 = new javax.swing.JSeparator();
        formEmprestimoLivro = new javax.swing.JCheckBox();
        formGerenciarEmprestimo = new javax.swing.JCheckBox();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSeparator13 = new javax.swing.JSeparator();
        acessosCampanha = new javax.swing.JPanel();
        formCriarCadastrarCampanha = new javax.swing.JCheckBox();
        formGerenciarContaReceber = new javax.swing.JCheckBox();
        subMenuProcessosAvulsos = new javax.swing.JCheckBox();
        jSeparator10 = new javax.swing.JSeparator();
        formAdicionarParticipante = new javax.swing.JCheckBox();
        formRemoverParticipante = new javax.swing.JCheckBox();
        formLancarContaReceber = new javax.swing.JCheckBox();
        menuCampanha = new javax.swing.JCheckBox();
        jSeparator14 = new javax.swing.JSeparator();
        acessosConfigurações = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        marcarTodos = new javax.swing.JLabel();
        desmarcarTodos = new javax.swing.JLabel();
        inverterSelecao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acessos do Usuário");

        cadastroUsuarios.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        cadastroUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        formCadastroPessoaMembros.setText("Cadastro de Pessoas e Membros");

        formCadastroIgrejaCampos.setText("Cadastro de Igrejas/Campos");

        formCadastroUsuario.setText("Cadastro de Usuário");

        formCadastroFormaPagto.setText("Cadastro Forma Pagto");

        formCadastroContaCaixa.setText("Cadastro Conta Caixa");

        formCadastroTipoOferta.setText("Cadastro Tipo de Oferta");

        formCadastroContaResultado.setText("Cadastro Conta de Resultado");

        formCadastroSubContaResultado.setText("Cadastro Sub Conta de Resultado");

        subMenuEntidades.setText("Entidades");

        subMenuPlanoContas.setText("Plano De Contas");

        menuCadastro.setText("Cadastros");

        javax.swing.GroupLayout acessosCadastroLayout = new javax.swing.GroupLayout(acessosCadastro);
        acessosCadastro.setLayout(acessosCadastroLayout);
        acessosCadastroLayout.setHorizontalGroup(
            acessosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator11)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(acessosCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(acessosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(acessosCadastroLayout.createSequentialGroup()
                        .addComponent(formCadastroFormaPagto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formCadastroContaCaixa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formCadastroTipoOferta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subMenuPlanoContas)
                        .addContainerGap(8, Short.MAX_VALUE))
                    .addGroup(acessosCadastroLayout.createSequentialGroup()
                        .addGroup(acessosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(menuCadastro)
                            .addComponent(subMenuEntidades)
                            .addGroup(acessosCadastroLayout.createSequentialGroup()
                                .addComponent(formCadastroPessoaMembros)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formCadastroIgrejaCampos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formCadastroUsuario))
                            .addGroup(acessosCadastroLayout.createSequentialGroup()
                                .addComponent(formCadastroSubContaResultado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formCadastroContaResultado)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        acessosCadastroLayout.setVerticalGroup(
            acessosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acessosCadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formCadastroPessoaMembros)
                    .addComponent(formCadastroIgrejaCampos)
                    .addComponent(formCadastroUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subMenuEntidades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formCadastroFormaPagto)
                    .addComponent(formCadastroContaCaixa)
                    .addComponent(formCadastroTipoOferta)
                    .addComponent(subMenuPlanoContas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formCadastroSubContaResultado)
                    .addComponent(formCadastroContaResultado))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        cadastroUsuarios.addTab("Cadastros", acessosCadastro);

        subMenuOperacaoDizimoOferta.setText("Operação Dizimos/Ofertas");

        subMenuContasPagar.setText("Contas a Pagar");

        subMenuOperacaoCaixa.setText("Operações Caixa");

        formRegistrarDizimoOferta.setText("Registrar Dizimo ou Ofertas");

        formConsultarDizimosOfertas.setText("Consultar Dízimos ou Ofertas");

        formLancarContasPagar.setText("Lançar Contas a Pagar");

        formEfetivarConsultarContasPagar.setText("Efetivar/Consutar Contas a Pagar");

        formCancelarContasPagar.setText("Cancelar Contas a Pagar");

        formAlterarContasPagar.setText("Alterar Contas a Pagar");

        formTransferenciaBancaria.setText("Transferências Bancárias");

        formMovimentoFinanceiro.setText("Movimento Financeiro");

        menuFinanceiro.setText("Financeiro");

        javax.swing.GroupLayout acessosFinanceiroLayout = new javax.swing.GroupLayout(acessosFinanceiro);
        acessosFinanceiro.setLayout(acessosFinanceiroLayout);
        acessosFinanceiroLayout.setHorizontalGroup(
            acessosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator12)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addComponent(jSeparator6)
            .addGroup(acessosFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(acessosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuFinanceiro)
                    .addGroup(acessosFinanceiroLayout.createSequentialGroup()
                        .addComponent(subMenuOperacaoDizimoOferta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subMenuContasPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subMenuOperacaoCaixa))
                    .addGroup(acessosFinanceiroLayout.createSequentialGroup()
                        .addComponent(formRegistrarDizimoOferta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formConsultarDizimosOfertas))
                    .addGroup(acessosFinanceiroLayout.createSequentialGroup()
                        .addComponent(formLancarContasPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formEfetivarConsultarContasPagar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formCancelarContasPagar))
                    .addComponent(formAlterarContasPagar)
                    .addGroup(acessosFinanceiroLayout.createSequentialGroup()
                        .addComponent(formTransferenciaBancaria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formMovimentoFinanceiro)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        acessosFinanceiroLayout.setVerticalGroup(
            acessosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acessosFinanceiroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuFinanceiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subMenuOperacaoDizimoOferta)
                    .addComponent(subMenuContasPagar)
                    .addComponent(subMenuOperacaoCaixa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formRegistrarDizimoOferta)
                    .addComponent(formConsultarDizimosOfertas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formLancarContasPagar)
                    .addComponent(formEfetivarConsultarContasPagar)
                    .addComponent(formCancelarContasPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formAlterarContasPagar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosFinanceiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formTransferenciaBancaria)
                    .addComponent(formMovimentoFinanceiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        cadastroUsuarios.addTab(" Financeiro", acessosFinanceiro);

        javax.swing.GroupLayout acessosRelatoriosLayout = new javax.swing.GroupLayout(acessosRelatorios);
        acessosRelatorios.setLayout(acessosRelatoriosLayout);
        acessosRelatoriosLayout.setHorizontalGroup(
            acessosRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        acessosRelatoriosLayout.setVerticalGroup(
            acessosRelatoriosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        cadastroUsuarios.addTab("Relatórios", acessosRelatorios);

        SubMenuCadastro.setText("Cadastros");

        subMenuBiblioteca.setText("Biblioteca");

        subMenuEmprestimosLivros.setText("Empréstimos Livros");

        formCadastroLivros.setText("Cadastro de Livros");

        formCadastroAutores.setText("Cadastro de Autores");

        formCadastroEditora.setText("Cadastro de Editora/Publicadoras");

        formCadastroBiblioteca.setText("Cadastro de Bibliotecas");

        formConsultaBiblioteca.setText("Consultar Bibliotecas");

        formAdicionarLivroBiblioteca.setText("Adiconar Livros Bibliotecas");

        formSaidaAvulsaLivros.setText("Saída Avulsa de Livros");

        formEmprestimoLivro.setText("Empréstimos de Livros");

        formGerenciarEmprestimo.setText("Gerenciar Empréstimos");

        jCheckBox1.setText("Biblioteca");

        javax.swing.GroupLayout acessosBibliotecaLayout = new javax.swing.GroupLayout(acessosBiblioteca);
        acessosBiblioteca.setLayout(acessosBibliotecaLayout);
        acessosBibliotecaLayout.setHorizontalGroup(
            acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator13)
            .addComponent(jSeparator7)
            .addComponent(jSeparator8)
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(acessosBibliotecaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(acessosBibliotecaLayout.createSequentialGroup()
                        .addGroup(acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(acessosBibliotecaLayout.createSequentialGroup()
                                .addComponent(SubMenuCadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subMenuBiblioteca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subMenuEmprestimosLivros))
                            .addGroup(acessosBibliotecaLayout.createSequentialGroup()
                                .addComponent(formCadastroLivros)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formCadastroAutores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formCadastroEditora))
                            .addComponent(formCadastroBiblioteca)
                            .addGroup(acessosBibliotecaLayout.createSequentialGroup()
                                .addComponent(formConsultaBiblioteca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formAdicionarLivroBiblioteca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formSaidaAvulsaLivros)))
                        .addContainerGap(101, Short.MAX_VALUE))
                    .addGroup(acessosBibliotecaLayout.createSequentialGroup()
                        .addGroup(acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addGroup(acessosBibliotecaLayout.createSequentialGroup()
                                .addComponent(formEmprestimoLivro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(formGerenciarEmprestimo)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        acessosBibliotecaLayout.setVerticalGroup(
            acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acessosBibliotecaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SubMenuCadastro)
                    .addComponent(subMenuBiblioteca)
                    .addComponent(subMenuEmprestimosLivros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formCadastroLivros)
                    .addComponent(formCadastroAutores)
                    .addComponent(formCadastroEditora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formCadastroBiblioteca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formConsultaBiblioteca)
                    .addComponent(formAdicionarLivroBiblioteca)
                    .addComponent(formSaidaAvulsaLivros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosBibliotecaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formEmprestimoLivro)
                    .addComponent(formGerenciarEmprestimo))
                .addContainerGap(142, Short.MAX_VALUE))
        );

        cadastroUsuarios.addTab("Biblioteca", acessosBiblioteca);

        formCriarCadastrarCampanha.setText("Criar/Cadastrar Campanhas");

        formGerenciarContaReceber.setText("Gerenciar Contas Receber Campanha");

        subMenuProcessosAvulsos.setText("Processos Avulsos");

        formAdicionarParticipante.setText("Adicionar Participantes");

        formRemoverParticipante.setText("Remover Participantes");

        formLancarContaReceber.setText("Lançar Contas a Receber Campanha");

        menuCampanha.setText("Campanha");

        javax.swing.GroupLayout acessosCampanhaLayout = new javax.swing.GroupLayout(acessosCampanha);
        acessosCampanha.setLayout(acessosCampanhaLayout);
        acessosCampanhaLayout.setHorizontalGroup(
            acessosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator14)
            .addComponent(jSeparator10)
            .addGroup(acessosCampanhaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(acessosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuCampanha)
                    .addGroup(acessosCampanhaLayout.createSequentialGroup()
                        .addComponent(formCriarCadastrarCampanha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formGerenciarContaReceber)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subMenuProcessosAvulsos))
                    .addGroup(acessosCampanhaLayout.createSequentialGroup()
                        .addComponent(formAdicionarParticipante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formRemoverParticipante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formLancarContaReceber)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        acessosCampanhaLayout.setVerticalGroup(
            acessosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(acessosCampanhaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuCampanha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formCriarCadastrarCampanha)
                    .addComponent(formGerenciarContaReceber)
                    .addComponent(subMenuProcessosAvulsos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(acessosCampanhaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formAdicionarParticipante)
                    .addComponent(formRemoverParticipante)
                    .addComponent(formLancarContaReceber))
                .addContainerGap(238, Short.MAX_VALUE))
        );

        cadastroUsuarios.addTab("Campanhas", acessosCampanha);

        javax.swing.GroupLayout acessosConfiguraçõesLayout = new javax.swing.GroupLayout(acessosConfigurações);
        acessosConfigurações.setLayout(acessosConfiguraçõesLayout);
        acessosConfiguraçõesLayout.setHorizontalGroup(
            acessosConfiguraçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        acessosConfiguraçõesLayout.setVerticalGroup(
            acessosConfiguraçõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );

        cadastroUsuarios.addTab("Configurações", acessosConfigurações);

        btnSalvar.setBackground(new java.awt.Color(51, 204, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");

        marcarTodos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        marcarTodos.setText("Marcar todos");
        marcarTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        marcarTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                marcarTodosMouseClicked(evt);
            }
        });

        desmarcarTodos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        desmarcarTodos.setText("Desmarca todos");
        desmarcarTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        desmarcarTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desmarcarTodosMouseClicked(evt);
            }
        });

        inverterSelecao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        inverterSelecao.setText("Inverter Seleção");
        inverterSelecao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inverterSelecao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inverterSelecaoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cadastroUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(marcarTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(desmarcarTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inverterSelecao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cadastroUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(marcarTodos)
                    .addComponent(desmarcarTodos)
                    .addComponent(inverterSelecao))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void marcarTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_marcarTodosMouseClicked
       
    }//GEN-LAST:event_marcarTodosMouseClicked

    private void desmarcarTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desmarcarTodosMouseClicked
        
    }//GEN-LAST:event_desmarcarTodosMouseClicked

    private void inverterSelecaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inverterSelecaoMouseClicked
        
    }//GEN-LAST:event_inverterSelecaoMouseClicked

    private void carregarUsuarioConsultadas(Usuario usuario){                  
        this.usuarioSelec = usuario;      
    }
    
    public void setUsuarioSelecionado(ConsultaUsuarios consultaUsuarios) {
        this.consultaUsuarios = consultaUsuarios;
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox SubMenuCadastro;
    private javax.swing.JPanel acessosBiblioteca;
    private javax.swing.JPanel acessosCadastro;
    private javax.swing.JPanel acessosCampanha;
    private javax.swing.JPanel acessosConfigurações;
    private javax.swing.JPanel acessosFinanceiro;
    private javax.swing.JPanel acessosRelatorios;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTabbedPane cadastroUsuarios;
    private javax.swing.JLabel desmarcarTodos;
    private javax.swing.JCheckBox formAdicionarLivroBiblioteca;
    private javax.swing.JCheckBox formAdicionarParticipante;
    private javax.swing.JCheckBox formAlterarContasPagar;
    private javax.swing.JCheckBox formCadastroAutores;
    private javax.swing.JCheckBox formCadastroBiblioteca;
    private javax.swing.JCheckBox formCadastroContaCaixa;
    private javax.swing.JCheckBox formCadastroContaResultado;
    private javax.swing.JCheckBox formCadastroEditora;
    private javax.swing.JCheckBox formCadastroFormaPagto;
    private javax.swing.JCheckBox formCadastroIgrejaCampos;
    private javax.swing.JCheckBox formCadastroLivros;
    private javax.swing.JCheckBox formCadastroPessoaMembros;
    private javax.swing.JCheckBox formCadastroSubContaResultado;
    private javax.swing.JCheckBox formCadastroTipoOferta;
    private javax.swing.JCheckBox formCadastroUsuario;
    private javax.swing.JCheckBox formCancelarContasPagar;
    private javax.swing.JCheckBox formConsultaBiblioteca;
    private javax.swing.JCheckBox formConsultarDizimosOfertas;
    private javax.swing.JCheckBox formCriarCadastrarCampanha;
    private javax.swing.JCheckBox formEfetivarConsultarContasPagar;
    private javax.swing.JCheckBox formEmprestimoLivro;
    private javax.swing.JCheckBox formGerenciarContaReceber;
    private javax.swing.JCheckBox formGerenciarEmprestimo;
    private javax.swing.JCheckBox formLancarContaReceber;
    private javax.swing.JCheckBox formLancarContasPagar;
    private javax.swing.JCheckBox formMovimentoFinanceiro;
    private javax.swing.JCheckBox formRegistrarDizimoOferta;
    private javax.swing.JCheckBox formRemoverParticipante;
    private javax.swing.JCheckBox formSaidaAvulsaLivros;
    private javax.swing.JCheckBox formTransferenciaBancaria;
    private javax.swing.JLabel inverterSelecao;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel marcarTodos;
    private javax.swing.JCheckBox menuCadastro;
    private javax.swing.JCheckBox menuCampanha;
    private javax.swing.JCheckBox menuFinanceiro;
    private javax.swing.JCheckBox subMenuBiblioteca;
    private javax.swing.JCheckBox subMenuContasPagar;
    private javax.swing.JCheckBox subMenuEmprestimosLivros;
    private javax.swing.JCheckBox subMenuEntidades;
    private javax.swing.JCheckBox subMenuOperacaoCaixa;
    private javax.swing.JCheckBox subMenuOperacaoDizimoOferta;
    private javax.swing.JCheckBox subMenuPlanoContas;
    private javax.swing.JCheckBox subMenuProcessosAvulsos;
    // End of variables declaration//GEN-END:variables
}
