
package view.configuracoes;

import Ferramentas.CriptografarSenhas;
import dao.UsuarioDao;
import java.awt.Dimension;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Usuario;
import model.Usuario;

public class AlterarSenhaForm extends javax.swing.JInternalFrame{
    
    private final UsuarioDao usuarioDao = new UsuarioDao();

    public AlterarSenhaForm(Usuario usuarioLogado) {
        initComponents();
        carregarDadosUsuario(usuarioLogado);
    }

    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usuarioLogado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        confirmacaoSenha = new javax.swing.JPasswordField();
        novaSenha = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        codUsuarioLogado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Alterar Senha");

        usuarioLogado.setEditable(false);
        usuarioLogado.setBackground(new java.awt.Color(204, 204, 204));
        usuarioLogado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        usuarioLogado.setFocusable(false);

        jLabel2.setText("Nova Senha");

        jLabel3.setText("Confirmar Senha");

        btnSalvar.setBackground(new java.awt.Color(0, 255, 0));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        codUsuarioLogado.setEditable(false);
        codUsuarioLogado.setBackground(new java.awt.Color(204, 204, 204));
        codUsuarioLogado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        codUsuarioLogado.setFocusable(false);

        jLabel4.setText("Usuário");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnSalvar)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(novaSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(confirmacaoSenha)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(codUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(usuarioLogado)))
                    .addComponent(jLabel4))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codUsuarioLogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(novaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(confirmacaoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            alterarSenha();
            formInicial();
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void carregarDadosUsuario(Usuario userLogado){   
        String codUsuario = String.valueOf(userLogado.getCodigo());
        String nomeUsuario = userLogado.getLogin();
        
        this.codUsuarioLogado.setText(codUsuario);   
        this.usuarioLogado.setText(nomeUsuario);
    }
    
    private void alterarSenha() throws Exception{
        
        Usuario usuario = new Usuario();
        Integer codUsuario = Integer.valueOf(this.codUsuarioLogado.getText());
        String senha = this.novaSenha.getText();
        String confirmSenha = this.confirmacaoSenha.getText();
        
        if(validarIgualdadeSenha(senha, confirmSenha) && validarForcaSenha(senha)){      
            //Gerando Rash e Salt
            byte[] salt = CriptografarSenhas.gerarSalt();
            String rashSenha = CriptografarSenhas.gerarHash(senha,salt);
            String saltSenha = Base64.getEncoder().encodeToString(salt);
            
            usuario.setCodigo(codUsuario);
            usuario.setHashSenha(rashSenha);
            usuario.setSaltSenha(saltSenha);
            
            this.usuarioDao.alterarSenha(usuario);
                 
        }else{
            JOptionPane.showMessageDialog(null, "Se senha precisa ser iguais e conter letras maísculo e números", "Erro", JOptionPane.WARNING_MESSAGE);
            this.codUsuarioLogado.setText("");
            this.usuarioLogado.setText("");
        }
    }

    private boolean validarIgualdadeSenha(String senha, String confirmacaoSenha){
        
        boolean control;
        
        if(confirmacaoSenha.equalsIgnoreCase(senha)){  
            control = true;
        }else{
            JOptionPane.showMessageDialog(null, "Senhas diferente. Digite a mesma senha em ambos os campos", "Erro 003", JOptionPane.WARNING_MESSAGE);
            control = false;
        }       
        return control;
    }
    
    private boolean validarForcaSenha(String senha){
        
        boolean control;
        
        Pattern pattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{6,20}$");
        Matcher matcher = pattern.matcher(senha);
        if (matcher.find()) {
            control = true;
        }else{
            JOptionPane.showMessageDialog(null, "Senha fraca, precisa conter: letra maiúscula e número.", "Erro 003", JOptionPane.WARNING_MESSAGE);
            control = false;
        }       
        return control;
    }
    
    private void formInicial(){
        this.codUsuarioLogado.setText("");
        this.usuarioLogado.setText("");
        this.confirmacaoSenha.setText("");
        this.novaSenha.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField codUsuarioLogado;
    private javax.swing.JPasswordField confirmacaoSenha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField novaSenha;
    private javax.swing.JTextField usuarioLogado;
    // End of variables declaration//GEN-END:variables
}
