package tn.esprit.com.foyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.foyer.entities.Reservation;
import tn.esprit.com.foyer.entities.Universite;
import tn.esprit.com.foyer.services.UniversiteServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteController {
    UniversiteServices universiteServices;

    @GetMapping("/retrieve-all-universite")
    public List<Universite> retrieveAllUniversite(){
        return universiteServices.retrieveAllUniversities();
    }

    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long universiteId){
        return universiteServices.retrieveUniversity(universiteId);
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteServices.addUniversity(u);
    }

    @DeleteMapping("/delete-universite/{universite-id}")
    public void deleteUniversite(@PathVariable("universite-id") Long universiteId){
        universiteServices.removeUniversity(universiteId);
    }
}