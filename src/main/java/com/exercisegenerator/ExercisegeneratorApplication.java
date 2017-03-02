package com.exercisegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercisegeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercisegeneratorApplication.class, args);

        String defaultCharacterEncoding = System.getProperty("file.encoding");
        System.out.println("defaultCharacterEncoding by property: " + defaultCharacterEncoding);


	}
}
