package view;

import javax.swing.JFrame;
import jdbc.Conexao;
import view.biblioteca.AdicionarLivroForm;
import view.biblioteca.AutorForm;
import view.biblioteca.BibliotecaForm;
import view.biblioteca.ConsultaEmprestimoForm;
import view.biblioteca.EditoraForm;
import view.biblioteca.EmprestimoForm;
import view.biblioteca.LivrosForm;
import view.cadastros.ContaCaixaForm;
import view.cadastros.ContaResultadoForm;
import view.cadastros.FormaPagtoForm;
import view.cadastros.IgrejaForm;
import view.cadastros.PessoasForm;
import view.cadastros.SubContaResultadoForm;
import view.cadastros.TipoOfertaForm;
import view.cadastros.UsuarioForm;
import view.configuracoes.AlterarSenhaForm;
import view.contasPagar.CancelarContasPagarForm;
import view.contasPagar.ContasPagarForm;
import view.contasPagar.EfetivarContasPagarForm;
import view.financeiro.ConsultaRegistroDizimoOferta;
import view.financeiro.MovimentoFinanceiroForm;
import view.financeiro.RegistroDizimoOfertaForm;
import view.financeiro.TransferenciaContaForm;



public class Home extends javax.swing.JFrame {
    
    public Home() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelHome = new javax.swing.JDesktopPane();
        menuBarra = new javax.swing.JMenuBar();
        cadastros = new javax.swing.JMenu();
        cadastroPessoas = new javax.swing.JMenuItem();
        cadastroIgreja = new javax.swing.JMenuItem();
        cadastroUsuario = new javax.swing.JMenuItem();
        cadastroEntidades = new javax.swing.JMenu();
        cadastroFormaPagto = new javax.swing.JMenuItem();
        cadastroContaCaixa = new javax.swing.JMenuItem();
        cadastroTipoOferta = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        cadastroContaResultado = new javax.swing.JMenuItem();
        cadastroSubContaResultado = new javax.swing.JMenuItem();
        financeiro = new javax.swing.JMenu();
        operacaoDizimoOfertas = new javax.swing.JMenu();
        registrarOfertasDizimo = new javax.swing.JMenuItem();
        efetivacaoDizimoOfertas = new javax.swing.JMenuItem();
        operacaoContasPagar = new javax.swing.JMenu();
        lancarContasPagar = new javax.swing.JMenuItem();
        efetivarContasPagar = new javax.swing.JMenuItem();
        cancelarContasPagar = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        operacaoCaixa = new javax.swing.JMenu();
        transferencia = new javax.swing.JMenuItem();
        movimentoFinanceiro = new javax.swing.JMenuItem();
        relatorios = new javax.swing.JMenu();
        biblioteca = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        cadastroLivros = new javax.swing.JMenuItem();
        cadastroAutor = new javax.swing.JMenuItem();
        cadastroEditora = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        cadastroBiblioteca = new javax.swing.JMenuItem();
        addLivroBiblioteca = new javax.swing.JMenuItem();
        operacaoEmprestimo = new javax.swing.JMenuItem();
        operacaoConsultaEmprestimo = new javax.swing.JMenuItem();
        configuracoes = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenu();
        alterarSenha = new javax.swing.JMenuItem();

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
            .addGap(0, 500, Short.MAX_VALUE)
        );
        painelHomeLayout.setVerticalGroup(
            painelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        menuBarra.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menuBarra.setName(""); // NOI18N

        cadastros.setText("Cadastros");

        cadastroPessoas.setText("Membros/Pessoa");
        cadastroPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroPessoasActionPerformed(evt);
            }
        });
        cadastros.add(cadastroPessoas);

        cadastroIgreja.setText("Campo/Igreja");
        cadastroIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroIgrejaActionPerformed(evt);
            }
        });
        cadastros.add(cadastroIgreja);

        cadastroUsuario.setText("Usuários");
        cadastroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroUsuarioActionPerformed(evt);
            }
        });
        cadastros.add(cadastroUsuario);

        cadastroEntidades.setText("Entidades");

        cadastroFormaPagto.setText("Forma de Pagamento");
        cadastroFormaPagto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroFormaPagtoActionPerformed(evt);
            }
        });
        cadastroEntidades.add(cadastroFormaPagto);

        cadastroContaCaixa.setText("Conta Caixa");
        cadastroContaCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroContaCaixaActionPerformed(evt);
            }
        });
        cadastroEntidades.add(cadastroContaCaixa);

        cadastroTipoOferta.setText("Tipo De Oferta");
        cadastroTipoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroTipoOfertaActionPerformed(evt);
            }
        });
        cadastroEntidades.add(cadastroTipoOferta);

        jMenu1.setText("Plano de Contas");

        cadastroContaResultado.setText("Conta de Resultado");
        cadastroContaResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroContaResultadoActionPerformed(evt);
            }
        });
        jMenu1.add(cadastroContaResultado);

        cadastroSubContaResultado.setText("SubConta de Resultado");
        cadastroSubContaResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroSubContaResultadoActionPerformed(evt);
            }
        });
        jMenu1.add(cadastroSubContaResultado);

        cadastroEntidades.add(jMenu1);

        cadastros.add(cadastroEntidades);

        menuBarra.add(cadastros);

        financeiro.setText("Financeiro");
        financeiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        operacaoDizimoOfertas.setText("Operações Dízimo/Ofertas");

        registrarOfertasDizimo.setText("Registrar Dizimo/Ofertas");
        registrarOfertasDizimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarOfertasDizimoActionPerformed(evt);
            }
        });
        operacaoDizimoOfertas.add(registrarOfertasDizimo);

        efetivacaoDizimoOfertas.setText("Consulta de Dizimo/Oferta");
        efetivacaoDizimoOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efetivacaoDizimoOfertasActionPerformed(evt);
            }
        });
        operacaoDizimoOfertas.add(efetivacaoDizimoOfertas);

        financeiro.add(operacaoDizimoOfertas);

        operacaoContasPagar.setText("Contas a Pagar");

        lancarContasPagar.setText("Lançar Contas a Pagar");
        lancarContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancarContasPagarActionPerformed(evt);
            }
        });
        operacaoContasPagar.add(lancarContasPagar);

        efetivarContasPagar.setText("Efetivar/Consultar Contas a Pagar");
        efetivarContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                efetivarContasPagarActionPerformed(evt);
            }
        });
        operacaoContasPagar.add(efetivarContasPagar);

        cancelarContasPagar.setText("Cancelar Contas a Pagar");
        cancelarContasPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarContasPagarActionPerformed(evt);
            }
        });
        operacaoContasPagar.add(cancelarContasPagar);

        jMenuItem1.setText("Alterar Contas a Pagar");
        operacaoContasPagar.add(jMenuItem1);

        financeiro.add(operacaoContasPagar);

        operacaoCaixa.setText("Operações Caixa");

        transferencia.setText("Transferência de Contas");
        transferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferenciaActionPerformed(evt);
            }
        });
        operacaoCaixa.add(transferencia);

        movimentoFinanceiro.setText("Movimento Financeiro");
        movimentoFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimentoFinanceiroActionPerformed(evt);
            }
        });
        operacaoCaixa.add(movimentoFinanceiro);

        financeiro.add(operacaoCaixa);

        menuBarra.add(financeiro);

        relatorios.setText("Relatórios");
        menuBarra.add(relatorios);

        biblioteca.setText("Biblioteca");

        jMenu2.setText("Cadastros");

        cadastroLivros.setText("Livros");
        cadastroLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroLivrosActionPerformed(evt);
            }
        });
        jMenu2.add(cadastroLivros);

        cadastroAutor.setText("Autor(a)");
        cadastroAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroAutorActionPerformed(evt);
            }
        });
        jMenu2.add(cadastroAutor);

        cadastroEditora.setText("Editora/Publicadora");
        cadastroEditora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroEditoraActionPerformed(evt);
            }
        });
        jMenu2.add(cadastroEditora);

        biblioteca.add(jMenu2);

        jMenu3.setText("Biblioteca");

        cadastroBiblioteca.setText("Biblioteca");
        cadastroBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastroBibliotecaActionPerformed(evt);
            }
        });
        jMenu3.add(cadastroBiblioteca);

        addLivroBiblioteca.setText("Adicionar Livro Biblioteca");
        addLivroBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLivroBibliotecaActionPerformed(evt);
            }
        });
        jMenu3.add(addLivroBiblioteca);

        biblioteca.add(jMenu3);

        operacaoEmprestimo.setText("Empréstimo");
        operacaoEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacaoEmprestimoActionPerformed(evt);
            }
        });
        biblioteca.add(operacaoEmprestimo);

        operacaoConsultaEmprestimo.setText("Consultar Empréstimo");
        operacaoConsultaEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                operacaoConsultaEmprestimoActionPerformed(evt);
            }
        });
        biblioteca.add(operacaoConsultaEmprestimo);

        menuBarra.add(biblioteca);

        configuracoes.setText("Configurações");

        menuUsuario.setText("Usuário");

        alterarSenha.setText("Alterar Senha");
        alterarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarSenhaActionPerformed(evt);
            }
        });
        menuUsuario.add(alterarSenha);

        configuracoes.add(menuUsuario);

        menuBarra.add(configuracoes);

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

    private void cadastroPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroPessoasActionPerformed
        PessoasForm cadastroPessoas = new PessoasForm();
        painelHome.add(cadastroPessoas);
        cadastroPessoas.setVisible(true);
        cadastroPessoas.setPosicao();
    }//GEN-LAST:event_cadastroPessoasActionPerformed

    private void cadastroIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroIgrejaActionPerformed
        IgrejaForm cadastroIgreja = new IgrejaForm();
        painelHome.add(cadastroIgreja);
        cadastroIgreja.setVisible(true);
        cadastroIgreja.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_cadastroIgrejaActionPerformed

    private void cadastroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroUsuarioActionPerformed
        UsuarioForm cadastroUsuario = new UsuarioForm();
        painelHome.add(cadastroUsuario);
        cadastroUsuario.setVisible(true);
        cadastroUsuario.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_cadastroUsuarioActionPerformed

    private void cadastroFormaPagtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroFormaPagtoActionPerformed
        FormaPagtoForm cadastroFormaPagto = new FormaPagtoForm();
        painelHome.add(cadastroFormaPagto);
        cadastroFormaPagto.setVisible(true);
        cadastroFormaPagto.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_cadastroFormaPagtoActionPerformed

    private void cadastroContaCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroContaCaixaActionPerformed
        ContaCaixaForm cadastroContaCaixa = new ContaCaixaForm();
        painelHome.add(cadastroContaCaixa);
        cadastroContaCaixa.setVisible(true);
        cadastroContaCaixa.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_cadastroContaCaixaActionPerformed

    private void cadastroTipoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroTipoOfertaActionPerformed
        TipoOfertaForm cadastroTipoOferta = new TipoOfertaForm();
        painelHome.add(cadastroTipoOferta);
        cadastroTipoOferta.setVisible(true);
        cadastroTipoOferta.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_cadastroTipoOfertaActionPerformed

    private void lancarContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lancarContasPagarActionPerformed
        ContasPagarForm contasPagar = new ContasPagarForm();
        painelHome.add(contasPagar);
        contasPagar.setVisible(true);
        contasPagar.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_lancarContasPagarActionPerformed

    private void efetivarContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efetivarContasPagarActionPerformed
        EfetivarContasPagarForm efetivarContas = new EfetivarContasPagarForm();
        painelHome.add(efetivarContas);
        efetivarContas.setVisible(true);
        efetivarContas.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_efetivarContasPagarActionPerformed

    private void registrarOfertasDizimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarOfertasDizimoActionPerformed
        RegistroDizimoOfertaForm rgDizimoOferta = new RegistroDizimoOfertaForm();
        painelHome.add(rgDizimoOferta);
        rgDizimoOferta.setVisible(true);
        rgDizimoOferta.setPosicao(); //Chama função para centraliza a tela, quando ela for aberta
    }//GEN-LAST:event_registrarOfertasDizimoActionPerformed

    private void transferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferenciaActionPerformed
        TransferenciaContaForm trasnfConta = new TransferenciaContaForm();
        painelHome.add(trasnfConta);
        trasnfConta.setVisible(true);
        trasnfConta.setPosicao();
    }//GEN-LAST:event_transferenciaActionPerformed

    private void alterarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarSenhaActionPerformed
        AlterarSenhaForm alterarSenha = new AlterarSenhaForm();
        painelHome.add(alterarSenha);
        alterarSenha.setVisible(true);
        alterarSenha.setPosicao();
    }//GEN-LAST:event_alterarSenhaActionPerformed

    private void cadastroContaResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroContaResultadoActionPerformed
        ContaResultadoForm contaResultado = new ContaResultadoForm();
        painelHome.add(contaResultado);
        contaResultado.setVisible(true);
        contaResultado.setPosicao();
    }//GEN-LAST:event_cadastroContaResultadoActionPerformed

    private void efetivacaoDizimoOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_efetivacaoDizimoOfertasActionPerformed
        ConsultaRegistroDizimoOferta efetivacao = new ConsultaRegistroDizimoOferta();
        painelHome.add(efetivacao);
        efetivacao.setVisible(true);
        efetivacao.setPosicao();
    }//GEN-LAST:event_efetivacaoDizimoOfertasActionPerformed

    private void movimentoFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimentoFinanceiroActionPerformed
        MovimentoFinanceiroForm movimentoFinanceiro = new MovimentoFinanceiroForm();
        painelHome.add(movimentoFinanceiro);
        movimentoFinanceiro.setVisible(true);
        movimentoFinanceiro.setPosicao();
    }//GEN-LAST:event_movimentoFinanceiroActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Conexao conexao = new Conexao();
        conexao.closeDataSource();
    }//GEN-LAST:event_formWindowClosed

    private void cancelarContasPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarContasPagarActionPerformed
        CancelarContasPagarForm cancelarCp = new CancelarContasPagarForm();
        painelHome.add(cancelarCp);
        cancelarCp.setVisible(true);
        cancelarCp.setPosicao();
    }//GEN-LAST:event_cancelarContasPagarActionPerformed

    private void cadastroLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroLivrosActionPerformed
        LivrosForm cadastrarLivros = new LivrosForm();
        painelHome.add(cadastrarLivros);
        cadastrarLivros.setVisible(true);
        cadastrarLivros.setPosicao();
    }//GEN-LAST:event_cadastroLivrosActionPerformed

    private void cadastroBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroBibliotecaActionPerformed
        BibliotecaForm biblioteca = new BibliotecaForm();
        painelHome.add(biblioteca);
        biblioteca.setVisible(true);
        biblioteca.setPosicao();
    }//GEN-LAST:event_cadastroBibliotecaActionPerformed

    private void operacaoEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacaoEmprestimoActionPerformed
        EmprestimoForm emprestimo = new EmprestimoForm();
        painelHome.add(emprestimo);
        emprestimo.setVisible(true);
        emprestimo.setPosicao();
    }//GEN-LAST:event_operacaoEmprestimoActionPerformed

    private void operacaoConsultaEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_operacaoConsultaEmprestimoActionPerformed
        ConsultaEmprestimoForm consultaEmprestimo = new ConsultaEmprestimoForm();
        painelHome.add(consultaEmprestimo);
        consultaEmprestimo.setVisible(true);
        consultaEmprestimo.setPosicao();
    }//GEN-LAST:event_operacaoConsultaEmprestimoActionPerformed

    private void cadastroSubContaResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroSubContaResultadoActionPerformed
        SubContaResultadoForm subContaResult = new SubContaResultadoForm();
        painelHome.add(subContaResult);
        subContaResult.setVisible(true);
        subContaResult.setPosicao();
    }//GEN-LAST:event_cadastroSubContaResultadoActionPerformed

    private void cadastroAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroAutorActionPerformed
        AutorForm dialogAutor = new AutorForm(this, true);
        dialogAutor.setLocationRelativeTo(this);
        dialogAutor.setVisible(true);
    }//GEN-LAST:event_cadastroAutorActionPerformed

    private void cadastroEditoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastroEditoraActionPerformed
        EditoraForm dialogEditora = new EditoraForm(this, true);
        dialogEditora.setLocationRelativeTo(this);
        dialogEditora.setVisible(true);
    }//GEN-LAST:event_cadastroEditoraActionPerformed

    private void addLivroBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLivroBibliotecaActionPerformed
        AdicionarLivroForm dialogAddLivroBibli = new AdicionarLivroForm(this, true);
        dialogAddLivroBibli.setLocationRelativeTo(this);
        dialogAddLivroBibli.setVisible(true);
    }//GEN-LAST:event_addLivroBibliotecaActionPerformed
  
   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addLivroBiblioteca;
    private javax.swing.JMenuItem alterarSenha;
    private javax.swing.JMenu biblioteca;
    private javax.swing.JMenuItem cadastroAutor;
    private javax.swing.JMenuItem cadastroBiblioteca;
    private javax.swing.JMenuItem cadastroContaCaixa;
    private javax.swing.JMenuItem cadastroContaResultado;
    private javax.swing.JMenuItem cadastroEditora;
    private javax.swing.JMenu cadastroEntidades;
    private javax.swing.JMenuItem cadastroFormaPagto;
    private javax.swing.JMenuItem cadastroIgreja;
    private javax.swing.JMenuItem cadastroLivros;
    private javax.swing.JMenuItem cadastroPessoas;
    private javax.swing.JMenuItem cadastroSubContaResultado;
    private javax.swing.JMenuItem cadastroTipoOferta;
    private javax.swing.JMenuItem cadastroUsuario;
    private javax.swing.JMenu cadastros;
    private javax.swing.JMenuItem cancelarContasPagar;
    private javax.swing.JMenu configuracoes;
    private javax.swing.JMenuItem efetivacaoDizimoOfertas;
    private javax.swing.JMenuItem efetivarContasPagar;
    private javax.swing.JMenu financeiro;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem lancarContasPagar;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenuItem movimentoFinanceiro;
    private javax.swing.JMenu operacaoCaixa;
    private javax.swing.JMenuItem operacaoConsultaEmprestimo;
    private javax.swing.JMenu operacaoContasPagar;
    private javax.swing.JMenu operacaoDizimoOfertas;
    private javax.swing.JMenuItem operacaoEmprestimo;
    public javax.swing.JDesktopPane painelHome;
    private javax.swing.JMenuItem registrarOfertasDizimo;
    private javax.swing.JMenu relatorios;
    private javax.swing.JMenuItem transferencia;
    // End of variables declaration//GEN-END:variables
}
