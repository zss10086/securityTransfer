package com.javarice.sec.apis.result;

import java.io.Serializable;

/**
 * @author ZhouSs
 * @Mail: zhoushengshuai@ufenqi.com
 * @date:2017/8/14 下午3:13
 * @version: 1.0
 **/

public class BaseResult<T> implements Serializable {
    private static final long serialVersionUID = -5512178961566392313L;
    private static final String OK_MESSAGE = "OK";
    private int code = 200;
    private String message;
    private T data;

    public BaseResult() {
        this.code = 200;
        this.message = "OK";
    }

    public BaseResult(T data) {
        this.data = data;
        this.code = 200;
        this.message = "OK";
    }

    public BaseResult(T data, int code, String message) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return "BaseResult{code=" + this.code + ", message=\'" + this.message + '\'' + ", data=" + this.data + '}';
    }
}