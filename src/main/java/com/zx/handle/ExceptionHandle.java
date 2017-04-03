package com.zx.handle;

import com.zx.dto.Result;
import com.zx.enums.ResultEnum;
import com.zx.exception.GirlException;
import com.zx.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        //这样就可以区分系统异常和自己包装的异常了
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),e.getMessage());
        }else{
            logger.error("【系统异常】{}",e);
            return ResultUtil.error(ResultEnum.UNKONW_ERROR);
        }
    }
}
