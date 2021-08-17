package algorithm.leetCode;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.crypto.KeyGenerator;

public class ShaTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyGenerator keygen;
        keygen = KeyGenerator.getInstance("AES");
        keygen.init(128);

        System.out.println(UUID.randomUUID().toString());

        String key = bytesToHex(keygen.generateKey().getEncoded());

        System.out.println(key);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
