package com.zx.exception;

import com.zx.enums.ResultEnum;

/**
 * Created by 97038 on 2017-04-03.
 */
public class GirlException extends RuntimeException {
    private Integer code;
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
