package com.truxxkart.adminservice_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AdminserviceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(AdminserviceV1Application.class, args);
	}

}
