package com.ty.FoodAppHelper;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ty")
public class Helper {
	@Bean
    public EntityManagerFactory m1() {
    	return Persistence.createEntityManagerFactory("vikas") ;    
    }
	
}
