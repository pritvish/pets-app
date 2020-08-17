package com.app.PetStoreApplication.controller;

import com.app.PetStoreApplication.model.PetDTO;
import com.app.PetStoreApplication.model.PetEntity;
import com.app.PetStoreApplication.service.PetService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class PetController {

//    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PetController.class);

    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public ResponseEntity<List<PetDTO>> getAllPets() {
        List<PetDTO> allPets = petService.getAllPets();
        return new ResponseEntity<List<PetDTO>>(allPets, HttpStatus.OK);
    }

    @GetMapping("/pet")
    public ResponseEntity<PetDTO> getPetDetails(@RequestParam Integer id) {
        PetDTO petDetails = petService.getPetDetails(id);
        return new ResponseEntity<PetDTO>(petDetails, HttpStatus.OK);
    }

    @PostMapping(value = "/pet")
    public ResponseEntity<PetDTO> addPet(@RequestBody PetEntity petEntity) {
        PetDTO petDTO = petService.addPet(petEntity);
        return new ResponseEntity<PetDTO>(petDTO, HttpStatus.OK);
    }

    @PutMapping(value = "/pet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PetDTO> updatePet(@RequestBody PetEntity petEntity) {
        PetDTO petDTO = petService.updatePet(petEntity);
        return new ResponseEntity<PetDTO>(petDTO, HttpStatus.OK);
    }

    @DeleteMapping("/pet")
    public ResponseEntity<String> deletePetDetails(@RequestParam Integer id) {
        petService.removePet(id);
        return new ResponseEntity<String>("successfully deleted pet with id : "+id, HttpStatus.OK);
    }

}
