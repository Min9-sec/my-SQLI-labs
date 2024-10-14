package com.ming.exception;

import com.ming.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 */
@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)      // 配置处理异常的类型，Exception表示处理所有异常
    public Result exceptionHandler(Exception e){
        return Result.error(e.getMessage());
    }
}
