package com.vigor.web;

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
    /**
     * hello word
     * @return word
     */
    @RequestMapping("/hello")
    public String helloWord() {
        return "Hello word!";
    }

    /**
     * hello name
     * @return name
     */
    @RequestMapping(value = "/hello/", method = RequestMethod.GET)
    public String helloName(@RequestParam("name") String name) {
        return "Hello " + name;
    }
}
