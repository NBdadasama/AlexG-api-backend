package com.yupi.springbootinit.utils;


import cn.hutool.crypto.digest.DigestUtil;

public class SignUtil {
    public static String getSign(String body, String secretKey) {
        String content = body + "." + secretKey;
        return DigestUtil.md5Hex(content);
}
}
