package com.matthes.springdemo;

import com.matthes.springdemo.hotdog.Hotdog;
import com.matthes.springdemo.hotdog.HotdogTester;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {

		// HotdogTester hotdogTester = new HotdogTester();
		// System.out.println("hotdogTester: " + hotdogTester);
		ApplicationContext apc = SpringApplication.run(SpringdemoApplication.class, args);

		/*
		for(String s : apc.getBeanDefinitionNames()) {
			System.out.println(s);
		}
		 */

	}



}
