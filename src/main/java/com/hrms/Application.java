package com.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.ComponentScan;
=======
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
>>>>>>> 66af355697a837da3cc80d0ae79420235afc5300

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
