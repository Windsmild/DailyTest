package myTest;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 * 可以生成公钥私钥和加密解密
 *
 * @author Stephen Cai
 * @date 2018-04-26 11:01
 */
public class RSACryptography {

    public static String data = "hello world";

    //生成密钥对
    public static KeyPair genKeyPair(int keyLength) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.generateKeyPair();
    }

    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");//java默认"RSA"="RSA/ECB/PKCS1Padding"
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(content);
    }

    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(content);
    }


    public void execCommand(String[] arstringCommand) {
        for (int i = 0; i < arstringCommand.length; i++) {
            System.out.print(arstringCommand[i] + " ");
        }
        try {
            Runtime.getRuntime().exec(arstringCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void execCommand(String arstringCommand) {
        try {
            Runtime.getRuntime().exec(arstringCommand);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) throws Exception {

        // TODO Auto-generated method stub
        for (int i = 0; i < 5; i++) {
            KeyPair keyPair = genKeyPair(1024);

            //获取公钥，并以base64格式打印出来
            PublicKey publicKey = keyPair.getPublic();
            System.out.println("公钥：" + new String(Base64.getEncoder().encode(publicKey.getEncoded())));

            //获取私钥，并以base64格式打印出来
            PrivateKey privateKey = keyPair.getPrivate();
            System.out.println("私钥：" + new String(Base64.getEncoder().encode(privateKey.getEncoded())));

            //公钥加密
            byte[] encryptedBytes = encrypt(data.getBytes(), publicKey);
            System.out.println("加密后：" + new String(encryptedBytes));

            //私钥解密
            byte[] decryptedBytes = decrypt(encryptedBytes, privateKey);
            System.out.println("解密后：" + new String(decryptedBytes));
        }

    }


}
