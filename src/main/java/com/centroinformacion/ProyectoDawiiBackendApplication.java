package com.centroinformacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.apachecommons.CommonsLog;

@SpringBootApplication
@CommonsLog
public class ProyectoDawiiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDawiiBackendApplication.class, args);
		log.info("!SISTEMA OKKKKKKKKKK!");
	}

}
