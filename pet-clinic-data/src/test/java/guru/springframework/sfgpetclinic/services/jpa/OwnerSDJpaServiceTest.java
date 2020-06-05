package guru.springframework.sfgpetclinic.services.jpa;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

	private static final long ID = 1L;
	private static final String LAST_NAME = "Smith";
	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetRepository petRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	
	@InjectMocks
	OwnerSDJpaService service;
	
	Owner returnOwner;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		returnOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
	}

	@Test
	void testOwnerSDJpaService() {
//		fail("Not yet implemented");
	}

	@Test
	void testFindByLastName() {
		Owner returnOwner = Owner.builder().id(ID).lastName(LAST_NAME).build();
		
		when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
		
		Owner smith = service.findByLastName(LAST_NAME);
		assertEquals(LAST_NAME,smith.getLastName());
//		fail("Not yet implemented");
	}

	@Test
    void findAll() {
        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().id(1l).build());
        returnOwnersSet.add(Owner.builder().id(2l).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

	@Test
	void testFindById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(ID);
        assertNotNull(owner);
	}

	@Test
	void testSave() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = service.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
	}

	@Test
	void testDelete() {
        service.delete(returnOwner);
        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
	}

	@Test
	void testDeleteById() {
        service.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
	}

}
