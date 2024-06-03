package com.example.gestioninventaireserveur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class GestionInventaireServeurApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionInventaireServeurApplication.class, args);
    }

}
