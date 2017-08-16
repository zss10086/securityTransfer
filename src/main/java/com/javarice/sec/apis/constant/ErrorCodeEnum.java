package com.javarice.sec.apis.constant;

/**
 * @author ZhouSs
 * @Mail: zhoushengshuai@ufenqi.com
 * @date:2017/8/16 下午5:06
 * @version: 1.0
 **/
public enum ErrorCodeEnum {
    系统异常(999, "系统繁忙,请稍后重试!"),
    系统提醒(888, "系统提醒"),
    系统提示刷新(886, "系统提示刷新"),
    系统提示(887, "系统提示"),
    参数异常(700, "参数异常."),
    参数丢失(710, "参数丢失."),
    参数为空(721, "参数为空."),
    参数不为空(722, "参数不为空."),
    非法参数(720, "参数非法"),
    获取验证码异常(600, "获取验证码异常,请稍后重试."),
    校验验证码异常(601, "校验验证码异常,请稍后重试."),
    获取验证码冻结(610, "获取验证码冻结"),
    获取验证码冻结3H(611, "您当前频繁获取验证码,请3小时后重新获取"),
    获取验证码冻结60s(612, "您当前频繁获取验证码,请60秒后重新获取"),
    验证码错误(620, "验证码错误,请重新输入"),
    验证码过期(621, "验证码过期,请重新获取"),
    验证码错误次数过多(622, "验证码输入次数过多，请重新获取"),
    用户不存在(800, "用户不存在");

    private int code;
    private String message;

     ErrorCodeEnum(int code, String message) {
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

    public static boolean contain(Integer value) {
        if(value == null) {
            return false;
        } else {
            ErrorCodeEnum[] values = values();
            ErrorCodeEnum[] arr$ = values;
            int len$ = values.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                ErrorCodeEnum sexEnum = arr$[i$];
                if(sexEnum.code == value.intValue()) {
                    return true;
                }
            }

            return false;
        }
    }
}
