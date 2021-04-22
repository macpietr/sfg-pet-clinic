package com.matthausitberatung.sfgpetclinic.bootstrap;

import com.matthausitberatung.sfgpetclinic.model.Owner;
import com.matthausitberatung.sfgpetclinic.model.Pet;
import com.matthausitberatung.sfgpetclinic.model.PetType;
import com.matthausitberatung.sfgpetclinic.model.Vet;
import com.matthausitberatung.sfgpetclinic.services.OwnerService;
import com.matthausitberatung.sfgpetclinic.services.PetTypeService;
import com.matthausitberatung.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddres("123 Brickeler");
        owner1.setAddres("Sosnowiec");
        owner1.setTelephone("31321321");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDay(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddres("123 Brickeler");
        owner2.setAddres("Sosnowiec");
        owner2.setTelephone("31321321");

        Pet finasCat = new Pet();
        finasCat.setName("Just cat");
        finasCat.setOwner(owner2);
        finasCat.setBirthDay(LocalDate.now());
        finasCat.setPetType(savedCatPetType);
        owner2.getPets().add(finasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samuel");
        vet2.setLastName("Axexe");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
