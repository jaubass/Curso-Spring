package com.jaubass.cursospringboot.demo;

import com.jaubass.cursospringboot.demo.entities.Laptop;
import com.jaubass.cursospringboot.demo.repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Main.class, args);
        LaptopRepository repository = context.getBean(LaptopRepository.class);

        // CRUD
        // Create
        Laptop laptop1 = new Laptop(null, "MacBook Air", 1399d, LocalDate.of(2022, 6, 14), true);
        Laptop laptop2 = new Laptop(null, "Asus", 1099d, LocalDate.of(2021, 3, 22), true);

        // Save
        repository.save(laptop1);
        repository.save(laptop2);

        // Retrieve
        System.out.println("Ordenadores en la base de datos: " + repository.findAll().size());
        repository.findAll();

        // Borrar
        //repository.deleteById(1L);
        //System.out.println("Ordenadores en la base de datos: " + repository.findAll().size());

    }
}
