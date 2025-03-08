
package view;

import dao.LoginDao;
import ferramentas.Utilitarios;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import autenticacao.CriptografarSenhas;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import jdbc.Conexao;
import jdbc.Configuracao;
import model.Usuario;



public class LoginThent extends javax.swing.JFrame {

    private final Utilitarios cores = new Utilitarios();
    private File arquivo = new File("");
    private Usuario loginSelec = null;

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
        esqueceuSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));
        setResizable(false);

        LabelLogin.setFont(new java.awt.Font("Sylfaen", 1, 15)); // NOI18N
        LabelLogin.setText("Login");

        campoSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoSenhaKeyPressed(evt);
            }
        });

        btnEntrar.setBackground(new java.awt.Color(0, 102, 255));
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

        esqueceuSenha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        esqueceuSenha.setText("Esqueceu a senha?");
        esqueceuSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        esqueceuSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                esqueceuSenhaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                esqueceuSenhaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                esqueceuSenhaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(esqueceuSenha)
                        .addContainerGap())
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(esqueceuSenha)
                .addContainerGap())
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

    private void esqueceuSenhaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esqueceuSenhaMouseEntered
        this.esqueceuSenha.setForeground(Color.red);
        //this.esqueceuSenha.setFocusable(true);
    }//GEN-LAST:event_esqueceuSenhaMouseEntered

    private void esqueceuSenhaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esqueceuSenhaMouseExited
        this.esqueceuSenha.setForeground(Color.BLACK);
    }//GEN-LAST:event_esqueceuSenhaMouseExited

    private void esqueceuSenhaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_esqueceuSenhaMousePressed
        EsqueceuSenhaForm esqueceuSenha = new EsqueceuSenhaForm(this, true);
        esqueceuSenha.setLocationRelativeTo(this);
        esqueceuSenha.setVisible(true);
    }//GEN-LAST:event_esqueceuSenhaMousePressed

    //Valida o login e senha do usu�rio
    private void validandoUsuario(){
        
        LoginDao loginDao = new LoginDao();
        String loginInformado = campoLogin.getText();
        String senhaInformada = campoSenha.getText();
        
        if(!senhaInformada.isEmpty() && !loginInformado.isEmpty()){
            //Verificando se o usuario existe no banco de dados e obtendo o Hash e Salt
            loginSelec = loginDao.consultarLogin(loginInformado);
            
            if(loginSelec.getLogin() != null && verificarSenha()){
                Home telaInicial = new Home(loginSelec);
                telaInicial.setVisible(true); //Abrindo a tela do sistema
                dispose();
                loginDao.adicionarLogin(loginSelec.getCodigo()); //Adicionando o login na tabela de Login

            }else{
                JOptionPane.showMessageDialog(null, "Login ou senha inv�lida", "Erro 004",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Campo vazio. Preencha todos os campos", "Erro",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    private void verificandoConexao(){
        
        //Pega a pasta raiz onde o projeto est� instalado
        String caminhoArquivo = System.getProperty("user.dir")+"\\config.txt";
        
        arquivo = new File(caminhoArquivo); //Cria o arquivo no caminho especificado acima
        
        // Verifica se o arquivo j� existe
        if (!arquivo.exists()) {
            //Se n�o existir ele abre o Dialog para inserir os dados do banco.
            abrirFormConexao();
        } else {
            //Se j� existir o arquivo, ele ler, obtem os dados e faz a conex�o
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
                JOptionPane.showMessageDialog(null, "Arquivo de conex�o do banco de dados est� vazio", "Erro 014", JOptionPane.ERROR_MESSAGE);
            }            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar ler o arquivo JSON do banco de dados", "Erro 014", JOptionPane.ERROR_MESSAGE);
        } catch (JsonSyntaxException e) {
            JOptionPane.showMessageDialog(null, "Erro na sintaxe do arquivo JSON do banco de dados.", "Erro 014", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Caso n�o seja encontrado o arquivo de config, ele abre o formul�rio para preecher os dados de conex�o
    private void abrirFormConexao(){
        ConexaoForm dialogConex = new ConexaoForm(this, true);
        dialogConex.setVisible(true);
    }
    
    //Gera o Rash e o Salt da senha inserida, para ser comparada no banco de dados.
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
            JOptionPane.showMessageDialog(null, "Erro ao tentar validar a senha do usu�rio", "Erro",JOptionPane.WARNING_MESSAGE);
        }
   
        return userValidado;
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
        }
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
    private javax.swing.JLabel esqueceuSenha;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
