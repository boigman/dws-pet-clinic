package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Specialty;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialtyService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}

	private void loadData() {
		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedDentistry = specialtyService.save(dentistry);
		Specialty savedSurgery = specialtyService.save(surgery);
		Specialty savedRadiology = specialtyService.save(radiology);
		System.out.println("Loaded Specialties...");

		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);
		System.out.println("Loaded Pet Types...");

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Anytown Drive");
		owner1.setCity("Anytown");
		owner1.setTelephone("313-255-4972");
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setName("Bowser");
		mikesPet.setBirthdate(LocalDate.now().minus(Period.ofDays(10)));
		System.out.println(mikesPet.getName() + "'s Birthday: " + mikesPet.getBirthdate());
		owner1.getPets().add(mikesPet);

		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("456 Squaresville Drive");
		owner2.setCity("Squaresville");
		owner2.setTelephone("313-255-4973");
		Pet fionasCat = new Pet();
		fionasCat.setPetType(savedCatPetType);
		fionasCat.setName("Fluffy");
		fionasCat.setOwner(owner2);
		fionasCat.setBirthdate(LocalDate.now().minus(Period.ofDays(366)));
		System.out.println(fionasCat.getName() + "'s Birthday: " + fionasCat.getBirthdate());
		owner2.getPets().add(fionasCat);
		
	
		ownerService.save(owner2);

		Visit catVisit = new Visit();
		catVisit.setPet(fionasCat);
		catVisit.setDate(LocalDate.now().minus(Period.ofDays(186)));
		catVisit.setDescription("Sneezy kitty");
		System.out.println("Cat Visit: "+catVisit.toString());

		visitService.save(catVisit);

		System.out.println("Loaded Owners...");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialties().add(savedRadiology);

		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet1.getSpecialties().add(savedSurgery);

		vetService.save(vet2);

		System.out.println("Loaded Vets...");

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int count = petTypeService.findAll().size();
		if (count == 0) {
			loadData();
		}

	}

}
