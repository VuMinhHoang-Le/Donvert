package com.donvert.convert_microservice;

import org.springframework.boot.SpringApplication;

public class TestConvertMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(ConvertMicroserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
