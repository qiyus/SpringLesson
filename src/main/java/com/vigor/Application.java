package com.vigor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@CrossOrigin(origins = "http://www.xxx.com", methods = {RequestMethod.GET, RequestMethod.POST})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
