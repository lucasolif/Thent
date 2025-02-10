
package view.biblioteca;

import dao.BibliotecaDao;
import dao.EmprestimoLivroDao;
import dao.LivroDao;
import dao.RegistroBibliotecaDao;
import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Biblioteca;
import model.Livro;
import model.RegistroBiblioteca;
import model.UsuarioLogado;


public class SaidaAvulsaLivroForm extends javax.swing.JInternalFrame {
    
    private UsuarioLogado usuarioLogado;
    private final Biblioteca biblioteca = new Biblioteca();
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao();
    private final EmprestimoLivroDao empLivroDao = new EmprestimoLivroDao();
    private final RegistroBibliotecaDao rgBibliotecaDao = new RegistroBibliotecaDao();
    private final LivroDao livroDao = new LivroDao();

    public SaidaAvulsaLivroForm(UsuarioLogado usuarioLogado) {
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

        jLabel1 = new javax.swing.JLabel();
        livro = new javax.swing.JComboBox<>();
        qtdLivros = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        bibliotecaJComboBox = new javax.swing.JComboBox<>();
        btnSalvar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Saída Avulsa de Livros");

        jLabel1.setText("Livro");

        livro.setToolTipText("Selecione o livro para dar saída");
        livro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        livro.setName(""); // NOI18N

        qtdLivros.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        qtdLivros.setToolTipText("Informe a quantidade de livros");

        jLabel2.setText("Biblioteca");

        btnSalvar.setBackground(new java.awt.Color(0, 204, 51));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(120, 120, 120))
                                    .addComponent(bibliotecaJComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSalvar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(livro, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(qtdLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bibliotecaJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        saidaLivroAvulsa();
        formInicial();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void carregarLivros(){  
        List<Livro> listaLivro = this.livroDao.consultarLivros();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.livro.getModel();
        modelo.removeAllElements();
        for(Livro livro : listaLivro){
            modelo.addElement(livro);
        }
    }
    
    private void carregarBibliotecas(){  
        List<Biblioteca> listaBiblioteca = this.bibliotecaDao.consultarBibliotecaJComboBox();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.bibliotecaJComboBox.getModel();
        modelo.removeAllElements();
        for(Biblioteca bibli : listaBiblioteca){
            modelo.addElement(bibli);
        }
    }
    
    private void saidaLivroAvulsa(){
        Livro livro = (Livro) this.livro.getSelectedItem();
        Biblioteca biblioteca = (Biblioteca) this.bibliotecaJComboBox.getSelectedItem();
        Integer qtdLivro = (Integer) this.qtdLivros.getValue();
        
        RegistroBiblioteca rgBiblioteca = new RegistroBiblioteca();
        rgBiblioteca.setLivro(livro);
        rgBiblioteca.setBiblioteca(biblioteca);
        rgBiblioteca.setQtdLivro(qtdLivro);
        
        if(this.rgBibliotecaDao.verificarExistenciaLivroBiblioteca(rgBiblioteca)){
            this.rgBibliotecaDao.removerLivroBiblioteca(rgBiblioteca, this.usuarioLogado);
        }else{
            JOptionPane.showMessageDialog(null, "Livro não existe na biblioteca escolhida", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void formInicial(){
        carregarBibliotecas();
        carregarLivros();
        this.qtdLivros.setValue(1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bibliotecaJComboBox;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> livro;
    private javax.swing.JSpinner qtdLivros;
    // End of variables declaration//GEN-END:variables
}
