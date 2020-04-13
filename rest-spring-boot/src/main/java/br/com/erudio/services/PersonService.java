package br.com.erudio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.converters.DozerConverter;
import br.com.erudio.data.models.Person;
import br.com.erudio.data.vo.PersonVO;
import br.com.erudio.exception.ResourceNotFoundException;
import br.com.erudio.repositories.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public PersonVO create(PersonVO personVO) {
		var entity = DozerConverter.parseObject(personVO, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVO update(PersonVO personVO) {
		var entity = DozerConverter.parseObject(personVO, Person.class);
		Person entityFromDb = repository.findById(entity.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for id " + personVO.getId()));
		
		entityFromDb.setFirstName(personVO.getFirstName());
		entityFromDb.setLastName(personVO.getLastName());
		entityFromDb.setAddress(personVO.getAddress());
		entityFromDb.setGender(personVO.getGender());
		
		return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}
	
	public void delete(Long id) {
		Person personFromDb = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for id " + id));
		
		repository.delete(personFromDb);
	}
	
	public PersonVO findById(Long id) {
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for id " + id));
		return DozerConverter.parseObject(entity, PersonVO.class);			
	}
	
	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
}
