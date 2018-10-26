package com.fintell.fp.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 13:24 2018/10/24
 **/
@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

}