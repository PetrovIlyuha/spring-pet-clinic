package com.softomore.petclinic.bootstrap;

import com.softomore.petclinic.model.Owner;
import com.softomore.petclinic.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.VetService;
import services.map.OwnerServiceMap;
import services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jeremiah");
        owner1.setLastName("Blakemore");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Katy");
        owner2.setLastName("Smith");
        ownerService.save(owner2);

        System.out.println("loaded 2 owners..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Leonard");
        vet1.setLastName("Jackson");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Iona");
        vet2.setLastName("Kirk");

        vetService.save(vet2);

        System.out.println("loaded 2 vets...");
    }

}
