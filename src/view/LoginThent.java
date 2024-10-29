
package view;

import dao.LoginDao;
import ferramentas.Conversores;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ferramentas.CriptografarSenhas;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import jdbc.Configuracao;
import model.Login;


public class LoginThent extends javax.swing.JFrame {

    private final Conversores cores = new Conversores();
    private File arquivo = new File("");
    private Login loginSelec = null;

    public LoginThent() {
        initComponents();
        setLocationRelativeTo( null );
        getContentPane().setBackground(Color.WHITE); // Aplicando a cor que eu criei
        verificandoConexao();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelLogin = new javax.swing.JLabel();
        campoLogin = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        LabelSenha = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));
        setMaximumSize(new java.awt.Dimension(408, 413));
        setResizable(false);

        LabelLogin.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        LabelLogin.setText("Login");

        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });

        btnEntrar.setBackground(new java.awt.Color(39, 59, 128));
        btnEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        LabelSenha.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        LabelSenha.setText("Senha");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.jpeg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoLogin)
                            .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnEntrar)
                        .addGap(137, 137, 137))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(LabelLogin)
                .addGap(0, 0, 0)
                .addComponent(campoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelSenha)
                .addGap(0, 0, 0)
                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        validandoUsuario();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void campoSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoSenhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            validandoUsuario();
        }
    }//GEN-LAST:event_campoSenhaKeyPressed

    private void validandoUsuario(){
        
        LoginDao loginDao = new LoginDao();
        String loginInformado = campoLogin.getText();
        String senhaInformada = campoSenha.getText();
        
        if(!senhaInformada.isEmpty() && !loginInformado.isEmpty()){
            //Verificando se o usuario existe no banco de dados e obtendo o Hash e Salt
            loginSelec = loginDao.consultarLogin(loginInformado);
            
            if(loginSelec.getUsuario() != null && verificarSenha()){
                Home telaInicial = new Home();
                telaInicial.setVisible(true); //Abrindo a tela do sistema
                dispose();
                loginDao.adicionarLogin(loginSelec.getCodUsuario()); //Adicionando o login na tabela de Login

            }else{
                JOptionPane.showMessageDialog(null, "Login ou senha inválida", "Erro 004",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Campo vazio. Preencha todos os campos", "Erro",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
    }
    
    private void verificandoConexao(){
        String caminhoArquivo = "C:\\Users\\Lucas Oliveira\\Documents\\Projetos\\Thent\\config.txt"; //Caminho onde salva o arquivo
        arquivo = new File(caminhoArquivo); //Cria o arquivo no caminho especificado acima
        
        // Verifica se o arquivo já existe
        if (!arquivo.exists()) {
            //Se não existir ele abre o Dialog para inserir os dados do banco.
            abrirFormConexao();
        } else {
            //Se já existir o arquivo, ele ler, obtem os dados e faz a conexão
            obtendoArquivoConexao(caminhoArquivo);
        }
    }
    
    private void obtendoArquivoConexao(String caminhoArquivo){
        
        Gson gson = new Gson();
        try (FileReader leitor = new FileReader(caminhoArquivo)) {
            // Lendo e deserializando o JSON
            Configuracao config = gson.fromJson(leitor, Configuracao.class);
            if(config != null){
               Conexao.inicializandoBancoDados(config); 
            }else{
                JOptionPane.showMessageDialog(null, "Arquivo JSON do banco de dados está vazio", "Erro 014", JOptionPane.ERROR_MESSAGE);
            }            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar ler o arquivo JSON do banco de dados", "Erro 014", JOptionPane.ERROR_MESSAGE);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro na sintaxe do arquivo JSON do banco de dados.", "Erro 014", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abrirFormConexao(){
        ConexaoForm dialogConex = new ConexaoForm(this, true);
        dialogConex.setVisible(true);
    }
    
    private boolean verificarSenha(){
        boolean userValidado = false;
        String senhaInformada = campoSenha.getText();
        String hashObtido = loginSelec.getHashSenha();
        String saltObtido = loginSelec.getSaltSenha();

        try{
            //Converter o Salt obtido
            byte[] salt = Base64.getDecoder().decode(saltObtido);

            //Gerar o Hash da senha fornecedia
            String hashVerifi = CriptografarSenhas.gerarHash(senhaInformada, salt);

            if(hashVerifi.equals(hashObtido)){
                userValidado = true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar validar a senha do usuário", "Erro",JOptionPane.WARNING_MESSAGE);
        }
   
        return userValidado;
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginThent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginThent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginThent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginThent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginThent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JTextField campoLogin;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
