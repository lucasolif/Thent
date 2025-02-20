package view;

import Ferramentas.AgendadorTarefas;
import Ferramentas.PaletaCores;
import dao.UsuarioDao;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import jdbc.Conexao;
import model.Acessos;
import model.FuncoesUsuario;
import model.Login;
import model.Usuario;
import model.UsuarioLogado;
import view.biblioteca.AdicionarLivroForm;
import view.biblioteca.AutorForm;
import view.biblioteca.AcervoBibliotecaForm;
import view.biblioteca.CadastroBibliotecaForm;
import view.biblioteca.ConsultaEmprestimoForm;
import view.biblioteca.EditoraForm;
import view.biblioteca.EmprestimoLivroForm;
import view.biblioteca.CadastroLivrosForm;
import view.biblioteca.SaidaAvulsaLivroForm;
import view.cadastros.ContaCaixaForm;
import view.cadastros.ContaResultadoForm;
import view.cadastros.FormaPagtoForm;
import view.cadastros.IgrejaForm;
import view.cadastros.PessoasForm;
import view.cadastros.SubContaResultadoForm;
import view.cadastros.TipoOfertaForm;
import view.cadastros.UsuarioForm;
import view.campanhas.CadastrarCampanhaForm;
import view.campanhas.CadastrarParticipanteAvulsoForm;
import view.campanhas.ConsultarCampanhasForm;
import view.campanhas.GerarContasReceberAvulsaForm;
import view.campanhas.GerenciarContasReceberForm;
import view.campanhas.RemoverParticipanteForm;
import view.configuracoes.AcessosUsuarioForm;
import view.configuracoes.AlterarSenhaForm;
import view.contasPagar.CancelarContasPagarForm;
import view.contasPagar.ContasPagarForm;
import view.contasPagar.EfetivarContasPagarForm;
import view.dizimosOfertas.ConsultaRegistroDizimoOferta;
import view.financeiro.MovimentoFinanceiroForm;
import view.dizimosOfertas.RegistroDizimoOfertaForm;
import view.financeiro.AplicacaoFinanceiraForm;
import view.financeiro.RetiradaValorAplicacaoForm;
import view.financeiro.TransferenciaContaForm;
import view.relatorios.ExtratoCaixa;
import view.relatorios.RelatorioContasPagarForm;
import view.relatorios.RelatorioMovimentoDizimoOferta;
import view.relatorios.RelatorioPrestacaoContaMensal;


public class Home extends javax.swing.JFrame {
    
    UsuarioLogado userLogado = new UsuarioLogado();
    UsuarioDao usuarioDao = new UsuarioDao();
    PaletaCores cores = new PaletaCores();
    
    public Home(Login usuarioLogado) {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
       
        //seta o codigo e nome do usuário para o objeto UsuerioLogado, que será utilizado nos processos do sistema
        userLogado.setCodUsuario(usuarioLogado.getCodUsuario());
        userLogado.setNomeUsuario(usuarioLogado.getUsuario());
        
        //Executar tarefas automaticamente
        AgendadorTarefas exeTaregas = new AgendadorTarefas();
        exeTaregas.executarTarefasDiarias();
        
        //Nomea os menus
        nomearMenus();
        
        //Verifica e libera os acesso conforme o tipo
        verificarTipoAcesso();
        
        //Definindo a imagem do fundo da tela inicial
        fundoTelaInicial();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelHome = new javax.swing.JDesktopPane();
        menuBarra = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        formCadastroPessoas = new javax.swing.JMenuItem();
        formCadastroIgreja = new javax.swing.JMenuItem();
        formCadastroUsuario = new javax.swing.JMenuItem();
        subMenuCadastroEntidades = new javax.swing.JMenu();
        formCadastroFormaPagto = new javax.swing.JMenuItem();
        formCadastroContaCaixa = new javax.swing.JMenuItem();
        formCadastroTipoOferta = new javax.swing.JMenuItem();
        subMenuCadastroPlanoContas = new javax.swing.JMenu();
        formCadastroContaResultado = new javax.swing.JMenuItem();
        formCadastroSubContaResultado = new javax.swing.JMenuItem();
        menuFinanceiro = new javax.swing.JMenu();
        subMenuFinanceiroDizimoOfertas = new javax.swing.JMenu();
        formRegistrarOfertasDizimo = new javax.swing.JMenuItem();
        formConsultarDizimoOfertas = new javax.swing.JMenuItem();
        subMenuFinanceiroContasPagar = new javax.swing.JMenu();
        formLancarContasPagar = new javax.swing.JMenuItem();
        formEfetivarContasPagar = new javax.swing.JMenuItem();
        formCancelarContasPagar = new javax.swing.JMenuItem();
        formAlterarContasPagar = new javax.swing.JMenuItem();
        subMenuFinanceiroCaixa = new javax.swing.JMenu();
        formTransferenciasBancarias = new javax.swing.JMenuItem();
        formMovimentoFinanceiro = new javax.swing.JMenuItem();
        formAplicacaoFinanceira = new javax.swing.JMenuItem();
        formRetiradaAplicacao = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        subMenuRelatorioFinanceiro = new javax.swing.JMenu();
        formRelatorioExtratoCaixa = new javax.swing.JMenuItem();
        formRelatorioContasPagar = new javax.swing.JMenuItem();
        formRelatorioContasReceber = new javax.swing.JMenuItem();
        subMenuRelatorioDizimoOferta = new javax.swing.JMenu();
        formRelatorioMovimentoDizimoOferta = new javax.swing.JMenuItem();
        subMenuRelatorioPrestacaoConta = new javax.swing.JMenu();
        formRelatorioPrestacaoContaMensal = new javax.swing.JMenuItem();
        menuBiblioteca = new javax.swing.JMenu();
        subMenuCadastros = new javax.swing.JMenu();
        formCadastroLivros = new javax.swing.JMenuItem();
        formCadastroAutor = new javax.swing.JMenuItem();
        formCadastroEditora = new javax.swing.JMenuItem();
        formCadastroBibliotecas = new javax.swing.JMenuItem();
        subMenuOpercaoBiblioteca = new javax.swing.JMenu();
        formConsultarAcervoBiblioteca = new javax.swing.JMenuItem();
        formAdicionarLivroBiblioteca = new javax.swing.JMenuItem();
        formSaidaAvulsaLivro = new javax.swing.JMenuItem();
        subMenuEmprestimoLivros = new javax.swing.JMenu();
        formEmprestimoLivros = new javax.swing.JMenuItem();
        formGerenciarConsultarEmprestimo = new javax.swing.JMenuItem();
        menuCampanha = new javax.swing.JMenu();
        formCriarCampanha = new javax.swing.JMenuItem();
        formGerenciarContaReceberCampanha = new javax.swing.JMenuItem();
        subMenuProcessosAvulsosCampanha = new javax.swing.JMenu();
        formAdicionarParticipante = new javax.swing.JMenuItem();
        formRemoverParticipante = new javax.swing.JMenuItem();
        formLancarContasReceberCampanha = new javax.swing.JMenuItem();
        formConsultarCampanhas = new javax.swing.JMenuItem();
        menuConfiguracoes = new javax.swing.JMenu();
        subMenuUsuario = new javax.swing.JMenu();
        formAcessosUsuarios = new javax.swing.JMenuItem();
        menuAlterarSenha = new javax.swing.JMenu();
        formAlterarSenha = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName("Home"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painelHome.setBackground(new java.awt.Color(204, 204, 204));
        painelHome.setAutoscrolls(true);

        javax.swing.GroupLayout painelHomeLayout = new javax.swing.GroupLayout(painelHome);
        painelHome.setLayout(painelHomeLayout);
        painelHomeLayout.setHorizontalGroup(
            painelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );
        painelHomeLayout.setVerticalGroup(
            painelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        menuBarra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuBarra.setName(""); // NOI18N

        menuCadastros.setText("Cadastros");

        formCadastroPessoas.setText("Membros/Pessoa");
        formCadastroPessoas.setName(""); // NOI18N
        formCadastroPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroPessoasActionPerformed(evt);
            }
        });
        menuCadastros.add(formCadastroPessoas);

        formCadastroIgreja.setText("Campo/Igreja");
        formCadastroIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroIgrejaActionPerformed(evt);
            }
        });
        menuCadastros.add(formCadastroIgreja);

        formCadastroUsuario.setText("Usuários");
        formCadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroUsuarioActionPerformed(evt);
            }
        });
        menuCadastros.add(formCadastroUsuario);

        subMenuCadastroEntidades.setText("Entidades");

        formCadastroFormaPagto.setText("Forma de Pagamento");
        formCadastroFormaPagto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroFormaPagtoActionPerformed(evt);
            }
        });
        subMenuCadastroEntidades.add(formCadastroFormaPagto);

        formCadastroContaCaixa.setText("Conta Caixa");
        formCadastroContaCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroContaCaixaActionPerformed(evt);
            }
        });
        subMenuCadastroEntidades.add(formCadastroContaCaixa);

        formCadastroTipoOferta.setText("Tipo De Oferta");
        formCadastroTipoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroTipoOfertaActionPerformed(evt);
            }
        });
        subMenuCadastroEntidades.add(formCadastroTipoOferta);

        subMenuCadastroPlanoContas.setText("Plano de Contas");

        formCadastroContaResultado.setText("Conta de Resultado");
        formCadastroContaResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroContaResultadoActionPerformed(evt);
            }
        });
        subMenuCadastroPlanoContas.add(formCadastroContaResultado);

        formCadastroSubContaResultado.setText("SubConta de Resultado");
        formCadastroSubContaResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroSubContaResultadoActionPerformed(evt);
            }
        });
        subMenuCadastroPlanoContas.add(formCadastroSubContaResultado);

        subMenuCadastroEntidades.add(subMenuCadastroPlanoContas);

        menuCadastros.add(subMenuCadastroEntidades);

        menuBarra.add(menuCadastros);

        menuFinanceiro.setText("Financeiro");
        menuFinanceiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuFinanceiro.setName(""); // NOI18N

        subMenuFinanceiroDizimoOfertas.setText("Operações Dízimo/Ofertas");

        formRegistrarOfertasDizimo.setText("Registrar Dizimo/Ofertas");
        formRegistrarOfertasDizimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formRegistrarOfertasDizimoActionPerformed(evt);
            }
        });
        subMenuFinanceiroDizimoOfertas.add(formRegistrarOfertasDizimo);

        formConsultarDizimoOfertas.setText("Consulta de Dizimo/Oferta");
        formConsultarDizimoOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formConsultarDizimoOfertasActionPerformed(evt);
            }
        });
        subMenuFinanceiroDizimoOfertas.add(formConsultarDizimoOfertas);

        menuFinanceiro.add(subMenuFinanceiroDizimoOfertas);

        subMenuFinanceiroContasPagar.setText("Contas a Pagar");

        formLancarContasPagar.setText("Lançar Contas a Pagar");
        formLancarContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formLancarContasPagarActionPerformed(evt);
            }
        });
        subMenuFinanceiroContasPagar.add(formLancarContasPagar);

        formEfetivarContasPagar.setText("Efetivar/Consultar Contas a Pagar");
        formEfetivarContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formEfetivarContasPagarActionPerformed(evt);
            }
        });
        subMenuFinanceiroContasPagar.add(formEfetivarContasPagar);

        formCancelarContasPagar.setText("Cancelar Contas a Pagar");
        formCancelarContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCancelarContasPagarActionPerformed(evt);
            }
        });
        subMenuFinanceiroContasPagar.add(formCancelarContasPagar);

        formAlterarContasPagar.setText("Alterar Contas a Pagar");
        subMenuFinanceiroContasPagar.add(formAlterarContasPagar);

        menuFinanceiro.add(subMenuFinanceiroContasPagar);

        subMenuFinanceiroCaixa.setText("Operações Caixa");

        formTransferenciasBancarias.setText("Transferências Bancárias");
        formTransferenciasBancarias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formTransferenciasBancariasActionPerformed(evt);
            }
        });
        subMenuFinanceiroCaixa.add(formTransferenciasBancarias);

        formMovimentoFinanceiro.setText("Movimento Financeiro");
        formMovimentoFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formMovimentoFinanceiroActionPerformed(evt);
            }
        });
        subMenuFinanceiroCaixa.add(formMovimentoFinanceiro);

        formAplicacaoFinanceira.setText("Realizar Aplicação");
        formAplicacaoFinanceira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formAplicacaoFinanceiraActionPerformed(evt);
            }
        });
        subMenuFinanceiroCaixa.add(formAplicacaoFinanceira);

        formRetiradaAplicacao.setText("Retirada Aplicação");
        formRetiradaAplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formRetiradaAplicacaoActionPerformed(evt);
            }
        });
        subMenuFinanceiroCaixa.add(formRetiradaAplicacao);

        menuFinanceiro.add(subMenuFinanceiroCaixa);

        menuBarra.add(menuFinanceiro);

        menuRelatorios.setText("Relatórios");

        subMenuRelatorioFinanceiro.setText("Financeiro");

        formRelatorioExtratoCaixa.setText("Extrato Caixa");
        formRelatorioExtratoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formRelatorioExtratoCaixaActionPerformed(evt);
            }
        });
        subMenuRelatorioFinanceiro.add(formRelatorioExtratoCaixa);

        formRelatorioContasPagar.setText("Contas a Pagar");
        formRelatorioContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formRelatorioContasPagarActionPerformed(evt);
            }
        });
        subMenuRelatorioFinanceiro.add(formRelatorioContasPagar);

        formRelatorioContasReceber.setText("Contas a Receber");
        subMenuRelatorioFinanceiro.add(formRelatorioContasReceber);

        menuRelatorios.add(subMenuRelatorioFinanceiro);

        subMenuRelatorioDizimoOferta.setText("Dizimo/Oferta");

        formRelatorioMovimentoDizimoOferta.setText("Movimento Dizimo/Oferta");
        formRelatorioMovimentoDizimoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formRelatorioMovimentoDizimoOfertaActionPerformed(evt);
            }
        });
        subMenuRelatorioDizimoOferta.add(formRelatorioMovimentoDizimoOferta);

        menuRelatorios.add(subMenuRelatorioDizimoOferta);

        subMenuRelatorioPrestacaoConta.setText("Prestação de Contas");

        formRelatorioPrestacaoContaMensal.setText("Prestação Conta Mensal");
        formRelatorioPrestacaoContaMensal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formRelatorioPrestacaoContaMensalActionPerformed(evt);
            }
        });
        subMenuRelatorioPrestacaoConta.add(formRelatorioPrestacaoContaMensal);

        menuRelatorios.add(subMenuRelatorioPrestacaoConta);

        menuBarra.add(menuRelatorios);

        menuBiblioteca.setText("Biblioteca");

        subMenuCadastros.setText("Cadastros");

        formCadastroLivros.setText("Livros");
        formCadastroLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroLivrosActionPerformed(evt);
            }
        });
        subMenuCadastros.add(formCadastroLivros);

        formCadastroAutor.setText("Autor(a)");
        formCadastroAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroAutorActionPerformed(evt);
            }
        });
        subMenuCadastros.add(formCadastroAutor);

        formCadastroEditora.setText("Editora/Publicadora");
        formCadastroEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroEditoraActionPerformed(evt);
            }
        });
        subMenuCadastros.add(formCadastroEditora);

        formCadastroBibliotecas.setText("Biblioteca");
        formCadastroBibliotecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCadastroBibliotecasActionPerformed(evt);
            }
        });
        subMenuCadastros.add(formCadastroBibliotecas);

        menuBiblioteca.add(subMenuCadastros);

        subMenuOpercaoBiblioteca.setText("Operações Biblioteca");

        formConsultarAcervoBiblioteca.setText("Consultar Acervo Biblioteca");
        formConsultarAcervoBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formConsultarAcervoBibliotecaActionPerformed(evt);
            }
        });
        subMenuOpercaoBiblioteca.add(formConsultarAcervoBiblioteca);

        formAdicionarLivroBiblioteca.setText("Adicionar Livro Biblioteca");
        formAdicionarLivroBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formAdicionarLivroBibliotecaActionPerformed(evt);
            }
        });
        subMenuOpercaoBiblioteca.add(formAdicionarLivroBiblioteca);

        formSaidaAvulsaLivro.setText("Saída Avulsa de Livros");
        formSaidaAvulsaLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formSaidaAvulsaLivroActionPerformed(evt);
            }
        });
        subMenuOpercaoBiblioteca.add(formSaidaAvulsaLivro);

        menuBiblioteca.add(subMenuOpercaoBiblioteca);

        subMenuEmprestimoLivros.setText("Empréstimo Livros");

        formEmprestimoLivros.setText("Empréstimo Livros");
        formEmprestimoLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formEmprestimoLivrosActionPerformed(evt);
            }
        });
        subMenuEmprestimoLivros.add(formEmprestimoLivros);

        formGerenciarConsultarEmprestimo.setText("Gerenciar/Consultar Empréstimo");
        formGerenciarConsultarEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formGerenciarConsultarEmprestimoActionPerformed(evt);
            }
        });
        subMenuEmprestimoLivros.add(formGerenciarConsultarEmprestimo);

        menuBiblioteca.add(subMenuEmprestimoLivros);

        menuBarra.add(menuBiblioteca);

        menuCampanha.setText("Campanha");

        formCriarCampanha.setText("Criar Campanha");
        formCriarCampanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formCriarCampanhaActionPerformed(evt);
            }
        });
        menuCampanha.add(formCriarCampanha);

        formGerenciarContaReceberCampanha.setText("Gerenciar Contas Receber");
        formGerenciarContaReceberCampanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formGerenciarContaReceberCampanhaActionPerformed(evt);
            }
        });
        menuCampanha.add(formGerenciarContaReceberCampanha);

        subMenuProcessosAvulsosCampanha.setText("Processos Avulsos");

        formAdicionarParticipante.setText("Adicionar Participante");
        formAdicionarParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formAdicionarParticipanteActionPerformed(evt);
            }
        });
        subMenuProcessosAvulsosCampanha.add(formAdicionarParticipante);

        formRemoverParticipante.setText("Remover Participante");
        formRemoverParticipante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formRemoverParticipanteActionPerformed(evt);
            }
        });
        subMenuProcessosAvulsosCampanha.add(formRemoverParticipante);

        formLancarContasReceberCampanha.setText("Lançar Contas Receber ");
        formLancarContasReceberCampanha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formLancarContasReceberCampanhaActionPerformed(evt);
            }
        });
        subMenuProcessosAvulsosCampanha.add(formLancarContasReceberCampanha);

        menuCampanha.add(subMenuProcessosAvulsosCampanha);

        formConsultarCampanhas.setText("Consultar Campanhas");
        formConsultarCampanhas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formConsultarCampanhasActionPerformed(evt);
            }
        });
        menuCampanha.add(formConsultarCampanhas);

        menuBarra.add(menuCampanha);

        menuConfiguracoes.setText("Configurações");

        subMenuUsuario.setText("Usuário");

        formAcessosUsuarios.setText("Acessos Usuário");
        formAcessosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formAcessosUsuariosActionPerformed(evt);
            }
        });
        subMenuUsuario.add(formAcessosUsuarios);

        menuConfiguracoes.add(subMenuUsuario);

        menuBarra.add(menuConfiguracoes);

        menuAlterarSenha.setText("Alterar Senha");

        formAlterarSenha.setText("Alterar Senha");
        formAlterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formAlterarSenhaActionPerformed(evt);
            }
        });
        menuAlterarSenha.add(formAlterarSenha);

        menuBarra.add(menuAlterarSenha);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelHome)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelHome)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formCadastroPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroPessoasActionPerformed
        PessoasForm cadastroPessoas = new PessoasForm(this.userLogado);
        this.painelHome.add(cadastroPessoas);
        cadastroPessoas.setVisible(true);
        cadastroPessoas.setPosicao();
    }//GEN-LAST:event_formCadastroPessoasActionPerformed

    private void formCadastroIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroIgrejaActionPerformed
        IgrejaForm cadastroIgreja = new IgrejaForm(this.userLogado);
        this.painelHome.add(cadastroIgreja);
        cadastroIgreja.setVisible(true);
        cadastroIgreja.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_formCadastroIgrejaActionPerformed

    private void formCadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroUsuarioActionPerformed
        UsuarioForm cadastroUsuario = new UsuarioForm(this.userLogado);
        this.painelHome.add(cadastroUsuario);
        cadastroUsuario.setVisible(true);
        cadastroUsuario.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_formCadastroUsuarioActionPerformed

    private void formCadastroFormaPagtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroFormaPagtoActionPerformed
        FormaPagtoForm cadastroFormaPagto = new FormaPagtoForm(this.userLogado);
        this.painelHome.add(cadastroFormaPagto);
        cadastroFormaPagto.setVisible(true);
        cadastroFormaPagto.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_formCadastroFormaPagtoActionPerformed

    private void formCadastroContaCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroContaCaixaActionPerformed
        ContaCaixaForm cadastroContaCaixa = new ContaCaixaForm(this.userLogado);
        this.painelHome.add(cadastroContaCaixa);
        cadastroContaCaixa.setVisible(true);
        cadastroContaCaixa.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_formCadastroContaCaixaActionPerformed

    private void formCadastroTipoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroTipoOfertaActionPerformed
        TipoOfertaForm cadastroTipoOferta = new TipoOfertaForm(this.userLogado);
        this.painelHome.add(cadastroTipoOferta);
        cadastroTipoOferta.setVisible(true);
        cadastroTipoOferta.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_formCadastroTipoOfertaActionPerformed

    private void formLancarContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formLancarContasPagarActionPerformed
        ContasPagarForm contasPagar = new ContasPagarForm(this.userLogado);
        this.painelHome.add(contasPagar);
        contasPagar.setVisible(true);
        contasPagar.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_formLancarContasPagarActionPerformed

    private void formEfetivarContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formEfetivarContasPagarActionPerformed
        EfetivarContasPagarForm efetivarContas = new EfetivarContasPagarForm(this.userLogado);
        this.painelHome.add(efetivarContas);
        efetivarContas.setVisible(true);
        efetivarContas.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_formEfetivarContasPagarActionPerformed

    private void formRegistrarOfertasDizimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formRegistrarOfertasDizimoActionPerformed
        RegistroDizimoOfertaForm rgDizimoOferta = new RegistroDizimoOfertaForm(this.userLogado);
        this.painelHome.add(rgDizimoOferta);
        rgDizimoOferta.setVisible(true);
        rgDizimoOferta.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_formRegistrarOfertasDizimoActionPerformed

    private void formTransferenciasBancariasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formTransferenciasBancariasActionPerformed
        TransferenciaContaForm trasnfConta = new TransferenciaContaForm(this.userLogado);
        this.painelHome.add(trasnfConta);
        trasnfConta.setVisible(true);
        trasnfConta.setPosicao();
    }//GEN-LAST:event_formTransferenciasBancariasActionPerformed

    private void formAlterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formAlterarSenhaActionPerformed
        AlterarSenhaForm alterarSenha = new AlterarSenhaForm(this.userLogado);
        this.painelHome.add(alterarSenha);
        alterarSenha.setVisible(true);
        alterarSenha.setPosicao();

    }//GEN-LAST:event_formAlterarSenhaActionPerformed

    private void formCadastroContaResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroContaResultadoActionPerformed
        ContaResultadoForm contaResultado = new ContaResultadoForm(this.userLogado);
        this.painelHome.add(contaResultado);
        contaResultado.setVisible(true);
        contaResultado.setPosicao();
    }//GEN-LAST:event_formCadastroContaResultadoActionPerformed

    private void formConsultarDizimoOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formConsultarDizimoOfertasActionPerformed
        ConsultaRegistroDizimoOferta efetivacao = new ConsultaRegistroDizimoOferta(this.userLogado);
        this.painelHome.add(efetivacao);
        efetivacao.setVisible(true);
        efetivacao.setPosicao();
    }//GEN-LAST:event_formConsultarDizimoOfertasActionPerformed

    private void formMovimentoFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formMovimentoFinanceiroActionPerformed
        MovimentoFinanceiroForm movimentoFinanceiro = new MovimentoFinanceiroForm(userLogado);
        this.painelHome.add(movimentoFinanceiro);
        movimentoFinanceiro.setVisible(true);
        movimentoFinanceiro.setPosicao();
    }//GEN-LAST:event_formMovimentoFinanceiroActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Conexao conexao = new Conexao();
        conexao.closeDataSource();
    }//GEN-LAST:event_formWindowClosed

    private void formCancelarContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCancelarContasPagarActionPerformed
        CancelarContasPagarForm cancelarCp = new CancelarContasPagarForm(this.userLogado);
        this.painelHome.add(cancelarCp);
        cancelarCp.setVisible(true);
        cancelarCp.setPosicao();
    }//GEN-LAST:event_formCancelarContasPagarActionPerformed

    private void formCadastroLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroLivrosActionPerformed
        CadastroLivrosForm cadastrarLivros = new CadastroLivrosForm(this.userLogado);
        this.painelHome.add(cadastrarLivros);
        cadastrarLivros.setVisible(true);
        cadastrarLivros.setPosicao();
    }//GEN-LAST:event_formCadastroLivrosActionPerformed

    private void formConsultarAcervoBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formConsultarAcervoBibliotecaActionPerformed
        AcervoBibliotecaForm biblioteca = new AcervoBibliotecaForm(this.userLogado);
        this.painelHome.add(biblioteca);
        biblioteca.setVisible(true);
        biblioteca.setPosicao();
    }//GEN-LAST:event_formConsultarAcervoBibliotecaActionPerformed

    private void formEmprestimoLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formEmprestimoLivrosActionPerformed
        EmprestimoLivroForm emprestimo = new EmprestimoLivroForm(this.userLogado);
        this.painelHome.add(emprestimo);
        emprestimo.setVisible(true);
        emprestimo.setPosicao();
    }//GEN-LAST:event_formEmprestimoLivrosActionPerformed

    private void formGerenciarConsultarEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formGerenciarConsultarEmprestimoActionPerformed
        ConsultaEmprestimoForm consultaEmprestimo = new ConsultaEmprestimoForm(this.userLogado);
        this.painelHome.add(consultaEmprestimo);
        consultaEmprestimo.setVisible(true);
        consultaEmprestimo.setPosicao();
    }//GEN-LAST:event_formGerenciarConsultarEmprestimoActionPerformed

    private void formCadastroSubContaResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroSubContaResultadoActionPerformed
        SubContaResultadoForm subContaResult = new SubContaResultadoForm(this.userLogado);
        this.painelHome.add(subContaResult);
        subContaResult.setVisible(true);
        subContaResult.setPosicao();
    }//GEN-LAST:event_formCadastroSubContaResultadoActionPerformed

    private void formCadastroAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroAutorActionPerformed
        AutorForm dialogAutor = new AutorForm(this, true);
        dialogAutor.setLocationRelativeTo(this);
        dialogAutor.setVisible(true);
    }//GEN-LAST:event_formCadastroAutorActionPerformed

    private void formCadastroEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroEditoraActionPerformed
        EditoraForm dialogEditora = new EditoraForm(this, true);
        dialogEditora.setLocationRelativeTo(this);
        dialogEditora.setVisible(true);
    }//GEN-LAST:event_formCadastroEditoraActionPerformed

    private void formAdicionarLivroBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formAdicionarLivroBibliotecaActionPerformed
        AdicionarLivroForm dialogAddLivroBibli = new AdicionarLivroForm(this, true);
        dialogAddLivroBibli.setLocationRelativeTo(this);
        dialogAddLivroBibli.setVisible(true);
    }//GEN-LAST:event_formAdicionarLivroBibliotecaActionPerformed

    private void formSaidaAvulsaLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formSaidaAvulsaLivroActionPerformed
        SaidaAvulsaLivroForm saidaAvulsaLivro = new SaidaAvulsaLivroForm(this.userLogado);
        this.painelHome.add(saidaAvulsaLivro);
        saidaAvulsaLivro.setVisible(true);
        saidaAvulsaLivro.setPosicao();
    }//GEN-LAST:event_formSaidaAvulsaLivroActionPerformed

    private void formCadastroBibliotecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCadastroBibliotecasActionPerformed
        CadastroBibliotecaForm cadastroBiblioteca = new CadastroBibliotecaForm(this.userLogado);
        this.painelHome.add(cadastroBiblioteca);
        cadastroBiblioteca.setVisible(true);
        cadastroBiblioteca.setPosicao();
    }//GEN-LAST:event_formCadastroBibliotecasActionPerformed

    private void formCriarCampanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formCriarCampanhaActionPerformed
        CadastrarCampanhaForm cadastrarCampanha = new CadastrarCampanhaForm(this.userLogado);
        this.painelHome.add(cadastrarCampanha);
        cadastrarCampanha.setVisible(true);
        cadastrarCampanha.setPosicao();
    }//GEN-LAST:event_formCriarCampanhaActionPerformed

    private void formAdicionarParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formAdicionarParticipanteActionPerformed
        CadastrarParticipanteAvulsoForm cadastrarParticipanteAvulso = new CadastrarParticipanteAvulsoForm(this.userLogado);
        this.painelHome.add(cadastrarParticipanteAvulso);
        cadastrarParticipanteAvulso.setVisible(true);
        cadastrarParticipanteAvulso.setPosicao();
    }//GEN-LAST:event_formAdicionarParticipanteActionPerformed

    private void formLancarContasReceberCampanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formLancarContasReceberCampanhaActionPerformed
        GerarContasReceberAvulsaForm gerarCrAvulsa = new GerarContasReceberAvulsaForm(this.userLogado);
        this.painelHome.add(gerarCrAvulsa);
        gerarCrAvulsa.setVisible(true);
        gerarCrAvulsa.setPosicao();
    }//GEN-LAST:event_formLancarContasReceberCampanhaActionPerformed

    private void formRemoverParticipanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formRemoverParticipanteActionPerformed
        RemoverParticipanteForm removerParticipante = new RemoverParticipanteForm(this.userLogado);
        this.painelHome.add(removerParticipante);
        removerParticipante.setVisible(true);
        removerParticipante.setPosicao();
    }//GEN-LAST:event_formRemoverParticipanteActionPerformed

    private void formConsultarCampanhasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formConsultarCampanhasActionPerformed
        ConsultarCampanhasForm consultarCampanhas = new ConsultarCampanhasForm(this.userLogado);
        this.painelHome.add(consultarCampanhas);
        consultarCampanhas.setVisible(true);
        consultarCampanhas.setPosicao();
    }//GEN-LAST:event_formConsultarCampanhasActionPerformed

    private void formGerenciarContaReceberCampanhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formGerenciarContaReceberCampanhaActionPerformed
        GerenciarContasReceberForm gerenciarContasReceber = new GerenciarContasReceberForm(this.userLogado);
        this.painelHome.add(gerenciarContasReceber);
        gerenciarContasReceber.setVisible(true);
        gerenciarContasReceber.setPosicao();
    }//GEN-LAST:event_formGerenciarContaReceberCampanhaActionPerformed

    private void formRelatorioContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formRelatorioContasPagarActionPerformed
        RelatorioContasPagarForm relatorioContasPagar = new RelatorioContasPagarForm(this.userLogado);
        this.painelHome.add(relatorioContasPagar);
        relatorioContasPagar.setVisible(true);
        relatorioContasPagar.setPosicao();
    }//GEN-LAST:event_formRelatorioContasPagarActionPerformed

    private void formRelatorioExtratoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formRelatorioExtratoCaixaActionPerformed
        ExtratoCaixa extratoCaixa = new ExtratoCaixa(this.userLogado);
        this.painelHome.add(extratoCaixa);
        extratoCaixa.setVisible(true);
        extratoCaixa.setPosicao();
    }//GEN-LAST:event_formRelatorioExtratoCaixaActionPerformed

    private void formRelatorioMovimentoDizimoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formRelatorioMovimentoDizimoOfertaActionPerformed
        RelatorioMovimentoDizimoOferta movimentoDizimoOferta = new RelatorioMovimentoDizimoOferta(this.userLogado);
        this.painelHome.add(movimentoDizimoOferta);
        movimentoDizimoOferta.setVisible(true);
        movimentoDizimoOferta.setPosicao();
    }//GEN-LAST:event_formRelatorioMovimentoDizimoOfertaActionPerformed

    private void formRelatorioPrestacaoContaMensalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formRelatorioPrestacaoContaMensalActionPerformed
        RelatorioPrestacaoContaMensal prestacaoMensal = new RelatorioPrestacaoContaMensal(this.userLogado);
        this.painelHome.add(prestacaoMensal);
        prestacaoMensal.setVisible(true);
        prestacaoMensal.setPosicao();
    }//GEN-LAST:event_formRelatorioPrestacaoContaMensalActionPerformed

    private void formAcessosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formAcessosUsuariosActionPerformed
        AcessosUsuarioForm acessos = new AcessosUsuarioForm();
        this.painelHome.add(acessos);
        acessos.setVisible(true);
        acessos.setPosicao();
    }//GEN-LAST:event_formAcessosUsuariosActionPerformed

    private void formAplicacaoFinanceiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formAplicacaoFinanceiraActionPerformed
        AplicacaoFinanceiraForm aplicaFinanceira = new AplicacaoFinanceiraForm(this.userLogado);
        this.painelHome.add(aplicaFinanceira);
        aplicaFinanceira.setVisible(true);
        aplicaFinanceira.setPosicao();
    }//GEN-LAST:event_formAplicacaoFinanceiraActionPerformed

    private void formRetiradaAplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formRetiradaAplicacaoActionPerformed
        RetiradaValorAplicacaoForm retirada = new RetiradaValorAplicacaoForm();
        this.painelHome.add(retirada);
        retirada.setVisible(true);
        retirada.setPosicao();
    }//GEN-LAST:event_formRetiradaAplicacaoActionPerformed
  
    private void nomearMenus(){
        
        this.painelHome.setName("0");
        
        this.menuCadastros.setName("1");
        this.formCadastroPessoas.setName("2");
        this.formCadastroIgreja.setName("3");
        this.formCadastroUsuario.setName("4");
        this.subMenuCadastroEntidades.setName("5");
        this.formCadastroFormaPagto.setName("6");
        this.formCadastroContaCaixa.setName("7");
        this.formCadastroTipoOferta.setName("8");
        this.subMenuCadastroPlanoContas.setName("9");
        this.formCadastroContaResultado.setName("10");
        this.formCadastroSubContaResultado.setName("11");
        
        this.menuFinanceiro.setName("12");
        this.subMenuFinanceiroDizimoOfertas.setName("13");
        this.formRegistrarOfertasDizimo.setName("14");
        this.formConsultarDizimoOfertas.setName("15");
        this.subMenuFinanceiroContasPagar.setName("16");
        this.formLancarContasPagar.setName("17");
        this.formEfetivarContasPagar.setName("18");
        this.formCancelarContasPagar.setName("19");
        this.formAlterarContasPagar.setName("20");
        
        this.subMenuFinanceiroCaixa.setName("21");
        this.formTransferenciasBancarias.setName("22");
        this.formMovimentoFinanceiro.setName("23");
        this.formAplicacaoFinanceira.setName("24");
        this.formRetiradaAplicacao.setName("25");
        
        this.menuRelatorios.setName("26");
        this.subMenuRelatorioFinanceiro.setName("27");
        this.formRelatorioExtratoCaixa.setName("28");
        this.formRelatorioContasPagar.setName("29");
        this.formRelatorioContasReceber.setName("30");
        this.subMenuRelatorioDizimoOferta.setName("31");
        this.formRelatorioMovimentoDizimoOferta.setName("32");
        this.subMenuRelatorioPrestacaoConta.setName("33");
        this.formRelatorioPrestacaoContaMensal.setName("34");
        
        this.menuBiblioteca.setName("35");
        this.subMenuCadastros.setName("36");
        this.formCadastroLivros.setName("37");
        this.formCadastroAutor.setName("38");
        this.formCadastroEditora.setName("39");
        this.formCadastroBibliotecas.setName("40");
        this.subMenuOpercaoBiblioteca.setName("41");
        this.formConsultarAcervoBiblioteca.setName("42");
        this.formAdicionarLivroBiblioteca.setName("43");
        this.formSaidaAvulsaLivro.setName("44");
        this.subMenuEmprestimoLivros.setName("45");
        this.formEmprestimoLivros.setName("46");
        this.formGerenciarConsultarEmprestimo.setName("47");
        
        this.menuCampanha.setName("48");
        this.formCriarCampanha.setName("49");
        this.formGerenciarContaReceberCampanha.setName("50");
        this.subMenuProcessosAvulsosCampanha.setName("51");
        this.formAdicionarParticipante.setName("52");
        this.formRemoverParticipante.setName("53");
        this.formLancarContasReceberCampanha.setName("54");
        this.formConsultarCampanhas.setName("55");
        
        this.menuConfiguracoes.setName("56");
        this.subMenuUsuario.setName("57");
        this.formAcessosUsuarios.setName("58");
        this.menuAlterarSenha.setName("59");
        this.formAlterarSenha.setName("60");
        
    }
    
    private void verificarTipoAcesso(){
        
        FuncoesUsuario funcaoUsuario = usuarioDao.consultarFuncaoUsuario(this.userLogado);
        
        if(funcaoUsuario.getCodigo() == 1){
            acessosPersonalizado();
            
        }else{
            acessosPadrao();
        }
    }
    
    private void acessosPadrao(){
        List<Acessos> listaAcesso = usuarioDao.consultarAcessosPadrao(this.userLogado);
        boolean acessoMenu = true;
        
        for(Acessos aces : listaAcesso){
            for (int i = 0; i < menuBarra.getMenuCount(); i++) {
                JMenu menu = menuBarra.getMenu(i);
                Integer codMenu = Integer.valueOf(menu.getName());

                //Verifica se o número do Menu é igual ao número que consta no banco de dados, verificando se tem acesso
                if(codMenu == aces.getMenuId() && aces.getPodeAcesasr() == 0){
                    menu.setEnabled(false);
                    acessoMenu = false;
                }

                //Se tiver acesso ao menu, ele verifica os submenus
                if(acessoMenu){
                    // Iterar sobre os itens de menu dentro de cada JMenu
                    for (int j = 0; j < menu.getItemCount(); j++) {
                        JMenuItem subMenu = menu.getItem(j);
                        Integer codSubMenu = Integer.valueOf(subMenu.getName());
                        if(codSubMenu != 0 && codSubMenu == aces.getMenuId() && aces.getPodeAcesasr() == 0){
                            subMenu.setEnabled(false);  
                        }                                       
                    }
                }
            }       
        }
    }
    
    private void acessosPersonalizado(){
        Usuario usuario = new Usuario();
        usuario.setCodigo(this.userLogado.getCodUsuario()); 
        List<Acessos> listAcesPerson = usuarioDao.consultarAcessosPersonalizados(usuario);
        boolean acessoMenu = true;
        
        System.out.println();
        
        if(!listAcesPerson.isEmpty()){
            
            for(Acessos aces : listAcesPerson){
                for (int i = 0; i < menuBarra.getMenuCount(); i++) {
                    JMenu menu = menuBarra.getMenu(i);
                    Integer codMenu = Integer.valueOf(menu.getName());

                    //Verifica se o número do Menu é igual ao número que consta no banco de dados, verificando se tem acesso
                    if(codMenu == aces.getMenuId() && aces.getPodeAcesasr() == 0){
                        menu.setEnabled(false);
                        acessoMenu = false;
                    }

                    //Se tiver acesso ao menu, ele verifica os submenus
                    if(acessoMenu){
                        // Iterar sobre os itens de menu dentro de cada JMenu
                        for (int j = 0; j < menu.getItemCount(); j++) {
                            JMenuItem subMenu = menu.getItem(j);
                            Integer codSubMenu = Integer.valueOf(subMenu.getName());
                            if(codSubMenu != 0 && codSubMenu == aces.getMenuId() && aces.getPodeAcesasr() == 0){
                                subMenu.setEnabled(false);  
                            }                                       
                        }
                    }
                }       
            }
        }else{
            //Se não tiver nada na tabela de PermissoesPersonalizada, bloqueia o acesso a todas a telas
            for (int i = 0; i < menuBarra.getMenuCount(); i++) {
                JMenu menu = menuBarra.getMenu(i);
                Integer codMenu = Integer.valueOf(menu.getName());

                menu.setEnabled(false);
            }
            
        }
    }
    
    private void fundoTelaInicial(){
        // Obtém o JDesktopPane, caso já não esteja referenciado
        JDesktopPane telaIniciao = painelHome;
        
        // Define a cor de fundo para o JDesktopPane (por exemplo, azul claro)
        telaIniciao.setBackground(cores.getAzulClaro()); // Altere para a cor desejada
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem formAcessosUsuarios;
    private javax.swing.JMenuItem formAdicionarLivroBiblioteca;
    private javax.swing.JMenuItem formAdicionarParticipante;
    private javax.swing.JMenuItem formAlterarContasPagar;
    private javax.swing.JMenuItem formAlterarSenha;
    private javax.swing.JMenuItem formAplicacaoFinanceira;
    private javax.swing.JMenuItem formCadastroAutor;
    private javax.swing.JMenuItem formCadastroBibliotecas;
    private javax.swing.JMenuItem formCadastroContaCaixa;
    private javax.swing.JMenuItem formCadastroContaResultado;
    private javax.swing.JMenuItem formCadastroEditora;
    private javax.swing.JMenuItem formCadastroFormaPagto;
    private javax.swing.JMenuItem formCadastroIgreja;
    private javax.swing.JMenuItem formCadastroLivros;
    private javax.swing.JMenuItem formCadastroPessoas;
    private javax.swing.JMenuItem formCadastroSubContaResultado;
    private javax.swing.JMenuItem formCadastroTipoOferta;
    private javax.swing.JMenuItem formCadastroUsuario;
    private javax.swing.JMenuItem formCancelarContasPagar;
    private javax.swing.JMenuItem formConsultarAcervoBiblioteca;
    private javax.swing.JMenuItem formConsultarCampanhas;
    private javax.swing.JMenuItem formConsultarDizimoOfertas;
    private javax.swing.JMenuItem formCriarCampanha;
    private javax.swing.JMenuItem formEfetivarContasPagar;
    private javax.swing.JMenuItem formEmprestimoLivros;
    private javax.swing.JMenuItem formGerenciarConsultarEmprestimo;
    private javax.swing.JMenuItem formGerenciarContaReceberCampanha;
    private javax.swing.JMenuItem formLancarContasPagar;
    private javax.swing.JMenuItem formLancarContasReceberCampanha;
    private javax.swing.JMenuItem formMovimentoFinanceiro;
    private javax.swing.JMenuItem formRegistrarOfertasDizimo;
    private javax.swing.JMenuItem formRelatorioContasPagar;
    private javax.swing.JMenuItem formRelatorioContasReceber;
    private javax.swing.JMenuItem formRelatorioExtratoCaixa;
    private javax.swing.JMenuItem formRelatorioMovimentoDizimoOferta;
    private javax.swing.JMenuItem formRelatorioPrestacaoContaMensal;
    private javax.swing.JMenuItem formRemoverParticipante;
    private javax.swing.JMenuItem formRetiradaAplicacao;
    private javax.swing.JMenuItem formSaidaAvulsaLivro;
    private javax.swing.JMenuItem formTransferenciasBancarias;
    private javax.swing.JMenu menuAlterarSenha;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuBiblioteca;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuCampanha;
    private javax.swing.JMenu menuConfiguracoes;
    private javax.swing.JMenu menuFinanceiro;
    private javax.swing.JMenu menuRelatorios;
    public javax.swing.JDesktopPane painelHome;
    private javax.swing.JMenu subMenuCadastroEntidades;
    private javax.swing.JMenu subMenuCadastroPlanoContas;
    private javax.swing.JMenu subMenuCadastros;
    private javax.swing.JMenu subMenuEmprestimoLivros;
    private javax.swing.JMenu subMenuFinanceiroCaixa;
    private javax.swing.JMenu subMenuFinanceiroContasPagar;
    private javax.swing.JMenu subMenuFinanceiroDizimoOfertas;
    private javax.swing.JMenu subMenuOpercaoBiblioteca;
    private javax.swing.JMenu subMenuProcessosAvulsosCampanha;
    private javax.swing.JMenu subMenuRelatorioDizimoOferta;
    private javax.swing.JMenu subMenuRelatorioFinanceiro;
    private javax.swing.JMenu subMenuRelatorioPrestacaoConta;
    private javax.swing.JMenu subMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
