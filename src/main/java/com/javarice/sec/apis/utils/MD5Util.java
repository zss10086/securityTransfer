package com.javarice.sec.apis.utils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ZhouSs
 * @Mail: zhoushengshuai@ufenqi.com
 * @date:2017/8/16 下午5:05
 * @version: 1.0
 **/
public class MD5Util {
    public MD5Util() {
    }

    public static String getMD5(String srcStr) {
        return !(srcStr == null || srcStr.length()== 0)?getMD5(srcStr, "UTF-8"):null;
    }

    public static String getMD5(String srcStr, String encoding) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            byte[] e = srcStr.getBytes(encoding);
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(e);
            byte[] tmp = md.digest();
            char[] chars = new char[32];
            int k = 0;

            for(int i = 0; i < 16; ++i) {
                byte byte0 = tmp[i];
                chars[k++] = hexDigits[byte0 >>> 4 & 15];
                chars[k++] = hexDigits[byte0 & 15];
            }

            return new String(chars);
        } catch (NoSuchAlgorithmException var10) {
            var10.printStackTrace();
        } catch (UnsupportedEncodingException var11) {
            var11.printStackTrace();
        }

        return null;
    }
}
