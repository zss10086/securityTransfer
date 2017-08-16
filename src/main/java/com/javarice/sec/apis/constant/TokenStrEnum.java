package com.javarice.sec.apis.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhouSs
 * @Mail: zhoushengshuai@ufenqi.com
 * @date:2017/6/23 下午6:13
 * @version: 1.0
 **/
public enum TokenStrEnum {

    交易中心("1098000","123456"),
    海航("1098777","789012");

    private String codeNum;
    private String secretKey;

    TokenStrEnum(String codeNum, String secretKey) {
        this.secretKey = secretKey;
        this.codeNum = codeNum;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
    }

    public static Map<String, String> toMap() {
        TokenStrEnum[] ary = TokenStrEnum.values();
        Map<String, String> enumMap = new HashMap<String, String>();
        for (int num = 0; num < ary.length; num++) {
            String secretKey = ary[num].getSecretKey();
            String codeNum = ary[num].getCodeNum();
            enumMap.put(codeNum, secretKey);
        }
        return enumMap;
    }

    public static boolean contain(String codeNum) {
        if (codeNum == null) {
            return false;
        }

        Map<String, String> map = toMap() ;
        return map.containsKey(codeNum);
    }



    public static String getSecretKeyByCodeNum(String codeNum) {
        TokenStrEnum[] ary = TokenStrEnum.values();
        for (int num = 0; num < ary.length; num++) {
            if (codeNum.equals(ary[num].getCodeNum())) {
               return ary[num].getSecretKey();
            }
        }
        return null;
    }
}
