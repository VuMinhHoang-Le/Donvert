package com.donvert.download_microservice;

import org.springframework.boot.SpringApplication;

public class TestDownloadMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(DownloadMicroserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
