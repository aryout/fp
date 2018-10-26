package com.fintell.fp.excetion;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 14:02 2018/10/25
 **/
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 系统错误，记录在log中
     * @param ex
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JSONObject sysExceptionGet(Exception ex){
        if (ex instanceof DescribeException){
            return descExceptionGet((DescribeException) ex);
        }
        log.error("【运行异常】{}",ex);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message","系统错误");
        jsonObject.put("code","-1");
        return jsonObject;
    }

    /**
     * 已知错误，记录在log中
     * @param de
     * @return
     */
    @ExceptionHandler(value = DescribeException.class)
    @ResponseBody
    public JSONObject descExceptionGet(DescribeException de) {
        log.error("【业务异常】{}",de);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message",de.getMassage());
        jsonObject.put("code",de.getCode());
        return jsonObject;
    }
}