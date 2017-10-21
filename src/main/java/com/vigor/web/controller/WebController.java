package com.vigor.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vigor on 2017/10/15.
 * thymeleaf 练习
 */
@Controller
public class WebController {

    @RequestMapping("/")
    public String hello(ModelMap map) {
        map.addAttribute("start", "/hello");
        return "home";
    }
}
