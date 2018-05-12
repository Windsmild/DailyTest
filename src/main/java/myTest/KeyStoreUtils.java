package myTest;

import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import javax.crypto.Cipher;

/**
 * 从keystore中获取privateKey和publicKey
 *
 * @author Stephen Cai
 * @date 2018-05-07 13:40
 */
public class KeyStoreUtils {

    public static String getPublicKey(String cerPath) throws Exception {
        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(cerPath);
        X509Certificate Cert = (X509Certificate) certificatefactory.generateCertificate(fis);
        PublicKey pk = Cert.getPublicKey();
        String publicKey = new String(Base64.getEncoder().encode(pk.getEncoded()));

        return publicKey;
    }

    public static String getPrivateKey(String storePath, String alias, String storePw, String keyPw) throws Exception {
        FileInputStream is = new FileInputStream(storePath);
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(is, storePw.toCharArray());
        is.close();
        PrivateKey key = (PrivateKey) ks.getKey(alias, keyPw.toCharArray());
        String privateKey = new String(Base64.getEncoder().encode(key.getEncoded()));
        return privateKey;
    }

    //加密
    public static byte[] encrypt(byte[] content, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");//java默认"RSA"="RSA/ECB/PKCS1Padding"
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(content);
    }

    //加密
    public static String encrypt(String content, Key key) throws Exception {
        return new String(encrypt(content.getBytes(), key));
    }

    //解密
    public static byte[] decrypt(byte[] content, Key key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(content);
    }

    //解密
    public static String decrypt(String content, Key key) throws Exception {
        return new String(decrypt(content.getBytes(), key));
    }

    //导出.cer证书 base64格式
    public static void exportCert(KeyStore keyStore, String alias, String exportFile) throws Exception {
        try {

            Certificate cert = keyStore.getCertificate(alias);
            String encoded = new String(Base64.getEncoder().encode(cert.getEncoded()));
            System.out.println("-----BEGIN CERTIFICATE-----");
            System.out.println(encoded);
            System.out.println("-----END CERTIFICATE-----");
            //FileWriter fw = new FileWriter(exportFile);
            //fw.write("-----BEGIN CERTIFICATE-----\n");    //非必须
            //fw.write(encoded);
            //fw.write("\n-----END CERTIFICATE-----");  //非必须
            //fw.close();
        } catch (Exception e) {
            System.out.println("exportCert" + e);
        }
    }

    //得到KeyPair
    public static KeyPair getKeyPair(KeyStore keyStore, String alias, char[] password) {
        try {
            //这里的key就是私钥，cert就是公钥
            Key key = keyStore.getKey(alias, password);
            if (key instanceof PrivateKey) {
                Certificate cert = keyStore.getCertificate(alias);
                PublicKey publicKey = cert.getPublicKey();
                return new KeyPair(publicKey, (PrivateKey) key);
            }
        } catch (UnrecoverableKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (KeyStoreException e) {
        }
        return null;
    }

    //导出私钥
    public static void exportPrivateKey(PrivateKey privateKey, String exportFile) throws Exception {
        String encoded = new String(Base64.getEncoder().encode(privateKey.getEncoded()));
        System.out.println("—–BEGIN PRIVATE KEY—–\r\n");
        System.out.println(encoded);
        System.out.println("\r\n—–END PRIVATE KEY—–");
        //FileWriter fw = new FileWriter(exportFile);
        //fw.write("—–BEGIN PRIVATE KEY—–\r\n");  //非必须
        //fw.write(encoded);
        //fw.write("\r\n—–END PRIVATE KEY—–");        //非必须
        //fw.close();
    }

    //导出公钥
    public static void exportPublicKey(PublicKey publicKey, String exportFile) throws Exception {
        String encoded = new String(Base64.getEncoder().encode(publicKey.getEncoded()));
        System.out.println("—–BEGIN PUBLIC KEY—–\r\n");
        System.out.println(encoded);
        System.out.println("\r\n—–END PUBLIC KEY—–");
        //FileWriter fw = new FileWriter(exportFile);
        //fw.write("—–BEGIN PUBLIC KEY—–\r\n");       //非必须
        //fw.write(encoded);
        //fw.write("\r\n—–END PUBLIC KEY—–");     //非必须
        //fw.close();
    }

    /**
     * 私钥签名
     * @param content
     * @return
     * @throws Exception
     */
    public static String sign(String content, PrivateKey privateKey, String sigAlgName) throws Exception {
        //签名的算法
        Signature signature = Signature.getInstance(sigAlgName);
        //通过私钥初始化Signature，签名时用
        signature.initSign(privateKey);
        //指定需要进行签名的内容
        signature.update(content.getBytes());
        //签名
        byte[] result = signature.sign();
        //Base64
        return Base64.getEncoder().encodeToString(result);
        //return new String(result);
    }

    /**
     * 测试公钥验签
     * @throws Exception
     */
    public static  boolean verifySign(String content, String sign, PublicKey publicKey, String sigAlgName) throws Exception {
        Signature signature = Signature.getInstance(sigAlgName);
        //以验签的方式初始化Signature
        signature.initVerify(publicKey);
        //指定需要验证的签名
        signature.update(content.getBytes());
        //进行验签，返回验签结果
        return signature.verify(Base64.getDecoder().decode(sign));
    }

    public static void main(String[] args) throws Exception {

    }

}

