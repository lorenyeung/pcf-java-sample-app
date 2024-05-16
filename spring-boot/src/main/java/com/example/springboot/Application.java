package com.example.springboot;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import com.example.springboot.LoggableException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


		while(true) {
            System.out.println("This is an infinite loop. Press Ctrl+C to terminate.");
			try {
                Thread.sleep(5000); // Sleep for 5 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			try {
				// This will always throw an exception
				throw new LoggableException("This is an intentionally thrown exception");
			} catch (LoggableException e) {
				// Handle the exception gracefully
				System.out.println("Exception caught: " + e.getMessage());
			}
		}
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}
