package com.truxxkart.deliveryservice_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class DeliveryserviceV1Application {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryserviceV1Application.class, args);
	}

}
