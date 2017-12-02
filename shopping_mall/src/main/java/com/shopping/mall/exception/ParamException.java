package com.shopping.mall.exception;


/**
 * 参数异常
 *
 * @author chief
 */
public class ParamException extends RuntimeException {

    public ParamException() {
    }

    public ParamException(String msg) {
        super(msg);
    }

    public static ParamException paramNotNull(String paramName) {
        return new ParamException(paramName + "不能为空");
    }

    public static ParamException paramNotNullOrEmpty(String paramName) {
        return new ParamException(paramName + "不能为空");
    }

    public static ParamException paramNotNullOrZero(String paramName) {
        return new ParamException(paramName + "不能为空或者不能为0");
    }

    public static ParamException formatError(String paramName, String paramValue) {
        return new ParamException(paramName + "格式错误,数据值为:" + paramValue);
    }

    public static ParamException illegalArguments(String paramName) {
        return new ParamException(paramName + "是非法的参数");
    }
}
