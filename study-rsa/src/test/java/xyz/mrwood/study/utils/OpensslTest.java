/**
 * Copyright (c) 2016, 791650277@qq.com(Mr.kiwi) All Rights Reserved.
 */
package xyz.mrwood.study.utils;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.testng.annotations.Test;
import sun.misc.BASE64Decoder;

/**
 * 项目：study
 * 包名：xyz.mrwood.study.utils
 * 功能：
 * 时间：2016-07-26 17:28
 * 作者：Mr.Kiwi
 */
public class OpensslTest {

    private String prikey8 = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMhkSaGD5SsXdBcP\n"
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
        + "3RRowdzDfsl4TY3irxhYgECz131OLC87kSdSii/7hIjyktsLme/G5xr/pIh3e75B\n" + "bwFYr2siR1L4Ak0=";

    private String prikey = "MIICXQIBAAKBgQDIZEmhg+UrF3QXD9X0uUPPHdyyi5niADHyvwodXHQnlLiQYVvj\n"
        + "GHV6vMQkP6xI+oe6Wu2BNNl1cUa6F2+JIDD+LkQrZHT+dJWB6vleC293lSjsm3mp\n"
        + "4j4KuoEt9B5GZSHO8nRlP232M1Qm2BsrYHTD6aZ570xGI+ZQnfeFyQzXEwIDAQAB\n"
        + "AoGAN1s829lLnTPFZfmB6TCkgrqFFO1rfPsA0UXkzWeUzrpOodPDRmCjU1yB8mGE\n"
        + "fkR26gvkQCURTVgVaaK/tOmnnpHiSHufYFiH94DmaoHbeOTlr+IdG4zxII/r0XTT\n"
        + "b1mX3YZqYBzJKBmQFZsdPn4mSNX9iMx2JF/b8RGCE+Z5REECQQD70Rven+5fbED6\n"
        + "dWwD5fGUcW2zg4ejtbqkAEnPrEjJYnr7XB71tT+EUSmjpMpyID3ZNrSLgoyI+gr2\n"
        + "stm92JKnAkEAy7h8Q8UOYxlqcZ6YNHnfl4gHcyWQ2ckrFNuY59rMNxP1FA5XJ8Qu\n"
        + "5Wv65bAMmwDTfmqVn4hT0llsfbUKfqGBtQJBAJNnjbPc1LGg8cxqzebeRHLLjxbF\n"
        + "CLJJH87+qDZbuGPCNRFMlIbqKRswU3qKbUMvImUzQ65iphdMnvxYJ2OdEgMCQQCw\n"
        + "QQwaIhqBeNLUPI+ZDzx4wPMZF45MLrU8VYXkSzPWD0lBseqL+DtOuO6Y3Ij7bmqM\n"
        + "/DA5l1xWKJIp7IGI77jlAkA9K9Qpcd0UaMHcw37JeE2N4q8YWIBAs9d9TiwvO5En\n"
        + "Uoov+4SI8pLbC5nvxuca/6SId3u+QW8BWK9rIkdS+AJN";

    private String pubkey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIZEmhg+UrF3QXD9X0uUPPHdyy\n"
        + "i5niADHyvwodXHQnlLiQYVvjGHV6vMQkP6xI+oe6Wu2BNNl1cUa6F2+JIDD+LkQr\n"
        + "ZHT+dJWB6vleC293lSjsm3mp4j4KuoEt9B5GZSHO8nRlP232M1Qm2BsrYHTD6aZ5\n"
        + "70xGI+ZQnfeFyQzXEwIDAQAB";

    private String pubkey1 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMoA/qTdJ3LS2w/42UU339HSkH\n"
        + "GVGJThcRb6QsFZ/0Vk1cjWQNzyerwyNyNbLeyfrdY/QKv3VTPlRAJ+wqansoxGO5\n"
        + "5Nw/G3yVVulcTI64UKk44t8Xg2WRUgNvNl5ih01udniVY9VT3HW7QIiRC4ywxSyP\n"
        + "mkTkOpBY3nVM6PNK4wIDAQAB";

    private String sign1 = "X3hFQ5r0CdJ82KZQRKSUW3HAjZTN80zw7nNyC7ixCvg15v5/tC6XcLppn2InBHKglT6cLRen2J+e0WaKIWdZxyh85gTutxgxEJY3Buhd7yioDXc1uVv/M9ZCVVb5Y1SAkErfvDeXKUTNccehOIgjIG4ZYuv4S0zCCBgrryy4AcQ=";

    @Test
    public void testSign(){

        System.err.println(OpensslUtils.verify("123456",sign1, pubkey1));

//        String sign = OpensslUtils.sign("12345", prikey8);

//        System.err.println(sign);

//        System.err.println(OpensslUtils.verify("12345", sign, pubkey));
    }

}
