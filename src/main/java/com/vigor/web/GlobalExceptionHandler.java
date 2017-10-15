package com.vigor.web;

import com.vigor.web.domain.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vigor on 2017/10/15.
 * 异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        ErrorInfo<String> json = new ErrorInfo<>();
        json.setCode(e.hashCode());
        json.setMessage(e.getMessage());
        json.setData(e.getLocalizedMessage());
        return json;
    }
}
