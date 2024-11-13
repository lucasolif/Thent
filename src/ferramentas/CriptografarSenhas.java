
package ferramentas;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


public class CriptografarSenhas {
    
    // Número de iterações e tamanho do hash
    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256;
    
    // Método para gerar um salt
    public static byte[] gerarSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16]; // Tamanho do salt
        random.nextBytes(salt);
        
        return salt;
    }
    
    // Método para hash da senha
    public static String gerarHash(String password, byte[] salt) throws Exception {
        
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        
        return Base64.getEncoder().encodeToString(hash);
    }
    
}
