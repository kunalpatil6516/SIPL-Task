package com.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Data")
public class Controller {
	
	@Autowired
	ServiceMethod logic;
	
	@GetMapping("/getall")
	public List<Person> getallcont(){
		return logic.getall();
	}
	
	@GetMapping("/{id}")
	public Person getviaid(@PathVariable long id) {
		return logic.findById(id);
	}
	
	@PostMapping()
	public Person create(@RequestBody Person data) {
		return logic.creating(data);
	}
	
	@PutMapping("/{id}")
	public Person updating(@PathVariable int id,@RequestBody Person data) {
		Person avail=logic.findById(id);
		avail.setName(data.getName());
		return logic.save(avail);
	}
	
	@DeleteMapping("/{id}")
	public void deleting(@PathVariable int id) {
		logic.delete(id);
	}

}
