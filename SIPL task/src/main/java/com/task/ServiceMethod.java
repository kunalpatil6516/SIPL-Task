package com.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMethod {
	
	@Autowired
	private Repo repo;
	
	public List<Person> getall(){
		return repo.findAll();
	}

	public Person creating(Person data) {
		return repo.save(data);
		
	}

	public Person findById(long id) {
		return repo.findById(id).orElse(null);
	}

	public Person save(Person avail) {
		return repo.save(avail);
	}

	public void delete(long id) {
		
		repo.deleteById(id);
	}

}
