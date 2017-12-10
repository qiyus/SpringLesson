package com.vigor.web.controller;

import com.vigor.web.properties.VigorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;

/**
 * Created by Vigor on 2017/10/15.
 * thymeleaf 练习
 */
@Controller
public class WebController {

    @Autowired
    VigorProperties properties;

    @RequestMapping("/")
    public String home(ModelMap map) {
        map.addAttribute("start", "/hello");
        return "home";
    }

    @RequestMapping("/hello")
    public String hello(ModelMap map) {
        map.addAttribute("name", properties.getName());
        return "hello";
    }
}
