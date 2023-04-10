/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AES;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Pelumi
 */
public class AES {
     private static SecretKeySpec secretKey;
    private static byte[] key;
    public static void createKey(final String mykey)
    {
        try {
            MessageDigest sha = null;
            key = mykey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //! Second method
    //
    public static String encrypt(final String strToEncrypt, final String key)
    {
        try {
            createKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
            
        } catch (Exception e) {
            System.out.println("Error while decrypting" + e.toString());
        }
        return null;
    }
     //! Third method
    public static String decrypt(final String strToDecrypt, final String key)
    {
        try {
            createKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            
        } catch (Exception e) {
            System.out.println("Error while decrypting" + e.toString());
        }
        return null;
    }

}
