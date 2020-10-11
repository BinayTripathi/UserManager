package com.binay.userdetails.configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExecutorServiceConfig {
	
	@Bean
	public ExecutorService createExecutorService( ) {
		ExecutorService executorService = Executors.newWorkStealingPool();
		return executorService;
		
	}

}
