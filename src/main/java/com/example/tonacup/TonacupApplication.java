package com.example.tonacup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.example.tonacup.controller"})
@SpringBootApplication
public class TonacupApplication {

	public static void main(String[] args) {
		SpringApplication.run(TonacupApplication.class, args);
	}

}
