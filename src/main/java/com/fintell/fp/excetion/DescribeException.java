package com.fintell.fp.excetion;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 13:56 2018/10/25
 **/
@Data
@EqualsAndHashCode(callSuper=false)
public class DescribeException extends RuntimeException{

    /**
     * 自定义异常添加状态值，可选
     */
    private String code;

    /**
     * 自定义异常添加业务异常信息
     */
    private String massage;


    public DescribeException(String message) {
        super(message);
        this.massage = message;
    }
}