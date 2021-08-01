package algorithm.leetCode;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;

public class ShaTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        KeyGenerator keygen;
        keygen = KeyGenerator.getInstance("AES");
        keygen.init(128);

        System.out.println(keygen.generateKey().getEncoded());
    }
}
