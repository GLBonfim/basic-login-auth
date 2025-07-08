package auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {
    /** Gera hash SHA-256 em hexadecimal */
    public static String gerarHash(String senhaPura) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(senhaPura.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash", e);
        }
    }
}
