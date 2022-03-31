package com.softomore.petclinic.bootstrap;

import com.softomore.petclinic.model.*;
import com.softomore.petclinic.services.OwnerService;
import com.softomore.petclinic.services.PetTypeService;
import com.softomore.petclinic.services.SpecialtyService;
import com.softomore.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)
            loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Specialty surgery = new Specialty();
        surgery.setDescription("surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

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
        katysCat.setBirthDate(LocalDate.of(2020, 10, 20));
        katysCat.setName("Moon");
        katy.getPets().add(katysCat);

        ownerService.save(katy);

        System.out.println("loaded 2 owners..");

        Vet LeonardVet = new Vet();
        LeonardVet.setFirstName("Leonard");
        LeonardVet.setLastName("Jackson");
        LeonardVet.getSpecialties().add(savedRadiology);
        vetService.save(LeonardVet);

        Vet IonaVet = new Vet();
        IonaVet.setFirstName("Iona");
        IonaVet.setLastName("Kirk");
        IonaVet.getSpecialties().add(savedDentistry);
        IonaVet.getSpecialties().add(savedSurgery);
        vetService.save(IonaVet);

        System.out.println("loaded 2 vets...");
    }

}
