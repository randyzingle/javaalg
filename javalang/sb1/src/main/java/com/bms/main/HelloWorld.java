package com.bms.main;

import java.util.Arrays;

import org.joda.time.LocalTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloWorld {
	
	private Greeter greeter = new Greeter();
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return greeter.sayHello();
	}

	public static void main(String[] args) {
		LocalTime lt = new LocalTime();
		System.out.println("The current local time is: " + lt.toDateTimeToday());
		HelloWorld hw = new HelloWorld();
		System.out.println(hw.greeter.sayHello());
		ApplicationContext ctx = SpringApplication.run(HelloWorld.class, args);
		
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String s: beanNames) {
			System.out.println(s);
		}
	}

}
