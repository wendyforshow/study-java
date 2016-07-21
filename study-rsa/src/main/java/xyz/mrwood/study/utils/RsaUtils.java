package xyz.mrwood.study.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RsaUtils {

    public static PublicKey pbkey = null;
    public static PrivateKey prkey = null;
    public static void main(String[] args) {
        //Rsa密码初始化
        generRSAKey();
        //公钥加密
        byte[] cipher = encryptByPublicKey("abc".getBytes(), pbkey);
        //私钥解密
        byte[] clear  =decryptByPrivateKey(cipher ,prkey);

        try {
            System.out.println(new String(clear, "GB2312"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //签名
        byte[] byts = sign(prkey, "a123".getBytes());
        //验证签名
        System.out.println(verifySign(pbkey, "a123", byts));
    }

    /**
     * 私钥签名
     *
     * @param privateKey
     *            私钥
     * @param in
     * @return
     */
    public static byte[] sign(PrivateKey privateKey, byte[] in) {
        byte[] signdata = null;
        System.out.println("开始数字签名：");
        try {
            Signature signa = Signature.getInstance("MD5WithRSA");
            // KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            // PrivateKey privateKey = keyFactory
            // .generatePrivate(new X509EncodedKeySpec(key.getBytes()));
            // 初始化签名对象
            signa.initSign(privateKey);
            signa.update(in);
            // 执行签名方法，得到数据
            signdata = signa.sign();
        } catch (Exception e) {
            System.err.println("数字签名出现异常!");
            e.printStackTrace();
        }
        return signdata;
    }

    /**
     * 公钥验证签名
     *
     * @param publickey
     *            公钥
     * @param plainText
     *            原文
     * @param signText
     *            密文
     * @return
     */
    public static boolean verifySign(PublicKey publickey, String plainText,
            byte[] signText) {
        boolean flag = false;
        // TODO 需要取对方公钥
        System.out.println("验证数据签名开始：");
        try {
            Signature signa = Signature.getInstance("MD5WithRSA");
            // KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            // PublicKey publickey = keyFactory
            // .generatePublic(new X509EncodedKeySpec(key.getBytes()));
            // 初始化签名对象
            signa.initVerify(publickey);
            // 传入被验证数据
            signa.update(plainText.getBytes());
            // 利用签名数据确定是否可信
            flag = signa.verify(signText);
            if (flag == true) {
                System.out.println("数据签名正确!");
            }
        } catch (Exception e) {
            System.err.println("验证数据签名出现异常!");
        }
        return flag;
    }

    /**
     * 生成RSA密钥对
     *
     * @param pub
     * @param pri
     */
    public static void generRSAKey() {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            // 密钥的长度
            kpg.initialize(1024);
            KeyPair kp = kpg.genKeyPair();
            pbkey = kp.getPublic();
            prkey = kp.getPrivate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * <P>
     * 私钥解密
     * </p>
     *
     * @param encryptedData 已加密数据
     * @param privateKey 私钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] encryptedData, PrivateKey privateKey)
             {
        //byte[] keyBytes = Base64Utils.decode(privateKey);
//        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
//        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
       byte[] decryptedData= null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
                int inputLen = encryptedData.length;
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                int offSet = 0;
                byte[] cache;
                int i = 0;
                // 对数据分段解密
                while (inputLen - offSet > 0) {
                    if (inputLen - offSet > 128) {
                        cache = cipher.doFinal(encryptedData, offSet, 128);
                    } else {
                        cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                    }
                    out.write(cache, 0, cache.length);
                    i++;
                    offSet = i * 128;
                }
                decryptedData = out.toByteArray();
                out.close();
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return decryptedData;
    }



    /**
     * <p>
     * 公钥加密
     * </p>
     *
     * @param data 源数据
     * @param publicKey 公钥(BASE64编码)
     * @return
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, PublicKey publicKey)
              {
//        byte[] keyBytes = Base64Utils.decode(publicKey);
//        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
//        Key publicK = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        byte[] encryptedData = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > 117) {
                    cache = cipher.doFinal(data, offSet, 117);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * 117;
            }
            encryptedData = out.toByteArray();
            out.close();
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encryptedData;
    }

}
