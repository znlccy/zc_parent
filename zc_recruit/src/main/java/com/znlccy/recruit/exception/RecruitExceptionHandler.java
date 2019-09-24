package com.znlccy.recruit.exception;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: znlccy
 * @version: 1.0.0
 * @date: 2019-09-21-21:37
 * @remark:
 */
@RestControllerAdvice
public class RecruitExceptionHandler {

    @ExceptionHandler
    public Result exception(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}
