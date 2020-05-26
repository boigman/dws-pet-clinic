package guru.springframework.sfgpetclinic.services.jpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService{

	private final VetRepository vetRepository;
//	private final SpecialtyRepository specialtyRepository;
	
	public VetSDJpaService(VetRepository vetRepository) {
		super();
		this.vetRepository = vetRepository;
	}
	
	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets=new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}


	@Override
	public Vet findById(Long aLong) {
		return vetRepository.findById(aLong).orElse(null);
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		// TODO Auto-generated method stub
		vetRepository.delete(object);
	}

	@Override
	public void deleteById(Long aLong) {
		// TODO Auto-generated method stub
		vetRepository.deleteById(aLong);
	}

	
}
