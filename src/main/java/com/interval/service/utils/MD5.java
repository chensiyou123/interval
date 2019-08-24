package com.interval.service.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

public class MD5 {

    /**
     * md5加密
     * @param str 需要加密的字符串
     * @return
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b1 = md.digest(str.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b1);
        } catch(Exception e) {
            return null;
        }
    }
}
