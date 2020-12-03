package com.matthausitberatung.sfgpetclinic.services.map;

import com.matthausitberatung.sfgpetclinic.model.Pet;
import com.matthausitberatung.sfgpetclinic.services.PetService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Pet Pet) {
        super.delete(Pet);
    }

    @Override
    public Pet save(Pet Pet) {
        return super.save(Pet.getId(), Pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
