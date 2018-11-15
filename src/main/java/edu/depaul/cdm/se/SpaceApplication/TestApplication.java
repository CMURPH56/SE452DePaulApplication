package edu.depaul.cdm.se.SpaceApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    @Autowired
    private PlanetRepository repository;

    public static void main(String args[]){
        SpringApplication.run(TestApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception{
        // Fetch all planets
        System.out.println("Planets found with findAll()");
        for(Planets planet : repository.findAll()){
            System.out.println(planet);
        }
    }
}
