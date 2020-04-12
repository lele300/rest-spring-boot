package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.models.Person;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person update(Person person) {
		Person personFromDb = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for id " + person.getId()));
		
		personFromDb.setFirstName(person.getFirstName());
		personFromDb.setLastName(person.getLastName());
		personFromDb.setAddress(person.getAddress());
		personFromDb.setGender(person.getGender());
		
		return repository.save(personFromDb);
	}
	
	public void delete(Long id) {
		Person personFromDb = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for id " + id));
		
		repository.delete(personFromDb);
	}
	
	public Person findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for id " + id));
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
}
