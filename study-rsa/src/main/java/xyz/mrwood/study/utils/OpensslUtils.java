/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.utils;

import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.utils
 * 功能：
 * 时间：2016-07-26 17:25
 * 作者：Mr.Kiwi
 */
public class OpensslUtils {

    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static String sign(String content, String privateKey) {
        String charset = "utf-8";
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decode(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature =
                java.security.Signature.getInstance(SIGN_ALGORITHMS);

            signature.initSign(priKey);
            signature.update(content.getBytes(charset));

            byte[] signed = signature.sign();

            return Base64.encode(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static boolean verify(String content, String sign, String publicKey) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = Base64.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));


            java.security.Signature signature =
                java.security.Signature.getInstance(SIGN_ALGORITHMS);


            signature.initVerify(pubKey);
            signature.update(content.getBytes("utf-8"));

            byte[] signBytes = Base64.decode(sign);
            System.out.println(signBytes.length);
            boolean bverify = signature.verify(signBytes);
            return bverify;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
}
