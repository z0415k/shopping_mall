package com.shopping.mall.pojo;

import com.shopping.mall.enums.CmsResultEnum;
import lombok.Data;

/**
 * 统一响应对象
 *
 * @author zk
 */
@Data
public class CmsResult<T> {

    private int code;
    private int status;
    private String message;
    private T content;

    public CmsResult(int code, String message, T content) {
        this.code = code;
        this.status = code;
        this.message = message;
        this.content = content;
    }

    public CmsResult(CmsResultEnum cmsResultEnum) {
        this.code = cmsResultEnum.getCode();
        this.status = cmsResultEnum.getCode();
        this.message = cmsResultEnum.getMessage();
    }

    public CmsResult(CmsResultEnum cmsResultEnum, T content) {
        this(cmsResultEnum);
        this.content = content;
    }

}
