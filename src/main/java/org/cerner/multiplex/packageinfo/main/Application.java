package org.cerner.multiplex.packageinfo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.cerner.multiplex.packageinfo")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
