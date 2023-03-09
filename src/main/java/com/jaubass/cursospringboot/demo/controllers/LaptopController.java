package com.jaubass.cursospringboot.demo.controllers;

import com.jaubass.cursospringboot.demo.entities.Laptop;
import com.jaubass.cursospringboot.demo.repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private static Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }


    // CRUD

    // Buscar todas las laptops
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }


    // buscar una laptop por id
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById (@PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);
        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();

        // Lo mismo que arriba pero escrito en programacion funcional
        // return laptopOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build();
    }

    /**
     * Crear una laptop en la bd
     *
     * @param laptop
     * @param headers
     * @return
     */
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));

        if(laptop.getId() != null) {
            log.warn("Trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }


    // Modificar una laptop existente en la base de datos
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {

        if (laptop.getId() == null) {
            log.warn("Trying to create a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())) {
            log.warn("Trying to create a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    /**
     * Borrar un laptop por id
     * @param id
     * @return
     */
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id) {

        if (!laptopRepository.existsById(id)) {
            log.warn("Trying to delete a non existent laptop");
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops/")
    public ResponseEntity<Laptop> deleteAll() {
        log.info("REST Request for deleting all books"); // Log de info
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
