package br.com.barrostech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.barrostech.model.User;
import br.com.barrostech.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public Page<User> findAll(@RequestParam int page, @RequestParam int size){

		Pageable pageable = PageRequest.of(page, size);
		return repository.findAll(pageable);
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user){
		return ResponseEntity.ok().body(repository.save(user));
	}

	@PutMapping
	public ResponseEntity<User> edit(@RequestBody User user){
		return ResponseEntity.ok().body(repository.save(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<User>> detail(@PathVariable Long id){
		Optional<User> user = repository.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
