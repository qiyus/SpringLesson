package com.vigor.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Vigor on 2017/7/21.
 * Hello word
 */
@RestController
public class HelloController {

    @Autowired
    private LessonProperties properties;

    /**
     * hello word
     * @return word
     */
    @RequestMapping("/hello")
    public String helloWord() {
        return "Hello world!";
    }

    /**
     * hello name
     * @return name
     */
    @RequestMapping(value = "/hello/", method = RequestMethod.GET)
    public String helloName(@RequestParam("name") String name) {
        return "Hello " + name;
    }

    /**
     * 读取属性内容
     * @return vigor在做的事。
     */
    @RequestMapping(value = "/hello/vigor", method = RequestMethod.GET)
    public String helloContent() {
        return properties.getContent();
    }
}
