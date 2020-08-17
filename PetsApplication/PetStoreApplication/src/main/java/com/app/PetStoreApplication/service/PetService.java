package com.app.PetStoreApplication.service;

import com.app.PetStoreApplication.model.PetDTO;
import com.app.PetStoreApplication.model.PetEntity;
import com.app.PetStoreApplication.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private ModelMapper modelMapper;


    public List<PetDTO> getAllPets() {
        List<PetEntity> allPets = petRepository.findAll();
        return allPets.stream()
                .map(this::convertToPetDTO)
                .collect(Collectors.toList());
    }

    public PetDTO getPetDetails(Integer id) {
        PetEntity pet = petRepository.findPetByPetId(id);
        return convertToPetDTO(pet);
    }

    public PetDTO addPet(PetEntity petEntity) {
        PetEntity savedPetEntity = petRepository.save(petEntity);
        return convertToPetDTO(savedPetEntity);
    }

    public PetDTO updatePet(PetEntity petEntity) {
        PetEntity petById = petRepository.findPetByPetId(petEntity.getPetId());
        if (petById.getPetId() == petEntity.getPetId()) {
            PetEntity updatedPet = petRepository.save(petEntity);
            return convertToPetDTO(updatedPet);
        } else {
            return new PetDTO(); // TODO to be clarified
        }
    }

    public void removePet(Integer id) {
        petRepository.deleteById(id);
    }

    private PetDTO convertToPetDTO(PetEntity petEntity) {
        PetDTO petDTO = modelMapper.map(petEntity, PetDTO.class);
        return petDTO;
    }

}
