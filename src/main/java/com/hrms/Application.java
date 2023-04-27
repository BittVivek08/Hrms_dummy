package com.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.hrms"})
@ComponentScan("com.hrms.beans")
=======
<<<<<<< HEAD
import org.springframework.context.annotation.ComponentScan;
=======
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
>>>>>>> 66af355697a837da3cc80d0ae79420235afc5300

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
>>>>>>> 583b3706a9b47173e4d2ee1a313ad803c58da7a4
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
