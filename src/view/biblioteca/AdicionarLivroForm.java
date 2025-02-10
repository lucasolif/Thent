
package view.biblioteca;

import dao.BibliotecaDao;
import dao.LivroDao;
import dao.RegistroBibliotecaDao;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import model.Biblioteca;
import model.Livro;
import model.RegistroBiblioteca;
import model.UsuarioLogado;


public class AdicionarLivroForm extends javax.swing.JDialog {

    private UsuarioLogado usuarioLogado;
    private final LivroDao livroDao = new LivroDao();
    private final BibliotecaDao bibliotecaDao = new BibliotecaDao();
    private final RegistroBibliotecaDao rgBibliotecaDao = new RegistroBibliotecaDao();

    public AdicionarLivroForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregarLivros();
        carregarBibliotecas();
        this.usuarioLogado = usuarioLogado;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        livros = new javax.swing.JComboBox<>();
        qtdLivros = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        biblioteca = new javax.swing.JComboBox<>();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Livro");

        jLabel1.setText("Livro*");

        qtdLivros.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel3.setText("Qtd.");

        btnSalvar.setBackground(new java.awt.Color(0, 255, 51));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("Biblioteca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(livros, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(qtdLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(biblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        adicionarLivro();
        carregarLivros();
        carregarBibliotecas();
        this.qtdLivros.setValue(1);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void carregarLivros(){  
        List<Livro> listaLivro = this.livroDao.consultarLivros();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.livros.getModel();
        modelo.removeAllElements();
        for(Livro livro : listaLivro){
            modelo.addElement(livro);
        }
    }
    
    private void carregarBibliotecas(){  
        List<Biblioteca> listaBiblioteca = this.bibliotecaDao.consultarBibliotecaJComboBox();
        DefaultComboBoxModel modelo = (DefaultComboBoxModel)this.biblioteca.getModel();
        modelo.removeAllElements();
        for(Biblioteca bibli : listaBiblioteca){
            modelo.addElement(bibli);
        }
    }
    
    private void adicionarLivro(){     
        Livro livro = (Livro) this.livros.getSelectedItem();
        Biblioteca biblioteca  = (Biblioteca) this.biblioteca.getSelectedItem();
        Integer qtd = (Integer) this.qtdLivros.getValue();
        
        RegistroBiblioteca rgBiblioteca = new RegistroBiblioteca();
        rgBiblioteca.setLivro(livro);
        rgBiblioteca.setBiblioteca(biblioteca);
        rgBiblioteca.setQtdLivro(qtd);
        
        this.rgBibliotecaDao.adicionarLivroBiblioteca(rgBiblioteca, this.usuarioLogado);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> biblioteca;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> livros;
    private javax.swing.JSpinner qtdLivros;
    // End of variables declaration//GEN-END:variables
}
