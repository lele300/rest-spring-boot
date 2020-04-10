package br.com.erudio.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.erudio.models.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leonardo");
		person.setLastName("Lopes");
		person.setAddress("Mogi das Cruzes - São Paulo - Brasil");
		person.setGender("Male");
		return person;
	}
}
