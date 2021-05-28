package com.xiaohe66.demo.zookeeper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaohe66
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Object exceptionHandler(RuntimeException e) {

        Map<String, Object> result = new HashMap<>();
        result.put("status", "error");
        result.put("message", e.getMessage());
        return result;
    }

}
