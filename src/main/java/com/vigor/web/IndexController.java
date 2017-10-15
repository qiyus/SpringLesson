package com.vigor.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vigor on 2017/10/15.
 * thymeleaf 练习
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String startBlog(ModelMap map) {
        map.addAttribute("subject", "thymeleaf test ok");
        return "index";
    }
}
