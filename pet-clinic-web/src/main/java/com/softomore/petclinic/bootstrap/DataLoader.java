package com.softomore.petclinic.bootstrap;

import com.softomore.petclinic.model.Owner;
import com.softomore.petclinic.model.Pet;
import com.softomore.petclinic.model.PetType;
import com.softomore.petclinic.model.Vet;
import com.softomore.petclinic.services.OwnerService;
import com.softomore.petclinic.services.PetTypeService;
import com.softomore.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        Owner jeremiah = new Owner();
        jeremiah.setFirstName("Jeremiah");
        jeremiah.setLastName("Blakemore");
        jeremiah.setAddress("120, Grassy Road");
        jeremiah.setCity("Dublin");
        jeremiah.setTelephone("5-209-039-2939");

        Pet jeremiahsDog = new Pet();
        jeremiahsDog.setPetType(savedDogPetType);
        jeremiahsDog.setOwner(jeremiah);
        jeremiahsDog.setBirthDate(LocalDate.of(2019, 3, 10));
        jeremiahsDog.setName("Bony");
        jeremiah.getPets().add(jeremiahsDog);


        ownerService.save(jeremiah);

        Owner katy = new Owner();
        katy.setFirstName("Katy");
        katy.setLastName("Smith");
        katy.setAddress("30, Hill Street");
        katy.setCity("Zurich");
        katy.setTelephone("1-531-491-98238");

        Pet katysCat = new Pet();
        katysCat.setPetType(savedCatPetType);
        katysCat.setOwner(katy);
        katysCat.setBirthDate(LocalDate.of(2020,10,20));
        katysCat.setName("Moon");
        katy.getPets().add(katysCat);

        ownerService.save(katy);

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
