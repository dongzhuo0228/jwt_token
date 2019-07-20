package com.example.jwt_token.exception;

import com.example.jwt_token.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobelException extends BaseController {


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map result(Exception exception) {
        log.info("异常信息defaultMessage={}" , exception.getMessage());
        return failResult(exception.getMessage());
    }
}
