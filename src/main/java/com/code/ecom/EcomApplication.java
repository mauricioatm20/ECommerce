package com.code.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomApplication.class, args);
	}

	@Configuration
	public static class Myconfiguration{
		@Bean
		public WebMvcConfigurer corsConfigurer(){
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
							.allowedOrigins("https://ecom-web-mauricio.vercel.app") // dominio del frontend en Vercel
							.allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
							.allowedHeaders("*") // permite todos los encabezados
							.allowCredentials(true); // permite cookies si se necesita autenticación de sesión
				}
			};
		}
	}
}
