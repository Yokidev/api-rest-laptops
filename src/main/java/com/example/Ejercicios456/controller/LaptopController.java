package com.example.Ejercicios456.controller;

import com.example.Ejercicios456.entity.Laptop;
import com.example.Ejercicios456.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    //Atributos
    private LaptopRepository laptopRepository;
    //Constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //Operaciones CRUD sobre LAPTOP

    //Devolver todos los laptops
    /**
     * http://localhost:8080/api/laptops
     * @return
     */
    @GetMapping("/api/laptops")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Laptop> findAll(){
        return laptopRepository.findAll();
    }


    /**
     * Encontrar por id
     * @param id
     * @return
     */

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){

        Optional<Laptop> laptopOptional = laptopRepository.findById(id);

        if(laptopOptional.isPresent()){
            return ResponseEntity.ok(laptopOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear un laptop
     * @param laptop
     * @param headers
     * @return
     */
    @PostMapping("/api/laptops")
    public ResponseEntity<Laptop> create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        //guardar Laptop recibido por parametros en la base de datos
        if(laptop.getId() != null){
            return ResponseEntity.badRequest().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar un laptop existente
     * @return
     */
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){

        if(laptop.getId()==null){
            return ResponseEntity.badRequest().build();
        }
        if (!laptopRepository.existsById(laptop.getId())){
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> deleteOneById(@PathVariable Long id){

        if(!laptopRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        laptopRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    /**
     * Eliminar todos los laptops
     * @return
     */
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
