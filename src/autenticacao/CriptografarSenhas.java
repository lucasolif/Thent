
package autenticacao;

import dao.LogsDao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;



public class CriptografarSenhas {
    
    // Número de iterações e tamanho do hash
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    private File arquivo = new File("");
    private final LogsDao logsDao = new LogsDao();
    

    // Método para gerar um salt
    public static byte[] gerarSalt() throws Exception{
        byte[] salt = null;
        try{
            SecureRandom random = new SecureRandom();
            salt = new byte[16]; // Tamanho do salt
            random.nextBytes(salt);

            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o Salt da senha", "Erro",JOptionPane.WARNING_MESSAGE);
        }
        return salt;
    }
    
    // Método para hash da senha
    public static String gerarHash(String password, byte[] salt) throws Exception {
        byte[] hash = null;
        
        try{
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            hash = factory.generateSecret(spec).getEncoded();
        }catch(NoSuchAlgorithmException | InvalidKeySpecException e){
            JOptionPane.showMessageDialog(null, "Erro ao tentar efetuar o Hash da senha", "Erro",JOptionPane.WARNING_MESSAGE);
        }    
        return Base64.getEncoder().encodeToString(hash);
    }
    
    // Método para gerar chave secreta para AES para email
    public String criarChaveCriptografarSenha(String senha) {
        String senhaCriptografada = "";

        try {
            // Caminho do arquivo onde a chave será salva/recuperada
            String caminhoArquivo = System.getProperty("user.dir") + "\\ck.txt";  // Pega a pasta raiz onde o projeto está instalado
            File arquivo = new File(caminhoArquivo);
            SecretKey chave = null;

            if (arquivo.exists()) {
                // Se o arquivo existe, ler a chave do arquivo
                try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
                    String chaveBase64 = reader.readLine();  // Ler a chave Base64 do arquivo
                    byte[] chaveBytes = Base64.getDecoder().decode(chaveBase64);
                    chave = new SecretKeySpec(chaveBytes, "AES");  // Converter para SecretKey
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar carregar a chave do arquivo", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                // Se o arquivo não existe, gerar uma nova chave
                chave = gerarChave();
                String chaveBase64 = Base64.getEncoder().encodeToString(chave.getEncoded());  // Converter a chave para Base64

                // Salvar a chave no arquivo
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
                    writer.write(chaveBase64);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar salvar a chave no arquivo", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }

            // Após carregar ou gerar a chave, criptografar a senha
            if (chave != null) {
                senhaCriptografada = criptografarSenha(senha, chave);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro geral: " + ex.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
        }

        return senhaCriptografada;
 
    }
    
    // Método para gerar a chave AES
    private static SecretKey gerarChave() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);  // Tamanho da chave (128 bits é o mais comum)
        return keyGenerator.generateKey();
    }
    
    public SecretKey obterChave(){
        String caminhoArquivo = System.getProperty("user.dir") + "\\ck.txt";  // Pega a pasta raiz onde o projeto está instalado
        SecretKey chave = null;
        
        // Se o arquivo existe, ler a chave do arquivo
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String chaveBase64 = reader.readLine();  // Ler a chave Base64 do arquivo
            byte[] chaveBytes = Base64.getDecoder().decode(chaveBase64);
            chave = new SecretKeySpec(chaveBytes, "AES");  // Converter para SecretKey
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar carregar a chave do arquivo", "Erro", JOptionPane.WARNING_MESSAGE);
        }
        
        return chave;
    }

    // Método para criptografar a senha
    public static String criptografarSenha(String senha, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        
        // Criptografa a senha (gera um array de bytes)
        byte[] senhaCriptografada = cipher.doFinal(senha.getBytes());      
        // Converte o array de bytes para uma string Base64 para ser armazenado no banco de dados
        return Base64.getEncoder().encodeToString(senhaCriptografada);  // Retorna a senha criptografada em Base64 como string
    }

    // Método para descriptografar a senha
    public String descriptografarSenha(String senhaCriptografada, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] senhaDecodificada = Base64.getDecoder().decode(senhaCriptografada);
        byte[] senhaOriginal = cipher.doFinal(senhaDecodificada);
        return new String(senhaOriginal);  // Retorna a senha original
    }
    
    public String geradorSenhaAleatoria(){
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(6);

        // Gerar a string aleatória
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(caracteres.length());
            sb.append(caracteres.charAt(index));
        }

        return sb.toString();
    }
}
