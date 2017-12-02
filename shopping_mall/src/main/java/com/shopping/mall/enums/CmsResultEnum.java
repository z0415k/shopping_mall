package com.shopping.mall.enums;

/**
 * @author zk
 */
public enum CmsResultEnum {

    OK(0, 0, "ok"),
    NO(1, 1, "no"),
    PRE_SALE_NOT_FOUND(-1, -1, "没有找到此预售!"),
    NO_PERMISSIONS(-2, -2, "没有权限!"),
    FORMAT_FAIL(-3, -3, "数据类型转换失败"),
    FULL_REDUCE_NOT_FOUND(-4, -4, "未找到此满减活动"),
    DETAIL_NOT_FOUND(-5, -5, "未找到");

    private int code;
    private int status;
    private String message;

    CmsResultEnum(int code, int status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
