package com.autodetection.appConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@ComponentScan(basePackages = "com.autodetection.appconfig")
public class AppConfig {

	/*
	 * @Bean public Region getRegion(){ return new Region(); }
	 * 
	 * @Bean public Country getCountry(){ return new Country(); }
	 */
}
