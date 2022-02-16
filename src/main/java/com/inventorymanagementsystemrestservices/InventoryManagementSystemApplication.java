package com.inventorymanagementsystemrestservices;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class InventoryManagementSystemApplication {

	private static Logger logger = (Logger) LoggerFactory.getLogger(InventoryManagementSystemApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementSystemApplication.class, args);



		//level

		logger.trace("this is a trace msg");
		logger.debug("this is a debug msg");
		logger.info("this is an info msg");
		logger.warn("this is an warn msg");
		logger.error("this is an error msg");




	}

}
