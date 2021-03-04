package com.hfl.crm.handler;

import com.hfl.crm.exception.LoginException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 控制器增强类（添加全局异常处理）
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    //登录异常处理
    @ExceptionHandler(value = LoginException.class)
    @ResponseBody
    public Map loginException(Exception e){

        Map map=new HashMap();
        map.put("success",false);
        map.put("msg",e.getMessage()+"!!!");
        return map;
    }

}
