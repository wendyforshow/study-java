package xyz.mrwood.study.utils;

import org.testng.annotations.Test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import static org.testng.Assert.*;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.utils
 * 功能：
 * 时间：2016-07-21 15:18
 * 作者：Mr.Kiwi
 */
public class RSACoderTest {

    @Test
    public void testGetKeys(){

        try {
            Map<String, Object> stringObjectMap = RSACoder.initKey();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) stringObjectMap.get(RSACoder.PRIVATE_KEY);
            RSAPublicKey rsaPublicKey = (RSAPublicKey) stringObjectMap.get(RSACoder.PUBLIC_KEY);

            String privateKey = RSACoder.getPrivateKey(stringObjectMap);
            String publicKey = RSACoder.getPublicKey(stringObjectMap);

            System.err.println("prikey = " + privateKey);
            System.err.println("pubkey = " + publicKey);

            String str = "abcde";
            String sign = RSACoder.sign(str.getBytes(), privateKey);

            System.err.println("sign == " + sign);
            boolean verify = RSACoder.verify(str.getBytes(), publicKey, sign);

            System.err.println("签名验证：" + verify);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
