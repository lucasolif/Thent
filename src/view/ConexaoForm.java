
package view;

import com.google.gson.Gson;
import dao.LogsDao;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import jdbc.Conexao;
import jdbc.Configuracao;

public class ConexaoForm extends javax.swing.JDialog {
    
    private boolean conectado = false;
    private final LogsDao logsDao = new LogsDao();
    
    public ConexaoForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        servidor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bancoDados = new javax.swing.JTextField();
        login = new javax.swing.JTextField();
        btnConectar = new javax.swing.JButton();
        senha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conxão Bando de Dados");
        setModal(true);
        setResizable(false);

        jLabel1.setText("Servidor:");

        jLabel2.setText("Banco:");

        jLabel3.setText("Login:");

        jLabel4.setText("Senha:");

        btnConectar.setBackground(new java.awt.Color(0, 153, 255));
        btnConectar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnConectar.setText("Conectar");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                senhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConectar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(servidor)
                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bancoDados, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(servidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(bancoDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(btnConectar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        submeterDados();
    }//GEN-LAST:event_btnConectarActionPerformed

    private void senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_senhaKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            submeterDados();
        }
    }//GEN-LAST:event_senhaKeyPressed

    private void criandoArquivoConexao(String servidor, String bancoDados, String login, String senha){
        
        //Pega a pasta raiz onde o projeto está instalado
        String caminhoArquivo = System.getProperty("user.dir")+"\\config.txt";
        
        File arquivo = new File(caminhoArquivo); //Cria o arquivo no caminho especificado acima
        
        try(FileWriter escritor = new FileWriter(arquivo)){
            // Criando o objeto de configuração
            Configuracao config = new Configuracao(servidor, bancoDados, login, senha);
            
            // Inicializando o banco de dados
            conectado = Conexao.inicializandoBancoDados(config);
            
            //Validando se foi conectado
            if(conectado){   
                Gson gson = new Gson();// Usando Gson para converter o objeto em JSON
                String json = gson.toJson(config);
                escritor.write(json); // Escrevendo o JSON no arquivo
            }
        } catch (IOException ex) {
            logsDao.gravaLogsErro("UsuarioDao"+" - "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar os dados do banco de dados", "Erro 014", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void submeterDados(){
        //Obtendo os dados inseridos
        String servidor = this.servidor.getText();
        String bancoDados = this.bancoDados.getText();
        String login = this.login.getText();
        String senha = this.senha.getText();
    
        criandoArquivoConexao(servidor, bancoDados, login, senha);
        if(conectado){
            JOptionPane.showMessageDialog(null, "Conexão Efetuada com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }else{
            this.servidor.setText("");
            this.bancoDados.setText("");
            this.login.setText("");
            this.senha.setText("");
        }  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bancoDados;
    private javax.swing.JButton btnConectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField login;
    private javax.swing.JPasswordField senha;
    private javax.swing.JTextField servidor;
    // End of variables declaration//GEN-END:variables
}
