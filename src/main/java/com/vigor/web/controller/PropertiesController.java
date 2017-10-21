package com.vigor.web.controller;

import com.vigor.web.VigorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vigor on 2017/7/21.
 * Hello word
 */
@RestController
public class PropertiesController {
    @Value("${com.vigor.example.name}")
    String name;

    @Autowired
    VigorProperties properties;

    /**
     * 读取属性内容
     * @return vigor在做的事。
     */
    @RequestMapping(value = "/vigor", method = RequestMethod.GET)
    public String helloContent() {
        return name + properties.getContent();
    }
}
