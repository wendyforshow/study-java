package xyz.mrwood.study.utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.*;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.utils
 * 功能：
 * 时间：2016-07-21 10:28
 * 作者：Mr.Kiwi
 */
public class RSAUtilTest {

    private String publicKey;
    private String privateKey;

    @BeforeMethod
    public void testGeneratorKeyPair() {

        Map<String, String> keyPair = RSAUtil.generateKeyPair();

        if (keyPair != null) {

            publicKey = keyPair.get("publicKey");
            privateKey = keyPair.get("privateKey");
        }

    }

    @Test
    public void testRsa(){

        String str = "这是一个要加密的字符串";

        System.err.println(privateKey);
        System.err.println(publicKey);

        // 公钥加密
        String decrypt = RSAUtil.encrypt(publicKey, str);
        // 私钥解密
        String encrypt = RSAUtil.decrypt(privateKey, decrypt);

        assertEquals(str.equals(encrypt), true, "私钥解密后应与加密前一致！");

    }




}
