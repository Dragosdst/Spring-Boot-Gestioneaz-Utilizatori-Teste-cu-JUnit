package com.example.demo.service;

import com.example.demo.entity.PersonEntity;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public List<PersonEntity> getAllUsers() {
        return personRepository.findAll();
    }


    public Optional<PersonEntity> getUserById(Long id) {
        return personRepository.findById(id);
    }


    public void createPerson(PersonEntity person) {
        personRepository.save(person);
    }


    public String deleteUser(Long id) {
        Optional<PersonEntity> existingPersonOptional = personRepository.findById(id);
        if (existingPersonOptional.isPresent()) {
            personRepository.deleteById(id);
            return "Utilizatorul a fost șters cu succes.";
        } else {
            return "Utilizatorul nu a fost găsit.";
        }
    }

    public String updatePerson(Long id, PersonEntity updatedPerson) {
        Optional<PersonEntity> existingPersonOptional = personRepository.findById(id);
        if (existingPersonOptional.isPresent()) {
            PersonEntity existingPerson = existingPersonOptional.get();

            // Verificăm dacă obiectul actualizat nu este null
            if (updatedPerson != null) {
                // Verificăm și actualizăm numele, dacă este diferit de null și nu este gol
                if (updatedPerson.getNume() != null && !updatedPerson.getNume().isEmpty()) {
                    existingPerson.setNume(updatedPerson.getNume());
                }
                // Verificăm și actualizăm prenumele, dacă este diferit de null și nu este gol
                if (updatedPerson.getPrenume() != null && !updatedPerson.getPrenume().isEmpty()) {
                    existingPerson.setPrenume(updatedPerson.getPrenume());
                }
                // Verificăm și actualizăm emailul, dacă este diferit de null și nu este gol
                if (updatedPerson.getEmail() != null && !updatedPerson.getEmail().isEmpty()) {
                    existingPerson.setEmail(updatedPerson.getEmail());
                }
                // Verificăm și actualizăm varsta, dacă este diferit de null
                if (updatedPerson.getVarsta() != null) {
                    existingPerson.setVarsta(updatedPerson.getVarsta());
                }

                // Salvăm modificările în baza de date
                personRepository.save(existingPerson);
                return "Utilizatorul a fost actualizat cu succes.";
            } else {
                return "Obiectul actualizat este null.";
            }
        } else {
            return "Utilizatorul nu a fost găsit.";
        }
    }
}