package com.javarice.sec.apis.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZhouSs
 * @Mail: zhoushengshuai@ufenqi.com
 * @date:2017/6/24 下午7:00
 * @version: 1.0
 **/
public class DataTransferReceiptDTO implements Serializable {

    private static final long serialVersionUID = -2177629799136574931L;
    private int resultCode = 200;
    private List<Long> duplicateTradeIdList;
    private List<Long> errorTradeIdList;

    public DataTransferReceiptDTO() {

    }

    public DataTransferReceiptDTO(int resultCode, List<Long> duplicateTradeIdList, List<Long> errorTradeIdList) {
        this.duplicateTradeIdList = duplicateTradeIdList;
        this.errorTradeIdList = errorTradeIdList;
        this.resultCode = resultCode;
    }


    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public List<Long> getDuplicateTradeIdList() {
        return duplicateTradeIdList;
    }

    public void setDuplicateTradeIdList(List<Long> duplicateTradeIdList) {
        this.duplicateTradeIdList = duplicateTradeIdList;
    }

    public List<Long> getErrorTradeIdList() {
        return errorTradeIdList;
    }

    public void setErrorTradeIdList(List<Long> errorTradeIdList) {
        this.errorTradeIdList = errorTradeIdList;
    }
}
