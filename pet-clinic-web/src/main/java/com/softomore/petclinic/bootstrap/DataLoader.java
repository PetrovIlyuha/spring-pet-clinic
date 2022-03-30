package com.softomore.petclinic.bootstrap;

import com.softomore.petclinic.model.Owner;
import com.softomore.petclinic.model.PetType;
import com.softomore.petclinic.model.Vet;
import com.softomore.petclinic.services.OwnerService;
import com.softomore.petclinic.services.PetTypeService;
import com.softomore.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);


        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jeremiah");
        owner1.setLastName("Blakemore");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Katy");
        owner2.setLastName("Smith");
        ownerService.save(owner2);

        System.out.println("loaded 2 owners..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Leonard");
        vet1.setLastName("Jackson");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Iona");
        vet2.setLastName("Kirk");

        vetService.save(vet2);

        System.out.println("loaded 2 vets...");
    }

}
