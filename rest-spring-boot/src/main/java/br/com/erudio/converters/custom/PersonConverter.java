package br.com.erudio.converters.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.models.Person;
import br.com.erudio.data.vo.v2.PersonVOVersion2;

@Service
public class PersonConverter {

	public PersonVOVersion2 convertEntityToVO(Person person) {
		var vo = new PersonVOVersion2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		
		return vo;
	}
	
	public Person convertVOToEntity(PersonVOVersion2 personVOVersion2) {
		var person = new Person();
		
		person.setId(personVOVersion2.getId());
		person.setAddress(personVOVersion2.getAddress());
		person.setFirstName(personVOVersion2.getFirstName());
		person.setLastName(personVOVersion2.getLastName());
		person.setGender(personVOVersion2.getGender());
		
		return person;
	}
	
}
