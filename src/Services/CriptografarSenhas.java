
package Services;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;


public class CriptografarSenhas {
    
    // Número de iterações e tamanho do hash
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    

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
    
}
