package com.graphometrica.rosatom_2021_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.graphometrica.rosatom_2021_backend.config")
public class GraphometricaRosatom2021BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphometricaRosatom2021BackendApplication.class, args);
    }

}
