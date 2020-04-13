package br.com.erudio.converters.mocks;

import java.util.ArrayList;
import java.util.List;

import br.com.erudio.data.models.Person;
import br.com.erudio.data.vo.PersonVO;

public class MockPerson {
	
	public Person mockEntity() {
		return mockEntity(0);
	}
	
	public PersonVO mockVO() {
		return mockVO(0);
	}
	
	public List<Person> mockEntityList() {
		List<Person> persons = new ArrayList<Person>();
		for(int i = 0; i < 14; i++) {
			persons.add(mockEntity(i));
		}
		
		return persons;
	}
	
	public List<PersonVO> mockVOList() {
		List<PersonVO> personsVO = new ArrayList<PersonVO>();
		for(int i = 0; i < 14; i++) {
			personsVO.add(mockVO(i));
		}
		
		return personsVO;
	}
	
	private Person mockEntity(Integer number) {
		Person person = new Person();
		person.setAddress("Address Test" + number);
		person.setFirstName("First Name Test" + number);
		person.setLastName("Last Name Test"+ number);
		person.setId(number.longValue());
		person.setGender( (number % 2 == 0) ? "Male" : "Female");
		
		return person;
	}
	
	private PersonVO mockVO(Integer number) {
		PersonVO personVO = new PersonVO();
		personVO.setAddress("Address Test" + number);
		personVO.setFirstName("First Name Test" + number);
		personVO.setLastName("Last Name Test"+ number);
		personVO.setId(number.longValue());
		personVO.setGender( (number % 2 == 0) ? "Male" : "Female");
		
		return personVO;
	}

}
