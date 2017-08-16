package com.javarice.sec.apis.post;


import java.io.Serializable;

/**
 * @author ZhouSs
 * @Mail: zhoushengshuai@ufenqi.com
 * @date:2017/6/23 下午3:50
 * @version: 1.0
 **/
public class SingleMsgPost implements Serializable {
    private static final long serialVersionUID = 1118174192625606176L;

    /**
     *  要传输的数据MD5
     */
    private String dataMD5;
    /**
     * 数据的总条数
     */
    private Integer totalAmount;
    /**
     *  传输时间  时间戳
     */
    private Long transferTime;
    /**
     *  验证 MD5(密钥串儿 + 时间戳)
     */
    private String token;
    /**
     *  数据方
     */
    private String codeNum;


    private MessgagePost messgagePost;

    public String getDataMD5() {
        return dataMD5;
    }

    public void setDataMD5(String dataMD5) {
        this.dataMD5 = dataMD5;
    }

    public Long getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Long transferTime) {
        this.transferTime = transferTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public MessgagePost getMessgagePost() {
        return messgagePost;
    }

    public void setMessgagePost(MessgagePost messgagePost) {
        this.messgagePost = messgagePost;
    }
}
