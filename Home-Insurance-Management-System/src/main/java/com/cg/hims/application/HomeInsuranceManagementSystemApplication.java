package com.cg.hims.application;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.function.Predicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;
@SpringBootApplication(scanBasePackages = "com.cg.hims")
@EntityScan(basePackages = "com.cg.hims.entities")
@EnableJpaRepositories(basePackages = "com.cg.hims.repository")
@EnableOpenApi
public class HomeInsuranceManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeInsuranceManagementSystemApplication.class, args);
	}
	@Bean
	  public Docket openApiTransactionStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-transaction-management")
	        .select()
	        .paths(transactionPaths())
	        .build();
	  }

	  private Predicate<String> transactionPaths() {
	    return regex(".*/transaction/.*");
	  }
	  
	  @Bean
	  public Docket openApiPolicyStore() {
	    return new Docket(DocumentationType.OAS_30)
	        .groupName("open-api-policy-management")
	        .select()
	        .paths(policyPaths())
	        .build();
	  }

	  private Predicate<String> policyPaths() {
	    return regex(".*/policy/.*");
	  }
	  

}
