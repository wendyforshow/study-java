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
//            Map<String, Object> stringObjectMap = RSACoder.initKey();
//            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) stringObjectMap.get(RSACoder.PRIVATE_KEY);
//            RSAPublicKey rsaPublicKey = (RSAPublicKey) stringObjectMap.get(RSACoder.PUBLIC_KEY);
//
//            String privateKey = RSACoder.getPrivateKey(stringObjectMap);
//            String publicKey = RSACoder.getPublicKey(stringObjectMap);
//
//            System.err.println("prikey = " + privateKey);
//            System.err.println("pubkey = " + publicKey);

            String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMhkSaGD5SsXdBcP\n"
                + "1fS5Q88d3LKLmeIAMfK/Ch1cdCeUuJBhW+MYdXq8xCQ/rEj6h7pa7YE02XVxRroX\n"
                + "b4kgMP4uRCtkdP50lYHq+V4Lb3eVKOybeaniPgq6gS30HkZlIc7ydGU/bfYzVCbY\n"
                + "GytgdMPppnnvTEYj5lCd94XJDNcTAgMBAAECgYA3Wzzb2UudM8Vl+YHpMKSCuoUU\n"
                + "7Wt8+wDRReTNZ5TOuk6h08NGYKNTXIHyYYR+RHbqC+RAJRFNWBVpor+06aeekeJI\n"
                + "e59gWIf3gOZqgdt45OWv4h0bjPEgj+vRdNNvWZfdhmpgHMkoGZAVmx0+fiZI1f2I\n"
                + "zHYkX9vxEYIT5nlEQQJBAPvRG96f7l9sQPp1bAPl8ZRxbbODh6O1uqQASc+sSMli\n"
                + "evtcHvW1P4RRKaOkynIgPdk2tIuCjIj6Cvay2b3YkqcCQQDLuHxDxQ5jGWpxnpg0\n"
                + "ed+XiAdzJZDZySsU25jn2sw3E/UUDlcnxC7la/rlsAybANN+apWfiFPSWWx9tQp+\n"
                + "oYG1AkEAk2eNs9zUsaDxzGrN5t5EcsuPFsUIskkfzv6oNlu4Y8I1EUyUhuopGzBT\n"
                + "eoptQy8iZTNDrmKmF0ye/FgnY50SAwJBALBBDBoiGoF40tQ8j5kPPHjA8xkXjkwu\n"
                + "tTxVheRLM9YPSUGx6ov4O0647pjciPtuaoz8MDmXXFYokinsgYjvuOUCQD0r1Clx\n"
                + "3RRowdzDfsl4TY3irxhYgECz131OLC87kSdSii/7hIjyktsLme/G5xr/pIh3e75B\n"
                + "bwFYr2siR1L4Ak0=";
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIZEmhg+UrF3QXD9X0uUPPHdyy\n"
                + "i5niADHyvwodXHQnlLiQYVvjGHV6vMQkP6xI+oe6Wu2BNNl1cUa6F2+JIDD+LkQr\n"
                + "ZHT+dJWB6vleC293lSjsm3mp4j4KuoEt9B5GZSHO8nRlP232M1Qm2BsrYHTD6aZ5\n"
                + "70xGI+ZQnfeFyQzXEwIDAQAB";

            String str = "abcde";
            String sign = RSACoder.sign(str.getBytes(), privateKey);

            System.err.println("sign == " + sign);
            boolean verify = RSACoder.verify(str.getBytes(), publicKey, sign.substring(1));

            System.err.println("签名验证：" + verify);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
