package myTest;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import sun.misc.BASE64Encoder;

/**
 * 从keystore中获取privateKey和publicKey
 * @author Stephen Cai
 * @date 2018-05-07 13:40
 */
public class KeystoreTest {
     private static String getPublicKey(String cerPath) throws Exception {
        CertificateFactory certificatefactory = CertificateFactory.getInstance("X.509");
        FileInputStream fis = new FileInputStream(cerPath);
        X509Certificate Cert = (X509Certificate) certificatefactory.generateCertificate(fis);
        PublicKey pk = Cert.getPublicKey();
        String publicKey = new BASE64Encoder().encode(pk.getEncoded());
        return publicKey;
    }

    private static String getPrivateKey(String storePath, String alias, String storePw, String keyPw) throws Exception {
        FileInputStream is = new FileInputStream(storePath);
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(is, storePw.toCharArray());
        is.close();
        PrivateKey key = (PrivateKey) ks.getKey(alias, keyPw.toCharArray());
        String privateKey = new BASE64Encoder().encode(key.getEncoded());
        return privateKey;
    }

    public static void main(String[] args)
        throws Exception {
        //读取keystore文件到KeyStore对象
        String storePath = "/Users/caifeng/Downloads/test/test.keystore";
        String cerPath = "/Users/caifeng/Downloads/test/test_pub_cer.cer";

        FileInputStream in = new FileInputStream(storePath);
        KeyStore ks = KeyStore.getInstance("JKS");// JKS: Java KeyStoreJKS，可以有多种类型
        ks.load(in, "123456".toCharArray());
        in.close();

        //从keystore中读取证书和私钥
        String alias = "SEC_TEST";  // 记录的别名
        String pswd = "123456";   // 记录的访问密码
        java.security.cert.Certificate cert = ks.getCertificate(alias);
        PublicKey publicKey = cert.getPublicKey();
        PrivateKey privateKeyprivateKey = (PrivateKey) ks.getKey(alias, pswd.toCharArray());
        System.out.println("privateKey");
        System.out.println(getPrivateKey(storePath,alias,pswd,pswd));
        System.out.println("publicKey");
        System.out.println(getPublicKey(cerPath));
    }
}
