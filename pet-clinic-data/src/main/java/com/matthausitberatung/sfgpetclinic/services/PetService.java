package com.matthausitberatung.sfgpetclinic.services;

import com.matthausitberatung.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
