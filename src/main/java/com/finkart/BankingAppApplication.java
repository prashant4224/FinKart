package com.finkart;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author PRASHANT
 * The Class BankingAppApplication.
 */
@Slf4j
@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner{

	@Autowired
	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(allBeanNames);
		/*for (String beanName : allBeanNames) {
			log.info("beanName: ", beanName);
		}*/
	}

}
