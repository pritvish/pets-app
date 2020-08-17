package com.app.PetStoreApplication.repository;

import com.app.PetStoreApplication.model.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity,Integer> {

    public PetEntity findPetByPetId(Integer id);

}
