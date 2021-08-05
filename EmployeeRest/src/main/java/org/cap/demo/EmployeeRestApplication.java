package org.cap.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;


@EnableJdbcHttpSession
@SpringBootApplication
public class EmployeeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApplication.class, args);
	}

}
