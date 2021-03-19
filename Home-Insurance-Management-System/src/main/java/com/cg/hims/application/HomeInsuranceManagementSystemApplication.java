package com.cg.hims.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = "com.cg.hims")
@EntityScan(basePackages = "com.cg.hims.entities")
@EnableJpaRepositories(basePackages = "com.cg.hims.repository")
public class HomeInsuranceManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeInsuranceManagementSystemApplication.class, args);
	}

}
