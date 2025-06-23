package com.btspring.btspring2;

import com.btspring.btspring2.util.BCriptUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Btspring2Application {

	public static void main(String[] args) {
		SpringApplication.run(Btspring2Application.class, args);
	}

}
