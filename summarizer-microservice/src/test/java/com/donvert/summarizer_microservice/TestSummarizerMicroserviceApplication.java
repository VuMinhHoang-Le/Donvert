package com.donvert.summarizer_microservice;

import org.springframework.boot.SpringApplication;

public class TestSummarizerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(SummarizerMicroserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
