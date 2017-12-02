package com.shopping.mall.handler;

import com.shopping.mall.exception.ParamException;
import com.shopping.mall.pojo.CmsResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 默认统一异常处理
 *
 * @author chief
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    /**
     * 统一处理exception
     *
     * @param request
     * @param exception
     * @return 自定义返回对象
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CmsResult exceptionHandler(HttpServletRequest request, Exception exception) {
        exception.printStackTrace();
        return new CmsResult(500, exception.getMessage(), joinErrorMessage(request));
    }

    /**
     * 统一处理ParamException
     * @param request
     * @param paramException
     * @return
     */
    @ExceptionHandler(value = ParamException.class)
    @ResponseBody
    public CmsResult paramExceptionHandler(HttpServletRequest request, ParamException paramException) {
        return new CmsResult(400, paramException.getMessage(), joinErrorMessage(request));
    }

    /**
     * 组织具体异常源
     * url : 请求路径
     * method: 请求方式
     * ip : 请求来源
     *
     * @param request httpRequest
     * @return 具体异常源
     */
    private String joinErrorMessage(HttpServletRequest request) {
        return new StringBuilder("url : " + request.getRequestURL().toString() + ", ")
                .append("method : " + request.getMethod()).toString();
    }
}
