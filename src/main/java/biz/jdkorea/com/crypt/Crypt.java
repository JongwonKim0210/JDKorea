package biz.jdkorea.com.crypt;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class Crypt {
    private static final String KEY = "f0d63ab7916184819e558407aaf7af05";

    public static String encode(String str) throws Exception {
        byte[] keyData = KEY.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = new SecretKeySpec(keyData, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(KEY.substring(0, 16).getBytes(StandardCharsets.UTF_8)));
        byte[] encrypted = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
        return new String(Base64.encodeBase64(encrypted));
    }

    public static String decode(String str) throws Exception {
        byte[] keyData = KEY.getBytes(StandardCharsets.UTF_8);
        SecretKey secretKey = new SecretKeySpec(keyData, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(KEY.substring(0, 16).getBytes(StandardCharsets.UTF_8)));
        byte[] bytesStr = Base64.decodeBase64(str.getBytes(StandardCharsets.UTF_8));
        return new String(cipher.doFinal(bytesStr), StandardCharsets.UTF_8);
    }
}
