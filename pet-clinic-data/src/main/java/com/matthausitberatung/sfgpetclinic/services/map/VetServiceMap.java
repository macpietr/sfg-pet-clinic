package com.matthausitberatung.sfgpetclinic.services.map;

import com.matthausitberatung.sfgpetclinic.model.Speciality;
import com.matthausitberatung.sfgpetclinic.model.Vet;
import com.matthausitberatung.sfgpetclinic.services.VetService;
import com.matthausitberatung.sfgpetclinic.services.SpacialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpacialtyService specialtyService;

    public VetServiceMap(SpacialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        if(vet.getSpecialities().size()>0){
            vet.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialtyService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }
        return super.save(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
