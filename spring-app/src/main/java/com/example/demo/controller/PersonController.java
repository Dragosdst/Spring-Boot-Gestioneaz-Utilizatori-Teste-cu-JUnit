package com.example.demo.controller;

import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/persoane")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/ToatePersoanele")
    public List<PersonEntity> aduToatePersoanele() {
        return personService.getAllUsers();
    }


    @GetMapping("/{id}")
    public Object getUserById(@PathVariable Long id) {
        return personService.getUserById(id);
    }


    @PostMapping("/creare")
    public ResponseEntity<String> createPerson(@Valid @RequestBody PersonEntity person) {
        personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Utilizatorul a fost creat cu succes.");
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        String message = personService.deleteUser(id);
        return ResponseEntity.ok().body(message);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @Valid @RequestBody PersonEntity updatedPerson) {
        String message = personService.updatePerson(id, updatedPerson);
        if (message.equals("Utilizatorul a fost actualizat cu succes.")) {
            return ResponseEntity.ok().body(message);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }
}



