package com.example.test.using_cipher;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) {
        SecretKey secretKey;
        String tk = "112*555*894*465*454*456*456*657";
//        191-251-228-45-195-23-211-153
        StringTokenizer st = new StringTokenizer(tk, "*", false);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5);


        while (st.hasMoreElements()) {
            byte[] value = st.nextToken().getBytes(StandardCharsets.UTF_8);
            try {
                byteArrayOutputStream.write(value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(byteArrayOutputStream);

        byte[] b = byteArrayOutputStream.toByteArray();
        System.out.println(Thread.currentThread().getStackTrace()[1].getClassName() + "-" + Thread.currentThread().getStackTrace()[1].getLineNumber() + ", b: " + b);
        try {
            DESKeySpec desKeySpec = new DESKeySpec(b);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

            secretKey = secretKeyFactory.generateSecret(desKeySpec);
            System.out.println(secretKey);
        } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
