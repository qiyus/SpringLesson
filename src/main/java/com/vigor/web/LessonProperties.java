package com.vigor.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Vigor on 2017/7/22.
 * 练习属性文件
 */
@Component
public class LessonProperties {
    @Value("${com.vigor.example.name}")
    private String name;

    @Value("${com.vigor.example.title}")
    private String title;

    @Value("${com.vigor.example.content}")
    private String content;

    @Value("${com.vigor.example.value}")
    private String value;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getValue() {
        return value;
    }
}
