package com.example.test.using_cipher;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.StringTokenizer;

public class test1 {
    @SuppressWarnings("squid:S2278")
    public static void main(String[] args) {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            keygen.init(56);
            SecretKey desKey = keygen.generateKey();
            byte[] bytes = desKey.getEncoded();
            getString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getKey();
    }

    private static void getKey() {
        SecretKey s = null;
        String tk = "";
        try {
            java.io.File file = new java.io.File("./conf/keys.properties");
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
            java.util.Properties properties = new java.util.Properties();
            properties.load(fileInputStream);

            tk = properties.getProperty("ENC_KEY");
            System.out.println(tk);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            sb.append(0x00FF & b);
            if ((i + 1) < bytes.length) {
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
