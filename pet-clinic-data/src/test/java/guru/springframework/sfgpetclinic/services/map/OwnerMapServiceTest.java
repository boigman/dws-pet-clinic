package guru.springframework.sfgpetclinic.services.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.map.PetTypeMapService;

class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Smith";
	
//	private Set<Owner> ownerSet = new HashSet<>();

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testOwnerServiceMap() {
//		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		Set<Owner> ownerSet = ownerMapService.findAll();
		assertEquals(1, ownerSet.size());
//		fail("Not yet implemented");
	}

	@Test 
	void testFindByIdLong() {
		Owner owner = ownerMapService.findById(ownerId);
		assertEquals(ownerId, owner.getId()); 
	}
	
	@Test 
	void testSaveOwner() { 
		Long id = 2L;
		String xLastName = "Wongo";
		Integer preSize = ownerMapService.findAll().size();
		Owner owner2 = Owner.builder().id(id).lastName(xLastName).build();
		ownerMapService.save(owner2);
		assertEquals(preSize+1, ownerMapService.findAll().size());
	}

	@Test 
	void testDeleteOwner() {
		Long id = 3L;
		String xLastName = "Trongo";
		Integer preSize = ownerMapService.findAll().size();
		Owner owner3 = Owner.builder().id(id).lastName(xLastName).build();
		ownerMapService.save(owner3);
		assertEquals(preSize+1, ownerMapService.findAll().size());
		ownerMapService.delete(owner3);
		assertEquals(preSize, ownerMapService.findAll().size());
	}

	@Test 
	void testDeleteByIdLong() {
		Long id = 4L;
		String xLastName = "Quongo";
		Integer preSize = ownerMapService.findAll().size();
		Owner owner4 = Owner.builder().id(id).lastName(xLastName).build();
		ownerMapService.save(owner4);
		assertEquals(preSize+1, ownerMapService.findAll().size());
		ownerMapService.deleteById(id);
		assertEquals(preSize, ownerMapService.findAll().size());
	}

	@Test 
	void testFindByLastName() {
		Long id = 5L;
		String xLastName = "Quintongo";
		Integer preSize = ownerMapService.findAll().size();
		Owner owner5 = Owner.builder().id(id).lastName(xLastName).build();
		assertNotNull(owner5);
		ownerMapService.save(owner5);
		assertEquals(xLastName, ownerMapService.findByLastName(xLastName).getLastName());
	}

}

