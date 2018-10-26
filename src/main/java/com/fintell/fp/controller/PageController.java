package com.fintell.fp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 20:50 2018/10/24
 **/
@Controller
public class PageController {

    @RequestMapping("/")
    public ModelAndView index_mv() {
        return  new ModelAndView("index");
    }

    @RequestMapping("/index")
    public String index_string() {
        return  "index";
    }

    @RequestMapping(value = "/404")
    public ModelAndView notFound(){
        return new ModelAndView("errorPage/404");
    }
}
