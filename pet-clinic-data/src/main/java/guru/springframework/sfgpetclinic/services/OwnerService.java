package guru.springframework.sfgpetclinic.services;

import java.util.List;

import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);
	
}
